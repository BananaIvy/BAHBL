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

    private int textProgress;
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
        if(gameState.getStoryProgress() == 1){
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
            state = new BahGameState();
        }
        this.gameState = (BahGameState) state;
        super.state = state;
        textProgress = 0;
    }

    /**
     * The only type of GameAction that should be sent is CounterMoveAction
     */

    protected boolean makeMove(GameAction action) {
        Log.i("action", action.getClass().toString());

        customer = gameState.getCustomer();

        //If one of the buttons is pressed
        if (action instanceof BahActionButton) {

            //This action is valid when it is the players turn
            if(customer.getPlayersTurn()){
                //If the buttons is the good button
                if (customer.getGoodButton() == ((BahActionButton) action).getWhichButton()) {
                    // Update the counter values based upon the action
                    gameState.setText(0);
                    //set the next set of dialogue to be the customer's happy response
                    gameState.setCustomerDialogue(2);
                }
                //if the button is the bad button
                if (customer.getBadButton() == ((BahActionButton) action).getWhichButton()) {
                    // Update the counter values based upon the action
                    gameState.setText(0);
                    //set the next set of dialogue to be the customer's negative response
                    gameState.setCustomerDialogue(3);
                }
                // denote that this was a legal/successful move
                return true;
            }
            return false; //action is not valid
        }

        //If an Item is clicked
        if (action instanceof BahActionItem) {
            //This action is valid when it is the players turn
            if(customer.getPlayersTurn()){
                //Checks if we have the item that was clicked
                if(((BahActionItem) action).getThisItem() == 1 && gameState.isHasKey()){
                    //Needs to check whether or not the item is the customers item
                    //If it is, update having the item to false & change the text to loreDialogue
                    //If it's not, return false or flash the screen.

                    if(customer.getItem() == 1){
                        gameState.setHasKey(false);
                        gameState.setCustomerDialogue(4);
                        gameState.setText(0);
                    } else {
                        return false;
                    }

                    return true;
                }
                else if(((BahActionItem) action).getThisItem() == 2 && gameState.isHasInfoBot()){
                    //Needs to check whether or not the item is the customers item
                    //If it is, update having the item to false & change the text to loreDialogue
                    //If it's not, return false or flash the screen.

                    if(customer.getItem() == 2){
                        gameState.setHasKey(false);
                        gameState.setText(0);
                    } else {
                        return false;
                    }

                    return true;
                }
                else if(((BahActionItem) action).getThisItem() == 3 && gameState.isHasBag()){
                    //Needs to check whether or not the item is the customers item
                    //If it is, update having the item to false & change the text to loreDialogue
                    //If it's not, return false or flash the screen.

                    if(customer.getItem() == 3){
                        gameState.setHasKey(false);
                        gameState.setText(0);
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
                        gameState.setText(0);
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
                        gameState.setText(0);
                    } else {
                        return false;
                    }

                    return true;
                }
                else{
                    return false; //we do not have the item, invalid move
                }
            }
            return false; //if action doesn't return true, then by default it's invalid
        }
        //Progresses the text
        if (action instanceof BahActionProgressText) {
            //This action is valid when it's not the players turn to press a button
            //It's now the customers turn to talk
            if(!customer.getPlayersTurn()){
                //Thread.sleep(500); todo this currently throws an interrupted thread exception, need to figure out what to do about that

                if(gameState.getCustomerDialogue() == 1) {
                    //if it is the greeting dialogue
                    if(textProgress + 1>= gameState.getCustomer().getGreetingLength()) {
                        //if we've reached the end of the array already (so the next index would be out of bounds)
                        textProgress = 0;
                        //here I need to make the buttons clickable and give them the responses
                        customer.setPlayersTurn(true);
                    }
                    else {
                        textProgress++;
                    }
                    //todo add the same type of if elses for the other dialogue sets
                    //if Dialogue == goodbye
                    //Update the text to the next text in the goodbye-text Array
                    //if last-of-goodbye-array-text
                    //ProgressStory + 1
                    //setCustomer to the next one
                    //make it players turn
                }

                return true;
            }
            else{
                return false; //action is not valid
            }
        }

        //If the register is clicked, adds money collected, displays the farewellDialogue
        //ends the Customer's interaction
        if (action instanceof BahActionRegister) {
            gameState.setMoneyCount(gameState.getMoneyCount() + 1);
            gameState.setText(0);
            return true;
        }


        if (action instanceof BahActionMove) {
            return true;
        }

        else {
            return false;
        }

    }//makeMove

}
