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
public class BahLocalGame extends LocalGame {

    // the game's state
    private BahGameState gameState;
    private BahCustomerBase customer;
    private BahActionItem item;

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
        if(gameState.getStoryProgress() == 6){
            return "Game is over!";
        }

        return "";
    }

    /**
     * This ctor should be called when a new counter game is started
     */
    public BahLocalGame(GameState state) {
        // initialize the game state, with the counter value starting at 0
        if (!(state instanceof BahGameState)) {
            //Then tis an issue
            Log.i("Issue in Local Game constructor","tis not a Bahgamestate");
        }
        this.gameState = (BahGameState) state;
        this.customer = gameState.getCustomer();
    }

    /**
     * The only type of GameAction that should be sent is CounterMoveAction
     */

    protected boolean makeMove(GameAction action) {
        Log.i("action", action.getClass().toString());

        //If the register is clicked, adds money collected, displays the farewellDialogue
        //ends the Customer's interaction
        if (action instanceof BahActionRegister) {
            gameState.setCustomerDialogue("The register was clicked");
            return true;
        }
        //Progresses the text
        else if (action instanceof BahActionProgressText) {
            //This action is valid when it's not the players turn to press a button
            //It's now the customers turn to talk
            if(!customer.getPlayersTurn()){
                gameState.getCurrentCustomerDialogue();

                return true;
            }
        }
        //If one of the buttons is pressed
        else if (action instanceof BahActionButton) {
            //If the buttons is the good button
            if (customer.getGoodButton() == ((BahActionButton) action).getWhichButton()) {
                // Update the counter values based upon the action
                gameState.setDialogueIndex(0);
                //set the next set of dialogue to be the customer's happy response
                gameState.setCustomerDialogueType(2);
            }
            //if the button is the bad button
            if (customer.getBadButton() == ((BahActionButton) action).getWhichButton()) {
                // Update the counter values based upon the action
                gameState.setDialogueIndex(0);
                //set the next set of dialogue to be the customer's negative response
                gameState.setCustomerDialogueType(3);
            }
            // denote that this was a legal/successful move
            return true;
        }
        //If an Item is clicked
        else if (action instanceof BahActionItem) {
            //Checks if we have the item that was clicked
            if(((BahActionItem) action).getThisItem() == 1 && gameState.isHasKey()){
                if(customer.getItem() == 1){
                    //The item IS the customers item
                    return true;
                } else {
                    return false;
                }
            }
            else if(((BahActionItem) action).getThisItem() == 2 && gameState.isHasInfoBot()){

                if(customer.getItem() == 2){
                    //The item IS the customers item
                    return true;
                } else {
                    return false;
                }

            }
            else if(((BahActionItem) action).getThisItem() == 3 && gameState.isHasBag()){
                //Needs to check whether or not the item is the customers item
                //If it is, update having the item to false & change the text to loreDialogue
                //If it's not, return false or flash the screen.

                if(customer.getItem() == 3){
                    gameState.setHasKey(false);
                    gameState.setDialogueIndex(0);
                } else {
                    return false;
                }

                return true;
            }
            else if(((BahActionItem) action).getThisItem() == 4 && gameState.isHasPokeball()){
                //Needs to check whether or not the item is the customers item
                //If it is, update having the item to false & change the text to loreDialogue
                //If it's not, return false or flash the screen.

                if(customer.getItem() == 4){
                    gameState.setHasKey(false);
                    gameState.setDialogueIndex(0);
                } else {
                    return false;
                }

                return true;
            }
            else if(((BahActionItem) action).getThisItem() == 5 && gameState.isHasPokeDex()){
                //Needs to check whether or not the item is the customers item
                //If it is, update having the item to false & change the text to loreDialogue
                //If it's not, return false or flash the screen.

                if(customer.getItem() == 5){
                    gameState.setHasKey(false);
                    gameState.setDialogueIndex(0);
                } else {
                    return false;
                }

                return true;
            }
        }

        else if (action instanceof BahActionMove) {
            return false;
        }
        return false;

    }//makeMove

}
