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
        addGreetingDialogue("I'm here for my monthly check in your boss.");
        addGreetingDialogue("I have to make sure all my stores are in working order.");
        addGreetingDialogue("...and make sure there are no pesky Pokemon anywhere.");
        addGreetingDialogue("THEY ARE CONSTANTLY AROUND ME AND WON'T LEAVE.");
        addGreetingDialogue("If you see them make sure to tell me.");
        addGreetingDialogue("Have you seen any Pokemon?");

        //Button responses
        setGoodButtonText("Nope. None in this store!");
        setBadButtonText("Yeah! They have been all over the place!");

        //Good Response
        addHappyResponse("That's good! I hoped would be none.");
        addHappyResponse("Make sure to keep an eye out for them and report them.");
        addHappyResponse("For your troubles I have something for you...");
        addHappyResponse("MONEY! TAKE! NO POKEMON!");

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
