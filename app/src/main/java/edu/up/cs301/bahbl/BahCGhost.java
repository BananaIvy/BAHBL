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
        setHasGiven(false);
        setHasReceived(false);
        setItem(1);
        setBadButton(1);
        setGoodButton(2);
        resetDialogue();
        setMoney(20);
        setLikeability(70);

        /** dialogues */
        //happy response
        addHappyResponse("Great! I'm glad to hear it!");
        addHappyResponse("By the way, here's a little ball I found lying on the floor...");
        addHappyResponse("See if one of the regular customers left it behind.");
        addHappyResponse("Just click an item to hand it to a customer.");
        addHappyResponse("Hand me the key if you don't feel ready and want more instruction");

        //mad response
        addMadResponse("Feeling nervous? Noted.");
        addMadResponse("Just...Don't disappoint me!");
        addMadResponse("And D O N T upset the customers. Give them whatever they want!");
        addMadResponse("Hand me the key if you'd like me to elaborate.");

        //greeting responses ("Welcome to BAHBL!");
        addGreetingDialogue("Hey, I'm glad you showed up! \n \n-(Click text to progress)-");
        addGreetingDialogue("I wasn't too sure you would.");
        addGreetingDialogue("The last guy quit suddenly and,");
        addGreetingDialogue("well...");
        addGreetingDialogue("Let's just say you didn't look the most trustworthy yourself.");
        addGreetingDialogue("But, don't worry about it.");
        addGreetingDialogue("I'm sure you'll be great for the job!");
        addGreetingDialogue("In a moment I'll give you the store key.");
        addGreetingDialogue("If anyone tries to rob you...");
        addGreetingDialogue("SWALLOW IT!");

        //lore responses
        addLoreDialogue("Great! All right, I'll try and keep this simple and quick.");
        addLoreDialogue("Customers may make weird requests of you. Be polite and don't refuse.");
        addLoreDialogue("Tap the register to collect their money,");
        addLoreDialogue("and send them on their way. Simple, right?");
        addLoreDialogue("Customers may give you items if they like you enough,");
        addLoreDialogue("Which you can keep under the register if you want,");
        addLoreDialogue("Keep in mind that they're probably stolen items.");
        addLoreDialogue("Folks that end up here in hell tend to be unsavory.");
        addLoreDialogue("Feel free to give away anything you have under the counter.");
        addLoreDialogue("Besides the key of course! ;)");
        addLoreDialogue("But note that most customers won't want stolen items for liability purposes");
        addLoreDialogue("If they're getting rid of the item, somebody's probably on their trail.");
        addLoreDialogue("Now, that concludes your training!");
        addLoreDialogue("Tap the register to start your shift!");

        //farewell responses
        addFarewellDialogue("All right, get to work");
        addFarewellDialogue("And remember,");
        addFarewellDialogue("If you die...");
        addFarewellDialogue("That waiver you signed...");
        addFarewellDialogue("Means I can't be held accountable. =)");

        //button text responses
        setGoodButtonText("I've got this, no worries!");
        setBadButtonText("Uhhhh....");

    }

    public BahCGhost(BahCustomerBase pastSelf){
        super();
        setCustomerName("Ghost2");
        setLikeability(pastSelf.getLikeability());
        setHasGiven(pastSelf.isHasGiven());
        setHasReceived(pastSelf.isHasReceived());
        setItem(1);
        setBadButton(1);
        setGoodButton(2);
        resetDialogue();
        setMoney(pastSelf.getMoney());

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