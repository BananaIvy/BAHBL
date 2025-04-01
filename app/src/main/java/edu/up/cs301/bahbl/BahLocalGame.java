package edu.up.cs301.bahbl;

import android.util.EventLog;
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
        BahGameState copyState = new BahGameState(gameState);
        p.sendInfo(copyState);
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
        if(gameState.getStoryProgress() == 5){
            return "You reached the end! Game is Over";
        }

        return null;
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
    }

    /**
     * The only type of GameAction that should be sent is CounterMoveAction
     */

    protected boolean makeMove(GameAction action) {
        Log.i("action", action.getClass().toString());

        customer = gameState.getCustomer();

        //If the register is clicked, adds money collected, displays the farewellDialogue
        //ends the Customer's interaction
        if (action instanceof BahActionRegister) {
            gameState.addMoney(customer.getMoney());
            //if the response buttons (good and bad) are still visible, make them invisible
            gameState.setButtonIsVisible(false);
            //Set text to goodbye
            gameState.setDialogueIndex(0);
            gameState.setCustomerDialogueType(5);
            return true;
            //todo set something in customer so they respond negatively if you immediately press register w/o talking to them
            //todo will need booleans and crap, might take a hot minute
        }
        //If one of the buttons is pressed
        else if (action instanceof BahActionButton) {

            //This action is valid when it is the players turn
            if(customer.getPlayersTurn()){
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
        }

        //If an Item is clicked
        else if (action instanceof BahActionItem) {
            //This action is valid when it is the players turn
            if(customer.getPlayersTurn()){
                //Checks if we have the item that was clicked
                if(((BahActionItem) action).getThisItem() == 1 && gameState.isHasKey()){
                    //Needs to check whether or not the item is the customers item
                    //If it is, update having the item to false & change the text to loreDialogue
                    //If it's not, return false or flash the screen.

                    if(customer.getItem() == 1){
                        gameState.setHasKey(false);
                        gameState.setCustomerDialogueType(4);
                        gameState.setDialogueIndex(0);
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
                        gameState.setDialogueIndex(0);
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
            } //Action Item
        }
        //Progresses the text
        else if (action instanceof BahActionProgressText) {
            //This action is valid when it's not the players turn to press a button
            //It's now the customers turn to talk

            if(!customer.getPlayersTurn()){
                //Greeting dialogue
                if(gameState.getCustomerDialogueType() == 1) {

                    //if there's more text to scroll through
                    if (gameState.getDialogueIndex() < customer.getGreetingLength()-1) {
                        //Go to next Dialogue Index
                        gameState.setDialogueIndex(gameState.getDialogueIndex()+1);

                    } else { //End of Greeting Dialogue
                        //Reset the Index
                        gameState.setDialogueIndex(0);
                        customer.setPlayersTurn(true);

                        //Enable button's as part of the conversation.
                        gameState.setButtonIsVisible(true);
                        gameState.setBadButtonText(customer.getBadButtonText());
                        gameState.setGoodButtonText(customer.getGoodButtonText());
                    }
                }
                //Happy Response
                else if(gameState.getCustomerDialogueType() == 2){
                    //if we have more to go in the array, then go ahead and set the textview to the current dialogue, then index to the next line in the array
                    if(gameState.getDialogueIndex()+1 < customer.getHappyLength()) {
                        //so in theory, this line isn't necessary because a method somewhere else does it. I'm keeping it in comments in case
                        //that's untrue, so that we can just uncomment to get it back
                        // gameState.setCustomerDialogue(customer.getHappyResponse(gameState.getDialogueIndex()));
                        gameState.setDialogueIndex(gameState.getDialogueIndex()+1);
                    }
                    //otherwise set the index back to zero
                    else {
                        gameState.setDialogueIndex(0);
                        customer.setPlayersTurn(true);
                    }
                }
                //Mad Response
                else if(gameState.getCustomerDialogueType() == 3){
                    //if we have more to go in the array, then go ahead and set the textview to the current dialogue, then index to the next line in the array
                    if(gameState.getDialogueIndex()+1 < customer.getMadLength()) {
                        gameState.setDialogueIndex(gameState.getDialogueIndex()+1);
                    }
                    //otherwise set the index back to zero
                    else {
                        gameState.setDialogueIndex(0);
                        customer.setPlayersTurn(true);
                    }
                }
                //Lore
                else if(gameState.getCustomerDialogueType() == 4){
                    if(gameState.getDialogueIndex() + 1 < gameState.getCustomer().getLoreLength()) {
                        gameState.setDialogueIndex(gameState.getDialogueIndex() + 1);
                    }
                    else{
                        gameState.setDialogueIndex(0);
                        customer.setPlayersTurn(true);
                    }
                }
                //Goodbye
                else if(gameState.getCustomerDialogueType() == 5){
                    if(gameState.getDialogueIndex() + 1 < gameState.getCustomer().getFarewellLength()){
                        gameState.setDialogueIndex(gameState.getDialogueIndex() + 1);
                    }
                    else{
                        gameState.setDialogueIndex(0);
                        customer.setPlayersTurn(true);
                        gameState.nextCustomer();
                    }
                }
            }
            return true;

        }
        return false;

    }//makeMove

}
