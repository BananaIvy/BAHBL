package edu.up.cs301.bahbl;

import android.widget.Button;

import edu.up.cs301.GameFramework.actionMessage.GameAction;
import edu.up.cs301.GameFramework.players.GamePlayer;

public class BAHBLButtonAction extends GameAction {

    private Button thisButton;
    private int whichButton;
    private final int topButton = 1;
    private final int bottomButton = 2;
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public BAHBLButtonAction(GamePlayer player, Button button) {
        super(player);
        thisButton = button;
        if(button.getId() == R.id.Option1){
            whichButton = topButton;
        }
        else if (button.getId() == R.id.Option2){
            whichButton = bottomButton;
        }
    }

    public int getWhichButton(){
        return whichButton;
    }
}
