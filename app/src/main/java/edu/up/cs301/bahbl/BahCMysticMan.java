package edu.up.cs301.bahbl;

public class BahCMysticMan extends BahCustomerBase {

    public BahCMysticMan(){
        super();
        setCustomerName("Mystic Man");
        setItem(3);
        setBadButton(1);
        setGoodButton(2);
        resetDialogue();
        setMoney(40);

        addHappyResponse("The money is yours, all you have to do is click...");
        addMadResponse("The money is yours, all you have to do is click...");

        /* dialogues */
        //greeting dialogue
        addGreetingDialogue("Have you ever noticed how only men go to hell?");
        addGreetingDialogue("Don't make that face, I can see in your eyes that you realize more than you let on.");
        addGreetingDialogue("");

    }
}
