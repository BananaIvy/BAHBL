package edu.up.cs301.bahbl;

import android.widget.ImageButton;
import edu.up.cs301.GameFramework.actionMessage.GameAction;
import edu.up.cs301.GameFramework.players.GamePlayer;

public class BAHBLItemAction extends GameAction {

    private int thisItem;
    private final int key = 1;
    private final int infoBot = 2;
    private final int bag = 3;
    private final int pokeball = 4;
    private final int pokedex = 5;

    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public BAHBLItemAction(GamePlayer player, ImageButton item) {

        super(player);
        if(item.getId() == R.id.key){
            thisItem = key;
        }
        else if(item.getId() == R.id.infoBot){
            thisItem = infoBot;
        }
        else if(item.getId() == R.id.bag){
            thisItem = bag;
        }
        else if(item.getId() == R.id.pokeball){
            thisItem = pokeball;
        }
        else if(item.getId() == R.id.pokedex){
            thisItem = pokedex;
        }

    }

    public int getThisItem(){
        return thisItem;
    }
}
