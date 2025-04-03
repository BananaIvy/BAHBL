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
        if(gameState.getStoryProgress() >= 6){
            return "You reached the end! Game is Over ";
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
            if(customer.getCustomerName() != "Ghost2") {
                gameState.addMoney(customer.getMoney());
                customer.setMoney(0);
                //if the response buttons (good and bad) are still visible, make them invisible
                gameState.setButtonIsVisible(false);
                //Set text to goodbye
                gameState.setDialogueIndex(0);
                gameState.setCustomerDialogueType(5);
                //it is now the next customer's turn to talk, so the player cannot click anything but the dialogue
                customer.setPlayersTurn(false);
                return true;
                //todo set something in customer so they respond negatively if you immediately press register w/o talking to them
                //todo will need booleans and crap, might take a hot minute
                //todo need to have no money if bad button
            }
            return false;
        }
        //If one of the buttons is pressed
        else if (action instanceof BahActionButton) {

            //This action is valid when it is the players turn
            if(customer.getPlayersTurn() && (!customer.getHasGottenAnswer())){
                //If the buttons is the good button
                if (customer.getGoodButton() == ((BahActionButton) action).getWhichButton()) {
                    // Update the counter values based upon the action
                    gameState.setDialogueIndex(0);
                    //set the next set of dialogue to be the customer's happy response
                    gameState.setCustomerDialogueType(2);
                    //The customer gives the item, we can changes this later to better fit the game.
                    customer.setHasGiven(true);
                    customer.setHasGottenAnswer(true);
                }
                //if the button is the bad button
                if (customer.getBadButton() == ((BahActionButton) action).getWhichButton()) {
                    // Update the counter values based upon the action
                    gameState.setDialogueIndex(0);
                    //set the next set of dialogue to be the customer's negative response
                    gameState.setCustomerDialogueType(3);
                    customer.setHasGottenAnswer(true);
                }
                //make it so the player can only click the text now
                customer.setPlayersTurn(false);
                //set the dialogue back to the first index so they start their next sentence at the beginning
                gameState.setDialogueIndex(0);
                // denote that this was a legal/successful move
                return true;
            }
            //I'm commenting this guy for now. He doesn't go here rn but he might need to come back eventually
            // gameState.setDialogueIndex(0);
            return false;
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
                        //todo set an if case for how much money you have to determine if
                        //todo THIS IS WHERE WE SHOULD TRIGGER ENDING EVENTS
                        gameState.setHasKey(false);
                        //todo add something in here so that it will not set to type 4 if it's end of game
                        gameState.setCustomerDialogueType(4);
                        gameState.setDialogueIndex(0);
                        customer.setPlayersTurn(false);
                        if(gameState.getMoneyCount() >= 280){
                            goodEnding();
                        } else {
                            badEnding();
                        }
                    }
                    else{
                        return false;
                    }
                }
                else if(((BahActionItem) action).getThisItem() == 2 && gameState.isHasInfoBot()){
                    //Needs to check whether or not the item is the customers item
                    //If it is, update having the item to false & change the text to loreDialogue
                    //If it's not, return false or flash the screen.

                    if(customer.getItem() == 2){
                        gameState.setHasInfoBot(false);
                        gameState.setCustomerDialogueType(4);
                        gameState.setDialogueIndex(0);
                        customer.setPlayersTurn(false);
                    } else {
                        return false;
                    }

                }
                else if(((BahActionItem) action).getThisItem() == 3 && gameState.isHasBag()){
                    //Needs to check whether or not the item is the customers item
                    //If it is, update having the item to false & change the text to loreDialogue
                    //If it's not, return false or flash the screen.

                    if(customer.getItem() == 3){
                        gameState.setHasBag(false);
                        gameState.setCustomerDialogueType(4);
                        gameState.setDialogueIndex(0);
                        customer.setPlayersTurn(false);
                    } else {
                        return false;
                    }

                }
                else if(((BahActionItem) action).getThisItem() == 4 && gameState.isHasPokeball()){
                    //Needs to check whether or not the item is the customers item
                    //If it is, update having the item to false & change the text to loreDialogue
                    //If it's not, return false or flash the screen.

                    if(customer.getItem() == 4){
                        gameState.setHasPokeball(false);
                        gameState.setCustomerDialogueType(4);
                        gameState.setDialogueIndex(0);
                        customer.setPlayersTurn(false);
                    } else {
                        return false;
                    }

                }
                else if(((BahActionItem) action).getThisItem() == 5 && gameState.isHasPokeDex()){
                    //Needs to check whether or not the item is the customers item
                    //If it is, update having the item to false & change the text to loreDialogue
                    //If it's not, return false or flash the screen.

                    if(customer.getItem() == 5){
                        gameState.setHasPokeDex(false);
                        gameState.setCustomerDialogueType(4);
                        gameState.setDialogueIndex(0);
                        customer.setPlayersTurn(false);
                    } else {
                        return false;
                    }

                }
            }
            return false;
        }//Action Item
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

                    }
                    else { //End of Greeting Dialogue
                        customer.setPlayersTurn(true);
                        //Reset the Index
                        //gameState.setDialogueIndex(0);


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
                        //gameState.setDialogueIndex(0);
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
                        //gameState.setDialogueIndex(0);
                        customer.setPlayersTurn(true);
                    }
                }
                //Lore
                else if(gameState.getCustomerDialogueType() == 4){
                    if(gameState.getDialogueIndex() + 1 < gameState.getCustomer().getLoreLength()) {
                        gameState.setDialogueIndex(gameState.getDialogueIndex() + 1);
                    }
                    else{
                        //gameState.setDialogueIndex(0);
                        customer.setPlayersTurn(true);
                        //Sets the different items as showing given depending on the customer
                        if(customer.getCustomerName().equals("Ghost")) {
                            gameState.setHasPokeball(true);
                        }else if(customer.getCustomerName().equals("Pokeangel")){
                            gameState.setHasInfoBot(true);
                        }else if (customer.getCustomerName().equals("Lug")) {
                            gameState.setHasBag(true);
                        }else if(customer.getCustomerName().equals("Mystic Man")){
                            gameState.setHasPokeDex(true);
                        } else if(customer.getCustomerName().equals("Demon Lord Nux")){
                            gameState.setHasKey(true);
                        }
                    }
                }
                //Goodbye
                else if(gameState.getCustomerDialogueType() == 5){
                    if(gameState.getDialogueIndex() + 1 < gameState.getCustomer().getFarewellLength()){
                        gameState.setDialogueIndex(gameState.getDialogueIndex() + 1);
                    }
                    else if(gameState.getStoryProgress() >= 5) {
                        gameState.setStoryProgress(gameState.getStoryProgress() + 1);
                    }
                    else{
                        //gameState.setDialogueIndex(0);
                        customer.setPlayersTurn(true);
                        gameState.setCustomerDialogueType(1);
                        gameState.setDialogueIndex(0);
                        gameState.nextCustomer();
                        gameState.setStoryProgress(gameState.getStoryProgress() + 1);
                        if(customer.getCustomerName().equals("Ghost")) {
                            //todo : For now we get the key back. Make endings!!
                            gameState.setHasKey(true);
                        }
                    }
                }
            }
            return false;
        }
        gameState.setDialogueIndex(0);
        return false;

    }//makeMove

    /*
     * ENDINGS
     */
    private void goodEnding(){
        //todo
    }

    private void badEnding(){
        //todo
    }

    private void loreEnding(){
        //todo
    }

}
