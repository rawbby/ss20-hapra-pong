package local.hapra.pongxxjava.impl;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

import java.util.concurrent.atomic.AtomicBoolean;

import local.hapra.pongxxjava.kernel.OrientationAbstract;
import local.hapra.pongxxjava.kernel.Speed;


/**
 * Zugriff auf den Beschleunigunssensor
 * aktualisiert von andbra im Feb 2020
 *
 * @author Jan Bauerdick
 */
public class Orientation extends OrientationAbstract {

    private class MySensorEventListener implements SensorEventListener {

        private int getDirection(float acceleration) {
            return Float.compare(acceleration, 0.0f);
        }
        private float getAcceleration(float acceleration) {
            return Math.abs(acceleration);
        }

        @Override
        public void onSensorChanged(SensorEvent event) {

            if (event.sensor == null) {
                return;
            }

            int sensorType = event.sensor.getType();
            if (sensorType != Sensor.TYPE_ACCELEROMETER) {
                return;
            }

            // handle
            float[] values = event.values;

            Orientation.this.xAcceleration = getAcceleration(values[0]);
            Orientation.this.yAcceleration = getAcceleration(values[1]);
            Orientation.this.xDirection = getDirection(values[0]);
            Orientation.this.yDirection = getDirection(values[1]);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    }

    private Context context;

    private final Object LOCK = new Object();
    private boolean listenerRegistered;
    private SensorManager sensorManager;
    private Sensor sensor;
    private SensorEventListener sensorEventListener;

    private float xAcceleration;
    private float yAcceleration;

    private int xDirection;
    private int yDirection;

    public Orientation(Context context) {

        super(context);
        this.context = context;
        this.listenerRegistered = false;
        this.sensorEventListener = new MySensorEventListener();

        this.xAcceleration = 0.0f;
        this.yAcceleration = 0.0f;
        this.xDirection = 0;
        this.yDirection = 0;

        sensorManager = (SensorManager) this.context.getSystemService(Context.SENSOR_SERVICE);
        assert sensorManager != null;

        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

    }

    @Override
    public float getXAcceleration() {

        // Die Funktion gibt einen positiven Wert der X-Achsen-Beschleunigung von 0-10 zurück.
        return this.xAcceleration;
    }

    @Override
    public float getYAcceleration() {

        // Die Funktion gibt einen positiven Wert der y-Achsen-Beschleunigung von 0-10 zurück.
        return this.yAcceleration;
    }

    @Override
    public int getXDirection() {

        // Speed.X_DIRECTION_LEFT or Speed.X_DIRECTION_RIGHT
        return this.xDirection;
    }

    @Override
    public int getYDirection() {

        // Speed.Y_DIRECTION_UP or Speed.Y_DIRECTION_DOWN
        return this.yDirection;
    }

    @Override
    public void startAccelSensor() {

        synchronized (LOCK) {

            if (listenerRegistered) {
                return;
            }

            sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_GAME);
            listenerRegistered = true;
        }
    }

    @Override
    public void stopAccelSensor() {

        synchronized (LOCK) {

            if (!listenerRegistered) {
                return;
            }

            sensorManager.unregisterListener(sensorEventListener, sensor);
            listenerRegistered = false;
        }
    }
}
