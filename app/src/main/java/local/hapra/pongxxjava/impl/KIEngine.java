package local.hapra.pongxxjava.impl;

import local.hapra.pongxxjava.kernel.Coordinates;
import local.hapra.pongxxjava.kernel.KIEngineAbstract;
import local.hapra.pongxxjava.kernel.Speed;

/**
 * KI Engine Implementation
 * hinzugefügt von andbra im Feb 2020
 */
public class KIEngine extends KIEngineAbstract {

    // the pixel correct widths of the images used to calculate a ratio
    // see constructor
    private static final float ORIGINAL_PADDLE_WIDTH = 80.0f;
    private static final float ORIGINAL_BALL_WIDTH = 10.0f;
    private static final float ORIGINAL_WIDTH_RATIO = ORIGINAL_BALL_WIDTH / ORIGINAL_PADDLE_WIDTH;

    // pre calculated values
    private int halfPaddleWidth;
    private int halfBallWidth;

    public KIEngine(int p2GraphicWidth, int p2GraphicHeight, int contextWidth, int contextHeight) {

        super(p2GraphicWidth, p2GraphicHeight, contextWidth, contextHeight);
        this.halfPaddleWidth = p2GraphicWidth >> 1;

        int ballWidth = (int) ((float) p2GraphicWidth * ORIGINAL_WIDTH_RATIO);
        this.halfBallWidth = ballWidth >> 1;
    }

    @Override
    public void updateSpeed(Speed paddle2Speed, Coordinates paddle2Coord, Speed ballSpeed, Coordinates ballCoord) {

        // the real coordinates as the normal coordinates are not the middle of the object
        int realBallCoordinateX = ballCoord.getX() + this.halfBallWidth;
        int realPaddleCoordinateX = paddle2Coord.getX() + this.halfPaddleWidth;

        // calculate the speed of the ball on the x axis
        int realBallSpeedX = ballSpeed.getXDirection() * ballSpeed.getX();

        int nextBallCoordinateX = realBallCoordinateX + realBallSpeedX;

        int xCoordDiff = nextBallCoordinateX - realPaddleCoordinateX;

        // set the paddle speed to match the next ball coordinate
        paddle2Speed.setX(getAcceleration(xCoordDiff));
        paddle2Speed.setXDirection(getDirection(xCoordDiff));
    }

    private int getDirection(int value) {

        return Integer.compare(value, 0);
    }

    private int getAcceleration(int value) {

        // Cap the speed of the ai to be fair to the player
        final int MAX_ACCELERATION = (int) 9.81f;

        return Math.min(MAX_ACCELERATION, Math.abs(value));
    }
}
