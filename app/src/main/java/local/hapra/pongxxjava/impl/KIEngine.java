package local.hapra.pongxxjava.impl;

import local.hapra.pongxxjava.kernel.Speed;
import local.hapra.pongxxjava.kernel.Coordinates;
import local.hapra.pongxxjava.kernel.KIEngineAbstract;

/**
 * KI Engine Implementation
 * hinzugefügt von andbra im Feb 2020
 */
@SuppressWarnings("FieldCanBeLocal")
public class KIEngine extends KIEngineAbstract {

    public KIEngine(int p2GraphicWidth, int p2GraphicHeight, int contextWidth, int contextHeight) {
        super(p2GraphicWidth, p2GraphicHeight, contextWidth, contextHeight);
    }

    // unbesiegbarer Spieler
    @Override
    public void updateSpeed(Speed paddle2Speed, Coordinates paddle2Coord, Speed ballSpeed, Coordinates ballCoord) {
        // beschreibar: paddle2Speed
        // nur lesend: paddle2Coord, ballSpeed, ballCoord
        // TODO KIEngine
    }
}
