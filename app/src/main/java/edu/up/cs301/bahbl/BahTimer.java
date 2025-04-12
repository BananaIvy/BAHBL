package edu.up.cs301.bahbl;

import java.util.TimerTask;

public class BahTimer extends TimerTask {
    BahGameState gameState;
    public BahTimer(BahGameState state){
        super();
        gameState = state;
    }

    @Override
    public void run() {
        gameState.nextEndScene(true);
    }
}
