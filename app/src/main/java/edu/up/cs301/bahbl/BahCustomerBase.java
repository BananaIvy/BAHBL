package edu.up.cs301.bahbl;

/**
 * this is the base that all the different customers are based on.
 * @author Savannah I. Macdonald
 * @author Laura A. Patla
 * @author Madilynn Greenup
 * @author Alex Baker
 * @version 2/26/25
 */
public abstract class BahCustomerBase {

    private String customerName;
    private int likeability;
    private int item;

    //shows true if the player may perform click actions of their own, and false if the customer is talking
    private boolean playersTurn;

    //Tracks the status of the items the customer has
    private boolean hasGiven;
    private boolean hasReceived;
    private boolean hasFinishedResponse;
    private boolean hasGottenAnswer;

    //Possible customer dialogue
    private String[] greetingDialogue;  //1
    private String[] happyResponse;     //2
    private String[] madResponse;       //3
    private String[] loreDialogue;      //4
    private String[] farewellDialogue;  //5
    private String[] gameReturn; //6

    //If goodButton = 1, then that's the top button. If 2, then bottom button
    private int goodButton;
    private int badButton;

    //Our options to respond to the customer
    private String goodButtonText;
    private String badButtonText;

    //Gives the customer a different amount of money
    private int money;

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
        money = 10;
        hasFinishedResponse = false;
        hasGottenAnswer = false;

        //Base dialogue examples
        greetingDialogue = new String[1];
        greetingDialogue[0] = "Hello";
        happyResponse = new String[1];
        happyResponse[0] = "Thank you!";
        madResponse = new String[1];
        madResponse[0] = ">:(";
        farewellDialogue = new String[1];
        farewellDialogue[0] = "Goodbye.";
        loreDialogue = new String[2];
        loreDialogue[0] = "This item once killed my father.";
        loreDialogue[1] = "It also was once my father.";
        gameReturn = new String[1];
        gameReturn[0] = "thanks for playing my game i guess?";

        goodButtonText = "You're a good customer :)";
        badButtonText = "You're bad lol >:p";
    }

    //Resets all the Dialogue Strings to be empty arrays.
    public void resetDialogue(){
        this.greetingDialogue = new String[0];
        this.happyResponse = new String[0];
        this.madResponse = new String[0];
        this.loreDialogue = new String[0];
        this.farewellDialogue = new String[0];
        this.gameReturn = new String[0];
    }

    @Override
    public String toString() {
        return customerName;
    }

    //Getter methods

    public int getMoney() {return money;}
    public int getItem(){ return item;}
    public String getCustomerName(){return customerName;}
    public boolean getPlayersTurn(){return playersTurn;}
    public int getGoodButton(){return goodButton;}
    public int getBadButton(){return badButton;}
    public boolean isHasGiven() {return hasGiven;}
    public boolean isHasReceived() {return hasReceived;}
    public int getLikeability() {return likeability;}
    public String getHappyResponse(int index) {return happyResponse[index];}
    public int getHappyLength() {return happyResponse.length;}
    public String getMadResponse(int index) {return madResponse[index];}
    public int getMadLength() {return madResponse.length;}
    public String getLoreDialogue(int index) {return loreDialogue[index];}
    public int getLoreLength() {return loreDialogue.length;}
    public String getGreetingDialogue(int index) {return greetingDialogue[index];}
    public int getGreetingLength() {return greetingDialogue.length;}
    public String getFarewellDialogue(int index) {return farewellDialogue[index];}
    public int getFarewellLength() {return farewellDialogue.length;}
    public String getGameReturn(int index){return gameReturn[index];}
    public int getGameReturnLength() {return gameReturn.length;}
    public String getGoodButtonText() {return goodButtonText;}
    public String getBadButtonText() {return badButtonText;}
    public boolean getHasFinishedResponse() {return hasFinishedResponse;}
    public boolean getHasGottenAnswer() {return hasGottenAnswer;}

    //Setter methods

    public void setMoney(int money) {this.money = money;}
    public void setItem(int item){ this.item = item;}
    public void setLikeability(int likeability) {this.likeability = likeability;}
    public void setHasGiven(boolean hasGiven) {this.hasGiven = hasGiven;}
    public void setHasReceived(boolean hasReceived) {this.hasReceived = hasReceived;}
    public void setHasGottenAnswer(boolean hasGottenAnswer) {this.hasGottenAnswer = hasGottenAnswer;}
    public void setPlayersTurn(boolean playersTurn) {this.playersTurn = playersTurn;}
    public void setCustomerName(String customerName) {this.customerName = customerName;}
    public void setBadButton(int badButton) {this.badButton = badButton;}
    public void setBadButtonText(String badButtonText) {this.badButtonText = badButtonText;}
    public void setGoodButton(int goodButton) {this.goodButton = goodButton;}
    public void setGoodButtonText(String goodButtonText) {this.goodButtonText = goodButtonText;}
    //For overwriting dialogue within the array
    public void setHasFinishedResponse(boolean hasFinishedResponse) {this.hasFinishedResponse = hasFinishedResponse;}

   //Appends the dialogue into the array
    public void addMoney(int plus) {
        this.money += plus;
    }
    public void addLikeability(int opinion) {
        if(this.likeability < 120) {
            if(this.likeability+opinion <= 120) {
                this.likeability += opinion;
            }
            else {
                this.likeability = 120;
            }
        }//outside if
    }
    public void loseLikeability(int opinion) {
        if(this.likeability > 0) {
            if(this.likeability-opinion >=0) {
                this.likeability -= opinion;
            }
            else {
                this.likeability = 0;
            }
        }//outside if
    }
    public void addFarewellDialogue(String dialogue) {
        String[] temptText = new String[this.farewellDialogue.length + 1];
        int i = 0;
        for(String s : this.farewellDialogue){
            temptText[i++] = s;
        }
        this.farewellDialogue = temptText;
        this.farewellDialogue[this.farewellDialogue.length - 1] = dialogue;
    }
    public void addGreetingDialogue(String dialogue) {
        String[] temptText = new String[this.greetingDialogue.length + 1];
        int i = 0;
        for(String s : this.greetingDialogue){
            temptText[i++] = s;
        }
        this.greetingDialogue = temptText;
        this.greetingDialogue[this.greetingDialogue.length - 1] = dialogue;
    }
    public void addLoreDialogue(String dialogue) {
        String[] temptText = new String[this.loreDialogue.length + 1];
        int i = 0;
        for(String s : this.loreDialogue){
            temptText[i++] = s;
        }
        this.loreDialogue = temptText;
        this.loreDialogue[this.loreDialogue.length - 1] = dialogue;
    }
    public void addGameReturn(String dialogue) {
        String[] temptText = new String[this.gameReturn.length + 1];
        int i = 0;
        for(String s : this.gameReturn){
            temptText[i++] = s;
        }
        this.gameReturn = temptText;
        this.gameReturn[this.gameReturn.length - 1] = dialogue;
    }
    public void addHappyResponse(String dialogue) {
        String[] temptText = new String[this.happyResponse.length + 1];
        int i = 0;
        for(String s : this.happyResponse){
            temptText[i++] = s;
        }
        this.happyResponse = temptText;
        this.happyResponse[this.happyResponse.length - 1] = dialogue;
    }
    public void addMadResponse(String dialogue) {
        String[] temptText = new String[this.madResponse.length + 1];
        int i = 0;
        for(String s : this.madResponse){
            temptText[i++] = s;
        }
        this.madResponse = temptText;
        this.madResponse[this.madResponse.length - 1] = dialogue;
    }
}
