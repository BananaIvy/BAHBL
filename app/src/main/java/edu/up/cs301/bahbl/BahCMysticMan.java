package edu.up.cs301.bahbl;

/**
 * initializes the mystic man customer variables
 * @author Savannah I. Macdonald
 * @author Laura A. Patla
 * @author Madilynn Greenup
 * @version April 2025
 */

public class BahCMysticMan extends BahCustomerBase {

    public BahCMysticMan(){
        super();
        setCustomerName("Mystic Man");
        setItem(3);
        setBadButton(1);
        setGoodButton(2);
        resetDialogue();
        setMoney(40);
        setLikeability(20);

        /* dialogues */

        //greeting dialogue
        addGreetingDialogue("Have you ever noticed how only men go to hell?");
        addGreetingDialogue("Don't make that face, I can see it in your eyes.");
        addGreetingDialogue("I know that you realize more than you let on.");
        addGreetingDialogue("Never mind, play dumb, it doesn't matter to me.");
        addGreetingDialogue("I don't know why I even bother with such scarred mortal souls anyway.");
        addGreetingDialogue("I happen to be looking for something left outside this store.");
        addGreetingDialogue("It's in a small canvas bag. I need it for my spell work");
        addGreetingDialogue("Would you happen to have seen the bag I'm looking for?");
        addGreetingDialogue("I would be willing to make a trade for such a valuable item.");

        //happy response
        addHappyResponse("Excellent! Perhaps you aren't yet a lost cause.");
        addHappyResponse("The spirits that tear at your soul may still be tamed in time.");
        addHappyResponse("Here, take this pokedex. I think it may be useful for one of your other customers");

        //mad response
        addMadResponse("Of course you haven't! I don't know why I expected any better!");
        addMadResponse("Just sell me my wares and let me be on my way.");
        addMadResponse("I have important people wasting my time already, I don't need you.");

        //lore dialogue
        addLoreDialogue("You found my spell bag! Thank you.");
        addLoreDialogue("You know, I wasn't always such a pitiable creature.");
        addLoreDialogue("Believe it or not, I once had kings and queens bowing at my feet.");
        addLoreDialogue("They say that making a deal with the devil will only end poorly.");
        addLoreDialogue("But they really don't know the half of it");
        addLoreDialogue("Satan is a man of his word,");
        addLoreDialogue("which is more than I can say for myself, unfortunately.");
        addLoreDialogue("You have a spark in your aura, young one.");
        addLoreDialogue("Perhaps there is still a chance for you, after all.");
        addLoreDialogue("As for me, I dug my grave, as they say,");
        addLoreDialogue("and now I'll lie in it.");

        //farewell dialogue
        addFarewellDialogue("Well, I've wasted enough time here already.");
        addFarewellDialogue("Woe on he who heeds sweet Lucifer's call.");
        addFarewellDialogue("May your soul escape this hell you've tumbled into");
        addFarewellDialogue("For the rest of us, it's far too late for that.");

        //button texts
        setGoodButtonText("I may have seen it...");
        setBadButtonText("I'm not sure.");

    }
}
