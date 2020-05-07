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

    private static int ORIGINAL_PADDLE_WIDTH = 80;
    private static int ORIGINAL_BALL_WIDTH = 10;

    private int halfPaddleWidth;
    private int halfBallWidth;

    public KIEngine(int p2GraphicWidth, int p2GraphicHeight, int contextWidth, int contextHeight) {

        super(p2GraphicWidth, p2GraphicHeight, contextWidth, contextHeight);
        this.halfPaddleWidth = p2GraphicWidth >> 1;

        int ballWidth = p2GraphicWidth * (ORIGINAL_BALL_WIDTH / ORIGINAL_PADDLE_WIDTH);
        this.halfBallWidth = ballWidth >> 1;
    }

    @Override
    public void updateSpeed(Speed paddle2Speed, Coordinates paddle2Coord, Speed ballSpeed, Coordinates ballCoord) {

        int xCoordDiff = ((ballCoord.getX() + halfBallWidth) + (ballSpeed.getXDirection() * ballSpeed.getX())) - (paddle2Coord.getX() + this.halfPaddleWidth);

        paddle2Speed.setX(getAcceleration(xCoordDiff));
        paddle2Speed.setXDirection(getDirection(xCoordDiff));
    }

    private int getDirection(int value) {

        return Integer.compare(value, 0);
    }

    private int getAcceleration(int value) {

        final int MAX_ACCELERATION = (int) 9.81f;
        return Math.min(MAX_ACCELERATION, Math.abs(value));
    }
}
