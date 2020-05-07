package local.hapra.pongxxjava.kernel;

import android.graphics.Bitmap;

import java.util.Date;
import java.util.Random;

/**
 * Zeichnet einen Ball auf dem Display
 * aktualisiert von andbra im Feb 2020
 * - resetBall hinzugefügt
 * @author Jan Bauerdick
 *
 */
public class Ball extends BitMapGameObject {

    public Ball(Bitmap bitmap, int contextWidth, int contextHeight ) {
        super(bitmap, contextWidth, contextHeight);
    }

    /**
     * Setzt den Ball für die nächste Runde zurück
     */
    public void resetBall(){
        Random rnd = new Random(new Date().getTime());
        int x = rnd.nextInt(2) + 1;
        int y = rnd.nextInt(2) + 1;

        boolean right = rnd.nextBoolean();
        boolean down = rnd.nextBoolean();
        getCoordinates().setX(
                getContextWidth() / 2 - getGraphic().getWidth() / 2);
        getCoordinates().setY(
                getContextHeight() / 2 - getGraphic().getHeight() / 2);
        getSpeed().setX(x);
        getSpeed().setY(y);
        getSpeed().setXDirection(
                right ? Speed.X_DIRECTION_RIGHT
                        : Speed.X_DIRECTION_LEFT);
        getSpeed().setYDirection(
                down ? Speed.Y_DIRECTION_DOWN
                        : Speed.Y_DIRECTION_UP);
    }

}