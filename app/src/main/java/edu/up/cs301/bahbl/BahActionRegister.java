package edu.up.cs301.bahbl;

import edu.up.cs301.GameFramework.actionMessage.GameAction;
import edu.up.cs301.GameFramework.players.GamePlayer;

public class BahActionRegister extends GameAction {
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public BahActionRegister(GamePlayer player) {
        super(player);
    }
}
