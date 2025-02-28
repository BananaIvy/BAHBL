package edu.up.cs301.bahbl;

import android.util.Log;

import edu.up.cs301.GameFramework.LocalGame;
import edu.up.cs301.GameFramework.actionMessage.GameAction;
import edu.up.cs301.GameFramework.infoMessage.GameState;

/**
 * A class that represents the state of a game. In our counter game, the only
 * relevant piece of information is the value of the game's counter. The
 * CounterState object is therefore very simple.
 *
 * @author Steven R. Vegdahl
 * @author Andrew M. Nuxoll
 * @version July 2013
 */
public class BAHBLLocalGame extends LocalGame {

    // When a counter game is played, any number of players. The first player
    // is trying to get the counter value to TARGET_MAGNITUDE; the second player,
    // if present, is trying to get the counter to -TARGET_MAGNITUDE. The
    // remaining players are neither winners nor losers, but can interfere by
    // modifying the counter.
    public static final int TARGET_MAGNITUDE = 10;

    // the game's state
    private BAHBLGameState gameState;
    private BAHBLCustomerBase customerBase;

    /**
     * can this player move
     *
     * @return true, because all player are always allowed to move at all times,
     * as this is a fully asynchronous game
     */
    @Override
    protected boolean canMove(int playerIdx) {
        return true;
    }

    /**
     * This ctor should be called when a new counter game is started
     */
    public BAHBLLocalGame(GameState state) {
        // initialize the game state, with the counter value starting at 0
        if (!(state instanceof BAHBLGameState)) {
            state = new BAHBLGameState();
        }
        this.gameState = (BAHBLGameState) state;
        super.state = state;
    }

    /**
     * The only type of GameAction that should be sent is CounterMoveAction
     */
    @Override
    protected boolean makeMove(GameAction action) {
        Log.i("action", action.getClass().toString());

        if (action instanceof BAHBLButtonAction) {

            //if(customerBase.getGoodButton() == 1)
            // cast so that we Java knows it's a CounterMoveAction
            BAHBLButtonAction cma = (BAHBLButtonAction) action;

            return true;
        } else {
            // Update the counter values based upon the action
            int result = gameState.getStoryProgress() + 1;
            gameState.setStoryProgress(result);

            // denote that this was a legal/successful move
            return true;
        }
		else{
            // denote that this was an illegal move
            return false;
        }
        //return false;
        return false;
    }
}//makeMove
