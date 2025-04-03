package edu.up.cs301.bahbl;

/**
 * This class creates the Customer Character "Ghost"
 * implements the variables and the methods from
 * the CustomerBase class
 * <p>
 * @author Laura Patla & Savannah M
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
        setMoney(20);


        /* dialogues */
        //happy response
        addHappyResponse("Great! I'm glad to hear it!");
        addHappyResponse("Here is a pokeball looking thing...");
        addHappyResponse("It may come in handy...keep it close...");
        addHappyResponse("You can also give people items!");
        addHappyResponse("Try with the key!");

        //mad response
        addMadResponse("Now, come on, I hired you for a reason.");
        addMadResponse("Don't disappoint me!");
        addMadResponse("You can also give people items!");
        addMadResponse("Try with the key!");

        //greeting responses ("Welcome to BAHBL!");
        addGreetingDialogue("Hey, I'm glad you showed up!");
        addGreetingDialogue("I wasn't too sure you would.");
        addGreetingDialogue("The last guy quit suddenly and,");
        addGreetingDialogue("well...");
        addGreetingDialogue("Let's just say you didn't look the most trustworthy yourself.");
        addGreetingDialogue("But, don't worry about it.");
        addGreetingDialogue("I'm sure you'll be great for the job!");
        addGreetingDialogue("Now, there's a key to the register under the desk!");
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

    public BahCGhost(BahCustomerBase introGhost){
        super();
        setCustomerName("Ghost");
        setLikeability(introGhost.getLikeability());
        setHasGiven(introGhost.isHasGiven());
        setHasReceived(introGhost.isHasReceived());
        setItem(1);
        setBadButton(1);
        setGoodButton(2);
        resetDialogue();
        setMoney(introGhost.getMoney());

        /* dialogues */
        //greeting responses ("Welcome to BAHBL!");
        addGreetingDialogue("You survived the day, congrats.");
        addGreetingDialogue("How'd it go?");

        //happy response
        addHappyResponse("Glad to hear that. I would hate to hear otherwise.");
        addHappyResponse("Don't worry about closing since it's your first day.");
        addHappyResponse("Just hand me the key & I'll take care of the rest");

        //mad response
        addMadResponse("w h a t ?");
        addMadResponse("w h a t  d i d  y o u  d o ?");
        addMadResponse("Give me the key. Now. Let me see what you've done.");

        //lore responses
        addLoreDialogue("This string shouldn't be called upon");

        //farewell responses
        addFarewellDialogue("Fix the code so this doesn't get reached");

        //button text responses
        setGoodButtonText("No problems! Went fine!");
        setBadButtonText("Well....... ehhhh");

    }
}