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


    //creates a CustomerBase object
    public BAHBLCustomerBase (String name){
        customerName = name;
        likeability = 0;
        idNumber++;
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
}
