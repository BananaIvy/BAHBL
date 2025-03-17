package edu.up.cs301.bahbl;
/**
 * this is the base that all the different customers are based on.
 * @author Laura Patla
 * @version 2/26/25
 */
public abstract class BahCustomerBase {

    //todo this customer base needs to have arrays for each large block of text, so you can progress to the next line in their story
    //todo and not have to print their entire chunk on the screen.
    //todo there should be an instance variable in localgame that will keep track of the index of the string being shown

    //todo make them know their special item
    private String customerName;
    private int likeability;
    private int item;

    //shows true if the player may perform click actions of their own, and false if the customer is talking
    private boolean playersTurn;

    //Tracks the status of the items the customer has
    private boolean hasGiven;
    private boolean hasReceived;

    //Possible customer dialogue
    private String[] happyResponse;
    private String[] madResponse;
    private String[] loreDialogue;
    private String[] greetingDialogue;
    private String[] farewellDialogue;

    //If goodButton = 1, then that's the top button. If 2, then bottom button
    private int goodButton;
    private int badButton;

    //Our options to respond to the customer
    private String goodButtonText;
    private String badButtonText;

    /*
    Default constructor/set-up for a customer
     */
    public BahCustomerBase(){
        customerName = "Customer";
        likeability = 50;
        goodButton = 1;
        badButton = 2;
        hasGiven = false;
        hasReceived = false;
        playersTurn = false;

        //Base dialogue examples
        greetingDialogue = new String[1];
        greetingDialogue[1] = "Hello";
        happyResponse = new String[1];
        happyResponse[1] = "Thank you!";
        madResponse = new String[1];
        madResponse[1] = ">:(";
        loreDialogue = new String[2];
        loreDialogue[1] = "This item once killed my father.";
        loreDialogue[2] = "It also was once my father.";
        farewellDialogue = new String[1];
        farewellDialogue[1] = "Goodbye.";

        goodButtonText = "You're a good customer :)";
        badButtonText = "You're a bad customer :/";
    }


    //Getter methods
    public int getItem(){ return item;}
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
    public boolean isHasGiven() {
        return hasGiven;
    }
    public boolean isHasReceived() {
        return hasReceived;
    }
    public int getLikeability() {
        return likeability;
    }
    public String getHappyResponse(int index) {
        return happyResponse[index];
    }
    public int getHappyLength() {
        return happyResponse.length;
    }
    public String getMadResponse(int index) {
        return madResponse[index];
    }
    public int getMadLength() {
        return madResponse.length;
    }
    public String getLoreDialogue(int index) {
        return loreDialogue[index];
    }
    public int getLoreLength() {
        return loreDialogue.length;
    }
    public String getGreetingDialogue(int index) {
        return greetingDialogue[index];
    }
    public int getGreetingLength() {
        return greetingDialogue.length;
    }
    public String getFarewellDialogue(int index) {
        return farewellDialogue[index];
    }
    public int getFarewellLength() {
        return farewellDialogue.length;
    }
    public String getGoodButtonText() {
        return goodButtonText;
    }
    public String getBadButtonText() {
        return badButtonText;
    }


    //Setter methods
    public void setItem(int item){ this.item = item;}
    public void setPlayersTurn(boolean playersTurn) {this.playersTurn = playersTurn;}
    public void setCustomerName(String customerName) {this.customerName = customerName;}
    public void setBadButton(int badButton) {this.badButton = badButton;}
    public void setBadButtonText(String badButtonText) {this.badButtonText = badButtonText;}
    public void setGoodButton(int goodButton) {this.goodButton = goodButton;}
    public void setGoodButtonText(String goodButtonText) {this.goodButtonText = goodButtonText;}
    public void setFarewellDialogue(String farewellDialogue, int index) {this.farewellDialogue[index] = farewellDialogue;}
    public void setGreetingDialogue(String greetingDialogue, int index) {this.greetingDialogue[index] = greetingDialogue;}
    public void setHappyResponse(String happyResponse, int index) {this.happyResponse[index] = happyResponse;}
    public void setMadResponse(String madResponse, int index) {this.madResponse[index] = madResponse;}
    public void setLoreDialogue(String loreDialogue, int index) {this.loreDialogue[index] = loreDialogue;}
    public void setLikeability(int likeability) {this.likeability = likeability;}
    public void setHasGiven(boolean hasGiven) {this.hasGiven = hasGiven;}
    public void setHasReceived(boolean hasReceived) {this.hasReceived = hasReceived;}
}
