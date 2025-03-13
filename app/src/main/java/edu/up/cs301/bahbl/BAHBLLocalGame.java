package edu.up.cs301.bahbl;

import android.util.Log;

import edu.up.cs301.GameFramework.LocalGame;
import edu.up.cs301.GameFramework.actionMessage.GameAction;
import edu.up.cs301.GameFramework.infoMessage.GameState;
import edu.up.cs301.GameFramework.players.GamePlayer;

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
    private BAHBLCustomerBase customer = gameState.getCustomer();

    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {

    }

    /**
     * can this player move
     *
     * @return true, because all player are always allowed to move at all times,
     * as this is a fully asynchronous game
     */

    protected boolean canMove(int playerIdx) {
        return true;
    }

    @Override
    protected String checkIfGameOver() {
        return "";
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

    protected boolean makeMove(GameAction action) {
        Log.i("action", action.getClass().toString());

        if (action instanceof BAHBLButtonAction) {

            if (customer.getGoodButton() == ((BAHBLButtonAction) action).getWhichButton()) {
                // Update the counter values based upon the action
                int result = gameState.getStoryProgress() + 1;
                gameState.setStoryProgress(result);
                gameState.setText(customer.getHappyResponse());


            }

            if (customer.getBadButton() == ((BAHBLButtonAction) action).getWhichButton()) {
                // Update the counter values based upon the action
                int result = gameState.getStoryProgress() + 1;
                gameState.setStoryProgress(result);
                gameState.setText(customer.getMadResponse());
            }

                // denote that this was a legal/successful move
                return true;

        }

        return false;
    }//makeMove
}
