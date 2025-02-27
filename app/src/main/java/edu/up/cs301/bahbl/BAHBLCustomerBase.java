package edu.up.cs301.bahbl;
/**
 * this is the base that all the different customers are based on.
 * @author Laura Patla
 * @version 2/26/25
 */
public abstract class BAHBLCustomerBase {

    //Instance Variables
    private String customerName;
    private int likeability;
    private boolean hasGiven;
    private boolean hasReceived;
    private String happyResponse;
    private String madResponse;
    private boolean playersTurn;
    private String loreDialogue;
    private String greetingDialogue;
    private String farewellDialogue;

    //If goodButton = 1, then that's the top button. If 2, then bottom button
    private int goodButton;
    private int badButton;
    private String goodButtonText;
    private String badButtonText;


    //creates a CustomerBase object
    public BAHBLCustomerBase (String name){
        customerName = name;
        likeability = 50;
        goodButton = 1;
        badButton = 2;
        boolean haveGiven = false;
        boolean haveReceived = false;
        playersTurn = false;
        //dialogue = {"lore", "greeting", "initial dialogue request", "item response", "goodbye"};
    }


    //getItem method
    public int getItem (){
        /* IMPLEMENT THIS AFTER */
        return 0;
    }

    public String getCustomerName(){
        return customerName;
    }

    public boolean getPlayersTurn(){
        return playersTurn;
    }

    public int getGoodButton(){
        return goodButton;
    }

    public int getBadButton(){
        return badButton;
    }

    public boolean isGiven() {
        return hasGiven;
    }

    public boolean isHasReceived() {
        return hasReceived;
    }

    public int getLikeability() {
        return likeability;
    }

    public String getHappyResponse() {
        return happyResponse;
    }

    public String getMadResponse() {
        return madResponse;
    }

    public String getLoreDialogue() {
        return loreDialogue;
    }

    public String getGreetingDialogue() {
        return greetingDialogue;
    }

    public String getFarewellDialogue() {
        return farewellDialogue;
    }

    public String getGoodButtonText() {
        return goodButtonText;
    }

    public String getBadButtonText() {
        return badButtonText;
    }
}
