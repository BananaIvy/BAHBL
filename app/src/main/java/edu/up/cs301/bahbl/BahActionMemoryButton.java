package edu.up.cs301.bahbl;

import android.view.View;

import edu.up.cs301.GameFramework.actionMessage.GameAction;
import edu.up.cs301.GameFramework.players.GamePlayer;

public class BahActionMemoryButton extends GameAction{

    //Instance Variables
    private int whichButton;
    private final int leftButton = 1;
    private final int rightButton = 2;


    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public BahActionMemoryButton(GamePlayer player, View button) {
        super(player);
        if(button.getId() == R.id.leftImageMemory){
            whichButton = leftButton;
        }
        else if (button.getId() == R.id.rightImageMemory){
            whichButton = rightButton;
        }
    }


    public int getWhichButton(){
        return whichButton;
    }
}
