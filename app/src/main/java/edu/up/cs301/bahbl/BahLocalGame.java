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

    // When a counter game is played, any number of players. The first player
    // is trying to get the counter value to TARGET_MAGNITUDE; the second player,
    // if present, is trying to get the counter to -TARGET_MAGNITUDE. The
    // remaining players are neither winners nor losers, but can interfere by
    // modifying the counter.
    public static final int TARGET_MAGNITUDE = 10;

    // the game's state
    private BahGameState gameState;
    private BahCustomerBase customer;

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
    }

    /**
     * The only type of GameAction that should be sent is CounterMoveAction
     */

    protected boolean makeMove(GameAction action) {
        Log.i("action", action.getClass().toString());

        customer = gameState.getCustomer();

        //If one of the buttons is pressed
        if (action instanceof BahActionButton) {

            //PULLED OVER FROM GAME STATE
//            //This action is valid when it is the players turn
//            if(customer.getPlayersTurn()){
//                //Modify the state of the game to match action taken
//                if(action.getWhichButton() == customer.getGoodButton()){ //customers good button
//                    setCustomerDialogue(customer.getHappyResponse());
//                    return true;
//                }
//                if(action.getWhichButton() == customer.getBadButton()){ //customers bad button
//                    setCustomerDialogue(customer.getMadResponse());
//                    return true;
//                }
//            }
//            return false; //action is not valid

            if (customer.getGoodButton() == ((BahActionButton) action).getWhichButton()) {
                // Update the counter values based upon the action
                int result = gameState.getStoryProgress() + 1;
                gameState.setStoryProgress(result);
                gameState.setText(customer.getHappyResponse());


            }

            if (customer.getBadButton() == ((BahActionButton) action).getWhichButton()) {
                // Update the counter values based upon the action
                int result = gameState.getStoryProgress() + 1;
                gameState.setStoryProgress(result);
                gameState.setText(customer.getMadResponse());
            }

                //progresses the story if the goodbye text is called
                if(customer.getFarewellDialogue() == gameState.getText()){
                    gameState.setStoryProgress(gameState.getStoryProgress() + 1);
                }


                // denote that this was a legal/successful move
                return true;

        }
        //If an Item is clicked
        if (action instanceof BahActionItem) {
            //Check if the item matches the customers item
            //PULLED OVER FROM GAMESTATE
//            //This action is valid when it is the players turn
//            if(customer.getPlayersTurn()){
//                //Checks if we have the item that was clicked
//                if(action.getThisItem() == 1 && hasKey){
//                    return true;
//                }
//                else if(action.getThisItem() == 2 && hasInfoBot){
//                    return true;
//                }
//                else if(action.getThisItem() == 3 && hasBag){
//                    return true;
//                }
//                else if(action.getThisItem() == 4 && hasPokeball){
//                    return true;
//                }
//                else if(action.getThisItem() == 5 && hasPokeDex){
//                    return true;
//                }
//                else{
//                    return false; //we do not have the item, invalid move
//                }
//            }
//            return false; //if action doesn't return true, then by default it's invalid
        }
        //Progresses the text
        if (action instanceof BahActionProgressText) {
            //If it's the goodbye text it needs to progress the story count
            //PULLED OVER FROM GAME STATE
//            //This action is valid when it's the customers turn to speak & there's no action to do
//            if(!customer.getPlayersTurn()){
//                //Modify the state of the game to match action taken
//                return true;
//            }
//            else{
//                return false; //action is not valid
//            }
        }
        //If the register is clicked
        if (action instanceof BahActionRegister) {
            //Add money to register count and set the text to goodbye text.
            //This should end a customer interaction.
            //PULLED OVER FROM GAMESTATE
//            //This action is valid when it is the players turn
//            if(customer.getPlayersTurn()){
//                //Modify the state of the game to match action taken
//                return true;
//            }
//            else{
//                return false; //action is not valid
//            }
        }
        if (action instanceof BahActionMove) {

        }

        return false;
    }//makeMove
}
