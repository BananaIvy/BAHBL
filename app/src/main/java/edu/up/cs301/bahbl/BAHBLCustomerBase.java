package edu.up.cs301.bahbl;



public abstract class BAHBLCustomerBase {


    //Instance Variables
    private String customerName;
    private int likeability;
    private static int idNumber = 0;
    private boolean haveGiven;
    private boolean haveReceived;
    private String goodResponse;
    private String badResponse;
    private boolean playersTurn;
    //If goodButton = 1, then that's the top button. If 2, then bottom button
    private int goodButton;
    private int badButton;


    //creates a CustomerBase object
    public BAHBLCustomerBase (String name){
        customerName = name;
        likeability = 0;
        idNumber++;
        goodButton = 1;
        badButton = 2;
        boolean haveGiven = false;
        boolean haveReceived = false;
        String[] dialogue = new String[5];
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
}
