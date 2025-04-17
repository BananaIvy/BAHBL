package edu.up.cs301.bahbl;

import edu.up.cs301.GameFramework.actionMessage.GameAction;
import edu.up.cs301.GameFramework.players.GamePlayer;

public class BahActionCatch extends GameAction {

    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public BahActionCatch(GamePlayer player) {
        super(player);
    }
}
