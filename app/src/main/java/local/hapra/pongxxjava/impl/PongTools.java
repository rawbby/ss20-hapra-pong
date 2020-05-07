package local.hapra.pongxxjava.impl;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;

/**
 * hinzugefügt von andbra im Feb 2020
 */
public class PongTools {

    private static VibrationEffect goalVibrationEffect;
    private static VibrationEffect paddleVibrationEffect;

    static {

        long durationGoal = 1000;
        int amplitudeGoal = 255; // Volle Moehre
        goalVibrationEffect = VibrationEffect.createOneShot(durationGoal, amplitudeGoal);

        long durationPaddle = 100;
        int amplitudePaddle = 128; // Halbe Moehre
        paddleVibrationEffect = VibrationEffect.createOneShot(durationPaddle, amplitudePaddle);
    }

    private static void vibrate(Context context, VibrationEffect effect) {

        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);

        if (v == null) {
            Log.e(PongTools.class.getName(), "could not vibrate! :/ Poor User...");
            return;
        }

        v.vibrate(effect);
    }

    /**
     * Diese Funktion wird bei einem Goal aufgerufen und löst einen längeren Impuls aus
     *
     * @param context der Context für den Zugriff auf den SystemService
     */
    public static void vibrateGoal(Context context) {

        vibrate(context, goalVibrationEffect);
    }

    /**
     * .VIB
     * Diese Funktion wird bei einer Kollision mit einem Paddle aufgeruden und löst einen kürzeren Impuls aus
     *
     * @param context der Context für den Zugriff auf den SystemService
     */
    public static void vibratePaddle(Context context) {

        vibrate(context, paddleVibrationEffect);
    }
}
