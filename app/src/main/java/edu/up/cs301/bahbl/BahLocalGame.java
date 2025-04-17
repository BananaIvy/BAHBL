package edu.up.cs301.bahbl;

import android.util.Log;

import edu.up.cs301.GameFramework.LocalGame;
import edu.up.cs301.GameFramework.actionMessage.GameAction;
import edu.up.cs301.GameFramework.infoMessage.GameState;
import edu.up.cs301.GameFramework.players.GamePlayer;

/**
 * A class that represents the state of a game. All game actions happen through this class and
 * updates the gameState accordingly.
 *
 * @author Steven R. Vegdahl
 * @author Andrew M. Nuxoll
 * @author Savannah I. Macdonald
 * @author Laura A. Patla
 * @author Madilynn Greenup
 * @author Alex Baker
 * @version July 2013
 */
public class BahLocalGame extends LocalGame {

    private BahGameState gameState;
    private BahCustomerBase customer;

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
        if(gameState.getStoryProgress() >= 8){
            if(customer.getLikeability()>=70) {
                loreEnding();
            }
            else if(gameState.getMoneyCount() >= 280){
                goodEnding();
            } else {
                actBadEnding();
            }
            return "You reached the end! Game is Over ";
        }

        return null;
    }

    /**
     * This ctor should be called when a new bahbl game is started
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
     * hi
     */

    protected boolean makeMove(GameAction action) {
        Log.i("action", action.getClass().toString());

        customer = gameState.getCustomer();

        //If the register is clicked
        if (action instanceof BahActionRegister) {
           return actRegister();
        }

        //If one of the buttons is pressed
        else if (action instanceof BahActionButton) {
            return actButton(action);
        }

        else if (action instanceof  BahActionTriviaButton){
            return actTrivia(action);
        }

        //If an Item is clicked
        else if (action instanceof BahActionItem) {
            return actItem(action);
        }

        //Customer text is clicked
        else if (action instanceof BahActionProgressText) {
            return actProgressText();
        }

        //ENDING
        else if(action instanceof BahActionRun) {
            return actBadEnding();
        }

        else if(action instanceof BahActionCatch){
            return actPokeCatch();
        }

        else if(action instanceof BahActionBattle){
            return actpokeBattle((BahActionBattle) action);
        }


        gameState.setDialogueIndex(0);
        return false;
    }//makeMove


    /**
     * Register is clicked -
     * Progresses to goodbye dialogue & adds money to the register.
     */
    private boolean actRegister(){
        //Register is clickable when the customers not talking and it's not the last interaction
        if(customer.getPlayersTurn() && !customer.getCustomerName().equals("Ghost2")) {
            //check if we went through a whole interaction or if we rushed them rudely
            if(gameState.getCustomerDialogueType() >= 2) {
                //good, this means we were polite :)
            }
            else {
                customer.loseLikeability(30);
            }
            //Change $ amount based on good/bad interactions (aka customer likeability)
            customer.setMoney(customer.getMoney()*customer.getLikeability()/100);
            //Customer empties their wallets into the register
            gameState.addMoney(customer.getMoney());
            customer.setMoney(0);
            //take the customer's likeability for us and add it to our total (stored in gameState)
            gameState.addLikeability(customer.getLikeability());
            //Set up for goodbye dialogue conditions
            gameState.setButtonIsVisible(false);
            gameState.setDialogueIndex(0);
            gameState.setCustomerDialogueType(5);

            //it is now the next customer's turn to talk, so the player cannot click anything but the dialogue
            customer.setPlayersTurn(false);

            return true; //legal
        }
        return false; //illegal
    }

    /**
     * Button is clicked -
     * Figures out which button is which & adjusts response accordingly
     */
    private boolean actButton(GameAction action){
        //Buttons are clickable when the customers not talking and button has not been clicked prior
        if(customer.getPlayersTurn() && (!customer.getHasGottenAnswer())){

            //GOOD Button is pressed
            if (customer.getGoodButton() == ((BahActionButton) action).getWhichButton()) {

                //add to likeability - they're happy you chose the correct response
                customer.addLikeability(20);//we should probably index by values of 10
                //Set up for Happy Response
                gameState.setDialogueIndex(0);
                gameState.setCustomerDialogueType(2);

                //Update Booleans & reset button text
                customer.setHasGiven(true);
                customer.setHasGottenAnswer(true);
                gameState.setButtonIsVisible(false);

            }

            //BAD Button is pressed
            if (customer.getBadButton() == ((BahActionButton) action).getWhichButton()) {

                //subtract from likeability - you upset the customer. tsk tsk
                customer.loseLikeability(10);//less than is added for the good response, can be changed if desired
                //Set up for Mad Response
                gameState.setDialogueIndex(0);
                gameState.setCustomerDialogueType(3);

                //Update Booleans & reset button text
                customer.setHasGottenAnswer(true);
                gameState.setButtonIsVisible(false);
            }

            //Makes it so we don't start the game with the key and only get it from the first
            //interaction with the ghost
            if(customer.getCustomerName().equals("Ghost")){
                gameState.setHasKey(true);
            }

            //Customers turn to talk
            customer.setPlayersTurn(false);
            gameState.setDialogueIndex(0);
            gameState.setGoodButtonText(null);
            gameState.setBadButtonText(null);

            return true; //legal
        }


        return false; //illegal
    }

    /**
     * Item is clicked -
     * Figures out which item is clicked, makes the item handed to customer
     */
    private boolean actItem(GameAction action){
        if(customer.getPlayersTurn()){

            //No interrupting ghosts ending dialogue
            if(customer.getCustomerName().equals("Ghost2")) {
                if(gameState.getCustomerDialogueType()<2) {
                    return false;
                }
            }

            /*
             * Conditions that must be met for item actions:
             * 1. We have the item
             * 2. The item is the customers item
             */

            //KEY
            if(((BahActionItem) action).getThisItem() == 1 && gameState.isHasKey()){
                if(customer.getItem() == 1){

                    //Gives item to customer & gives them more money to pay us with
                    gameState.setHasKey(false);
                    customer.addMoney(10);

                    //This only checks the end of the game to ensure the lore dialogue for the ghost isn't called.
                    if(customer.getCustomerName().equals("Ghost2")){
                        gameState.progressStory();
                        return true;
                    }
                    else {
                        customer.addLikeability(30);
                        gameState.setCustomerDialogueType(4);
                        gameState.setDialogueIndex(0);
                        customer.setPlayersTurn(false);
                    }
                }
                else{
                    return false;
                }
            }//key

            //INFOBOT
            else if(((BahActionItem) action).getThisItem() == 2 && gameState.isHasInfoBot()){
                if(customer.getItem() == 2){

                    gameState.setHasInfoBot(false);
                    customer.addLikeability(30);
                    gameState.setCustomerDialogueType(4);
                    gameState.setDialogueIndex(0);
                    customer.setPlayersTurn(false);
                }
                else{
                    return false;
                }
            }//infobot

            //BAG
            else if(((BahActionItem) action).getThisItem() == 3 && gameState.isHasBag()){
                //Needs to check whether or not the item is the customers item
                //If it is, update having the item to false & change the text to loreDialogue
                //If it's not, return false or flash the screen.

                if(customer.getItem() == 3){
                    gameState.setHasBag(false);
                    customer.addLikeability(30);
                    gameState.setCustomerDialogueType(4);
                    gameState.setDialogueIndex(0);
                    customer.setPlayersTurn(false);
                } else {
                    return false;
                }
            }//bag

            //POKEBALL
            else if(((BahActionItem) action).getThisItem() == 4 && gameState.isHasPokeball()){
                if(customer.getItem() == 4){
                    gameState.setHasPokeball(false);
                    customer.addLikeability(30);
                    gameState.setCustomerDialogueType(4);
                    gameState.setDialogueIndex(0);
                    customer.setPlayersTurn(false);
                } else {
                    return false;
                }
            }//pokeball

            //POKEDEX
            else if(((BahActionItem) action).getThisItem() == 5 && gameState.isHasPokeDex()){
                if(customer.getItem() == 5){
                    gameState.setHasPokeDex(false);
                    customer.addLikeability(30);
                    gameState.setCustomerDialogueType(4);
                    gameState.setDialogueIndex(0);
                    customer.setPlayersTurn(false);
                } else {
                    return false;
                }
            }//pokedex
            //todo: There's a lot of recurring 3 lines of code with the items that may be extractable!

            }
        return false; //illegal
    }//actItem

    /**
     * Customer Text is clicked
     */
    private boolean actProgressText(){
        if(!customer.getPlayersTurn()){

            //Greeting dialogue
            if(gameState.getCustomerDialogueType() == 1) {

                //if there's more text to scroll through
                if (gameState.getDialogueIndex()+1 < customer.getGreetingLength()) {
                    gameState.nextDialogue();
                }
                else { //End of Customers speech
                    customer.setPlayersTurn(true);

                    //Enable buttons
                    gameState.setButtonIsVisible(true);
                    gameState.setBadButtonText(customer.getBadButtonText());
                    gameState.setGoodButtonText(customer.getGoodButtonText());
                }
            }//Hi!

            //Happy Response
            else if(gameState.getCustomerDialogueType() == 2){

                //if there's more text to scroll through
                if(gameState.getDialogueIndex()+1 < customer.getHappyLength()) {
                    gameState.nextDialogue();
                }
                else { //End of Customers speech
                    giveItem();
                    //call on the mini game to start now
                    if(customer.getCustomerName() != "Ghost" && customer.getCustomerName() != "Ghost2"){
                       gameState.setGameTime(true);
                    } else{
                       customer.setPlayersTurn(true);
                    }
                }

            }//:)

            //Mad Response
            else if(gameState.getCustomerDialogueType() == 3){

                //if there's more text to scroll through
                if(gameState.getDialogueIndex()+1 < customer.getMadLength()) {
                    gameState.nextDialogue();
                }
                else { //End of Customers speech
                    customer.setPlayersTurn(true);
                }
            }

            //Lore
            else if(gameState.getCustomerDialogueType() == 4){
                if(!customer.getCustomerName().equals("Ghost2")) {

                    if (gameState.getDialogueIndex() + 1 < gameState.getCustomer().getLoreLength()) {
                        gameState.nextDialogue();
                    }
                    else { //End of Customers speech
                        customer.setPlayersTurn(true);
                    }
                }
            }

            //Goodbye
            else if(gameState.getCustomerDialogueType() == 5){

                //if there's more text to scroll through
                if(gameState.getDialogueIndex() + 1 < gameState.getCustomer().getFarewellLength()){
                    gameState.nextDialogue();
                }
                else{ //End of Customers speech
                    customer.setPlayersTurn(true);

                    //Set to next customers introduction
                    gameState.setCustomerDialogueType(1);
                    gameState.setDialogueIndex(0);
                    gameState.nextCustomer();
                    gameState.progressStory();

                    //Intro Ghost gives key after goodbye
                    if(customer.getCustomerName().equals("Ghost")) {
                        gameState.setHasKey(true);
                    }
                }
            }//bai!
        }
        return false; //illegal
    }//actProgressText

    public boolean actTrivia(GameAction action){
        //trivia button
        //The correct answers go in the order 2, 4, 1, 4, 2

            if(((BahActionTriviaButton) action).getWhichButton() == 1) {
                //do stuff here
                if (gameState.getTriviaSection() == 3) {

                    gameState.setCorrectAnswer(true);
                    gameState.setCorrectAnswersCount(gameState.getCorrectAnswersCount() + 1);

                }

                gameState.setTriviaButtonClicked(true);

                //say it was a legal move
                return true;
            }
            else if (((BahActionTriviaButton) action).getWhichButton() == 2) {

                if (gameState.getTriviaSection() == 1 || gameState.getTriviaSection() == 5) {

                    gameState.setCorrectAnswer(true);
                    gameState.setCorrectAnswersCount(gameState.getCorrectAnswersCount() + 1);
                }

                gameState.setTriviaButtonClicked(true);

                return true;
            }
            else if (((BahActionTriviaButton) action).getWhichButton() == 3) {

                gameState.setCorrectAnswer(false);
                gameState.setTriviaButtonClicked(true);

                return true;
            }
            else if (((BahActionTriviaButton) action).getWhichButton() == 4) {

                if (gameState.getTriviaSection() == 2 || gameState.getTriviaSection() == 4) {

                    gameState.setCorrectAnswer(true);
                    gameState.setCorrectAnswersCount(gameState.getCorrectAnswersCount() + 1);

                }
                gameState.setTriviaButtonClicked(true);
                return true;
            }
            //The wrong answer
            else if (((BahActionTriviaButton) action).getWhichButton() == 5) {

                gameState.setCorrectAnswer(false);
                gameState.setTriviaButtonClicked(false);

                return true;
            }
            //The right answer
            else if (((BahActionTriviaButton) action).getWhichButton() == 6) {

                gameState.setCorrectAnswer(false);
                gameState.setTriviaButtonClicked(false);

                return true;
            }

        return false; //Illegal
    }


    /*
     * ENDINGS
     */
    private void goodEnding(){
        //todo if we want the ending screens interactable
        //For 'animation' switching or smth idk. Code that may come in handy later.
        try {Thread.sleep(2000);}
        catch(InterruptedException ie) { /*no problem*/ }
    }

    private boolean actBadEnding(){
        if(gameState.getEndScene() != 4) {
            gameState.nextEndScene(false);
        }
        else{
            gameState.nextEndScene(true);
        }
        return true;
    }

    private void giveItem() {
        if (customer.getCustomerName().equals("Ghost")) {
            gameState.setHasPokeball(true);
        } else if (customer.getCustomerName().equals("Pokeangel")) {
            gameState.setHasInfoBot(true);
        } else if (customer.getCustomerName().equals("Lug")) {
            gameState.setHasBag(true);
        } else if (customer.getCustomerName().equals("Mystic Man")) {
            gameState.setHasPokeDex(true);
        } else if (customer.getCustomerName().equals("Demon Lord Nux")) {
            gameState.setHasKey(true);
        }
    }
    private void loreEnding(){
        //todo if we want the ending screens interactable
    }

    private void triviaScreen(){

    }

    private boolean actpokeBattle(BahActionBattle action){
        if(action.getThisPokemon() == "egg"){
            return true;
        }
        return false;
    }

    private boolean actPokeCatch() {
        return true;
    }

}
