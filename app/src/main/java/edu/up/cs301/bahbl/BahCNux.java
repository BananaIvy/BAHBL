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

        //Greeting Dialogue
        addGreetingDialogue("Well hello past student...funny seeing you here...");
        addGreetingDialogue("How did you end up here?");
        addGreetingDialogue("Ah well it doesn't matter.");
        addGreetingDialogue("I'm here to check on your boss.");
        addGreetingDialogue("He's had some shady goings-on in the past");
        addGreetingDialogue("I have to make sure all my stores are in working order.");
        addGreetingDialogue("...and remove any pesky pokemon.");
        addGreetingDialogue("I CAN'T SEEM TO GET RID OF THEM!");
        addGreetingDialogue("CONSTANTLY. POKEMON. EVERYWHERE!!!");
        addGreetingDialogue("EVERYWHERE I GO, THEY FOLLOW ME.");
        addGreetingDialogue("I CAN'T SEEM TO ESCAPE!");
        addGreetingDialogue("IS THIS MY ETERNAL PUNISHMENT?!?");
        addGreetingDialogue("Sorry, not sure what came over me there.");
        addGreetingDialogue("If you see any Pokemon around here, you must tell me.");
        addGreetingDialogue("Have you seen any Pokemon?");

        //Button responses
        setGoodButtonText("Nope. None in this store!");
        setBadButtonText("Yeah! They're all over the place!");

        //Good Response
        addHappyResponse("EXCELLENT! Perhaps that pesticide worked this time.");
        addHappyResponse("Be sure to stay vigilant. We cannot let them overrun this store.");
        addHappyResponse("For your troubles I have something for you...");
        addHappyResponse("-YEOWWCH!!!");
        addHappyResponse("MONEY! TAKE! NO POKEMON! AGHHGHGH!!!");

        //Mad Response
        addMadResponse("NO! I THOUGHT I GOT RID OF THEM!");
        addMadResponse("NOW I HAVE TO BURN THIS STORE TO THE GROUND AND REBUILD!");
        addMadResponse("I MUST PLAN THIS OUT!");
        addMadResponse("HERE! MONEY! TAKE! NO POKEMON!");

        //Lore Dialogue
        addLoreDialogue("Ugh. I've been trying to get rid of these things.");
        addLoreDialogue("I'm going to have to have a word with your boss by having this in store.");
        addLoreDialogue("As one of my underlings, he should have reported it to me immediately.");
        addLoreDialogue("The quest to get rid of all Pokemon has consumed my life...");
        addLoreDialogue("I had to leave my teaching job and come here!");
        addLoreDialogue("BUT ONE DAY I WILL GET RID OF THEM ALL!");

        //Farewell Dialogue
        addFarewellDialogue("I must go now as I need to be on the look out.");
        addFarewellDialogue("You never know when pesky Pokemon could be lurking!");
        addFarewellDialogue("Heck! They could be on your back right now and you would never know!");
        addFarewellDialogue("Anyway, I hope your job goes well!");

    }
}
