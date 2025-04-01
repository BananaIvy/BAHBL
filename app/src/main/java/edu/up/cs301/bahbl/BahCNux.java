package edu.up.cs301.bahbl;

public class BahCNux extends BahCustomerBase {


    public BahCNux(){
        super();
        setCustomerName("Demon Lord Nux");
        setItem(5);
        setBadButton(1);
        setGoodButton(2);
        resetDialogue();
        setMoney(90);

        addHappyResponse("MONEY! TAKE! NO POKEMON!");
        addMadResponse("MONEY! TAKE! NO POKEMON!");

    }
}
