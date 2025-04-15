package edu.up.cs301.bahbl;

import android.view.View;
import android.widget.Button;

import edu.up.cs301.GameFramework.actionMessage.GameAction;
import edu.up.cs301.GameFramework.players.GamePlayer;

public class BahTriviaButton extends GameAction {


    public int thisButton = 0;
    public final int button1 = 1;
    public final int button2 = 2;
    public final int button3 = 3;
    public final int button4 = 4;
    public final int wrongButton = 5;
    public final int rightButton = 6;


    /**
     * constructor for BahTriviaButton
     *
     * @param player the player who created the action
     */
    public BahTriviaButton(GamePlayer player, View button) {
        super(player);

        if(button.getId() == R.id.Trivia1){
            thisButton = button1;
        }
        else if(button.getId() == R.id.Trivia2){
            thisButton = button2;
        }
        else if(button.getId() == R.id.Trivia3){
            thisButton =  button3;
        }
        else if(button.getId() == R.id.Trivia4){
            thisButton = button4;
        }
        else if(button.getId() == R.id.wrong){
            thisButton = wrongButton;
        }
        else if(button.getId() == R.id.right){
            thisButton = rightButton;
        }

    }

    public int getThisButton() {return thisButton;}
}
