package edu.up.cs301.bahbl;

/**
 * class called when the response buttons are pressed during a customer interaction
 * @author Savannah I. Macdonald
 * @author Laura A. Patla
 * @author Madilynn Greenup
 * @version April 2025
 */

import android.view.View;

import edu.up.cs301.GameFramework.actionMessage.GameAction;
import edu.up.cs301.GameFramework.players.GamePlayer;

public class BahActionButton extends GameAction {


    //Instance Variables
    private View thisButton;
    private int whichButton;
    private final int topButton = 1;
    private final int bottomButton = 2;


    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public BahActionButton(GamePlayer player, View button) {
        super(player);
        thisButton = button;
        if(thisButton.getId() == R.id.Option1){
            whichButton = topButton;
        }
        else if (thisButton.getId() == R.id.Option2){
            whichButton = bottomButton;
        }
    }

    //For Project E specifically
    public BahActionButton(GamePlayer player){
        super(player);
        whichButton = 1;
    }


    //Methods
    public int getWhichButton(){
        return whichButton;
    }

}
