package local.hapra.pongxxjava.kernel;

import android.content.Context;
import android.graphics.Canvas;

import java.io.Serializable;

/**
 * Abstrakte Oberklasse aller Spielelemente
 * aktualisiert von andbra im Feb 2020
 * - Variablen nach BitMapGameObjekt verschoben
 *- Context hinzugefügt
 * @author Jan Bauerdick
 *
 */
public abstract class GameObject implements Serializable {

    private int contextWidth;
    private int contextHeight;

    public GameObject(int contextWidth, int contextHeight) {
        this.contextWidth = contextWidth;
        this.contextHeight = contextHeight;
    }


    /**
     * hinzugefügt von andbra im Feb 2020
     */
    public abstract void draw(Canvas canvas);

    public int getContextHeight() {
        return contextHeight;
    }

    public int getContextWidth() {
        return contextWidth;
    }
}

