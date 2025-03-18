package edu.up.cs301.bahbl;

/**
 * This class creates the Customer Character "Ghost"
 * implements the variables and the methods from
 * the CustomerBase class
 * <p>
 * @author Laura Patla
 * @version 2/26/25
 */
public class BahCGhost extends BahCustomerBase {


    public BahCGhost() {
        super();
        setCustomerName("Ghost");
        setLikeability(75);
        setHasGiven(false);
        setHasReceived(false);
        setItem(1);
        setBadButton(1);
        setGoodButton(2);
        resetDialogue();

        /* dialogues */
        //happy response
        addHappyResponse("Great! I'm glad to hear it, now get to work.");

        //mad response
        addMadResponse("Now, come on, I hired you for a reason. Don't disappoint me.");

        //greeting responses ("Welcome to BAHBL!");
        addGreetingDialogue("Hey, I'm glad you showed up!");
        addGreetingDialogue("I wasn't too sure you would.");
        addGreetingDialogue("The last guy quit suddenly and,");
        addGreetingDialogue("well...");
        addGreetingDialogue("Let's just say you didn't look the most trustworthy yourself.");
        addGreetingDialogue("But, don't worry about it.");
        addGreetingDialogue("I'm sure you'll be great for the job!");
        addGreetingDialogue("Now, here's the key to the register!");
        addGreetingDialogue("And if anyone tries to rob you...");
        addGreetingDialogue("SWALLOW IT!");

        //lore responses
        addLoreDialogue("Now, I'll try and keep this simple and quick.");
        addLoreDialogue("When a customer comes up, you'll greet them politely,");
        addLoreDialogue("Tap the register to collect their money,");
        addLoreDialogue("And send them on their way! Simple!");
        addLoreDialogue("Now, they may try to offer you items,");
        addLoreDialogue("Which you can keep under the register if you'd like,");
        addLoreDialogue("But, don't take anything dangerous!");
        addLoreDialogue("Some of the folks in these parts a little unsavory.");
        addLoreDialogue("Feel free to give away anything you have under the counter.");
        addLoreDialogue("Besides the key of course! ;)");
        addLoreDialogue("But note that most customers won't want those items.");
        addLoreDialogue("Now, if you have absolutely no more questions,");
        addLoreDialogue("Tap the register to start your shift!");

        //farewell responses
        addFarewellDialogue("All right, get to work");
        addFarewellDialogue("And remember,");
        addFarewellDialogue("If you die...");
        addFarewellDialogue("That waiver you signed...");
        addFarewellDialogue("Means I can't be held accountable.");

        //button text responses
        setGoodButtonText("I've got this, no worries!");
        setBadButtonText("Uhhhh....");

    }

}