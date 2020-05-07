package local.hapra.pongxxjava.impl;

import local.hapra.pongxxjava.kernel.Coordinates;
import local.hapra.pongxxjava.kernel.KIEngineAbstract;
import local.hapra.pongxxjava.kernel.Speed;

/**
 * KI Engine Implementation
 * hinzugefügt von andbra im Feb 2020
 */
@SuppressWarnings("FieldCanBeLocal")
public class KIEngine extends KIEngineAbstract {

    private int getDirection(int value) {

        return Integer.compare(value, 0);
    }

    private int getAcceleration(int value) {

        final int MAX_ACCELERATION = (int) 9.81f;
        return Math.min(MAX_ACCELERATION, Math.abs(value));
    }

    public KIEngine(int p2GraphicWidth, int p2GraphicHeight, int contextWidth, int contextHeight) {

        super(p2GraphicWidth, p2GraphicHeight, contextWidth, contextHeight);
    }

    @Override
    public void updateSpeed(Speed paddle2Speed, Coordinates paddle2Coord, Speed ballSpeed, Coordinates ballCoord) {

        int xCoordDiff = ballCoord.getX() - paddle2Coord.getX();
        paddle2Speed.setX(getAcceleration(xCoordDiff));
        paddle2Speed.setXDirection(getDirection(xCoordDiff));
    }
}
