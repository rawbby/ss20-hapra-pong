package local.hapra.pongxxjava.kernel;

import android.content.Context;

import java.io.Serializable;

/**
 * erstellt von andbra im Feb 2020
 * https://developer.android.com/reference/android/hardware/SensorManager
 * https://developer.android.com/reference/android/hardware/Sensor.html#TYPE_ROTATION_VECTOR
 */
public abstract class OrientationAbstract implements Serializable {

    private Context context;

    public OrientationAbstract(Context context) {
        this.context = context;
    }

    public Context getContext(){
        return context;
    }

    /**
     * Die Funktion gibt einen positiven Wert der X-Achsen-Beschleunigung von 0-10 zurück.
     * @return OrientationInterface.ACCEL_POSITVE oder OrientationInterface.ACCEL_NEGATIVE
     */
    public abstract float getXAcceleration();

    /**
     * Die Funktion gibt eine Information zurück, ob die Beschleunigung auf der X-Achse positiv (OrientationInterface.ACCEL_POSITVE) oder negativ (OrientationInterface.ACCEL_NEGATIVE) ist.
     * @return Speed.X_DIRECTION_LEFT or Speed.X_DIRECTION_RIGHT
     */
    public abstract int getXDirection();

    /**
     * Die Funktion gibt einen positiven Wert der Y-Achsen-Beschleunigung von 0-10 zurück.
     * @return OrientationInterface.ACCEL_POSITVE oder OrientationInterface.ACCEL_NEGATIVE
     */
    public abstract float getYAcceleration();

    /**
     * Die Funktion gibt eine Information zurück, ob die Beschleunigung auf der Y-Achse positiv (OrientationInterface.ACCEL_POSITVE) oder negativ (OrientationInterface.ACCEL_NEGATIVE) ist.
     * @return Speed.Y_DIRECTION_UP or Speed.Y_DIRECTION_DOWN
     */
    public abstract int getYDirection();

    /**
     * Startet die Aktualisierung des Beschleunigungssensors, indem der EventListener im Sensor Manager registriert wird
     */
    public abstract void startAccelSensor();

    /**
     * Stopt die Aktualisierung des Beschleunigungssensors, indem der EventListener im Sensor Manager unregistriert wird
     */
    public abstract void stopAccelSensor();

}
