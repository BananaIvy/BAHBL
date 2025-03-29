package edu.up.cs301.bahbl;

import edu.up.cs301.GameFramework.players.GamePlayer;
import edu.up.cs301.GameFramework.actionMessage.GameAction;

/**
 * A BahActionMove is an action that is a "move" the game: either increasing
 * or decreasing the counter value.
 *
 * @author Steven R. Vegdahl
 * @author Andrew M. Nuxoll
 * @version September 2012
 */
public class BahActionMove extends GameAction {


    /**
     * Constructor for the CounterMoveAction class.
     *
     * @param player
     *            the player making the move
     *
     */
    public BahActionMove(GamePlayer player) {
        super(player);
    }

    /**
     * getter method, to tell whether the move is a "plus"
     *
     * @return
     * 		a boolean that tells whether this move is a "plus"
     */

}//class CounterMoveAction
