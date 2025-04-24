package edu.up.cs301.bahbl;

/**
 * class for the end screen timer (bad ending)
 * @author Savannah I. Macdonald
 * @author Laura A. Patla
 * @author Madilynn Greenup
 * @version April 2025
 */

import java.util.TimerTask;

public class BahTimer extends TimerTask {
    BahGameState gameState;
    public BahTimer(BahGameState state){
        super();
        gameState = state;
    }

    @Override
    public void run() {
        long now = System.currentTimeMillis();
        if (now - gameState.endSceneStartTime >= 10000) {
            gameState.nextEndScene(true);  // final end screen
        }
    }
}
