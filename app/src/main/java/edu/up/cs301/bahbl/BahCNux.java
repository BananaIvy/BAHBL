package edu.up.cs301.bahbl;

/**
 * this is Nux's customer setup
 * @author Savannah I. Macdonald
 * @author Laura A. Patla
 * @author Madilynn Greenup
 * @author Alex Baker
 * @version April 2025
 */
public class BahCNux extends BahCustomerBase {


    public BahCNux(){
        super();
        setCustomerName("DemonLordNux");
        setItem(5);
        setBadButton(1);
        setGoodButton(2);
        resetDialogue();
        setMoney(90);
        setLikeability(60);

        //Greeting Dialogue
        addGreetingDialogue("Well hello past student...funny seeing you here...");
        addGreetingDialogue("How did you end up in this place?");
        addGreetingDialogue("Ah well, it doesn't matter.");
        addGreetingDialogue("I'm here because of a... pokemon problem.");
        addGreetingDialogue("I may have told my students 'no pokemon...'");
        addGreetingDialogue("They. chose. pokemon.");
        addGreetingDialogue("CONSTANTLY. POKEMON. EVERYWHERE!!!");
        addGreetingDialogue("EVERYWHERE I GO, THEY FOLLOW ME.");
        addGreetingDialogue("I CAN'T SEEM TO ESCAPE!");
        addGreetingDialogue("IS THIS MY ETERNAL PUNISHMENT?!?");
        addGreetingDialogue("Sorry, not sure what came over me there.");
        addGreetingDialogue("If only I could learn how to get rid of them...");
        addGreetingDialogue("Will you help me remove some of these pests?");

        //Button responses
        setGoodButtonText("I may be able to help!");
        setBadButtonText("You secretly wanted pokemon, didn't you?");

        //Good Response
        addHappyResponse("EXCELLENT!");
        addHappyResponse("Be sure to stay vigilant. We cannot let them overrun this store.");
        addHappyResponse("-YEOWWCH!!!");
        addHappyResponse("IT BIT MY EAR!!!!");

        //Mad Response
        addMadResponse("WHAT PART OF NO DO YOU STUDENTS NOT UNDERSTAND?!?");
        addMadResponse("This is why you were my least favorite student.");
        addMadResponse("...");
        addMadResponse("I'm no longer a professor, I can diss you all I want.");

        //Lore Dialogue
        addLoreDialogue("UGHHH... ");
        addLoreDialogue("ooh, thank you for this pokedex. Now I'll be able to identify the pests.");
        addLoreDialogue("Not that I need to - they say their names out loud - but it will tell me their weaknesses!");
        addLoreDialogue("I'm going to have to have a word with your boss. I've seen signs of Pokemon around the store.");
        addLoreDialogue("As one of my underlings, he should have reported them to me immediately.");
        addLoreDialogue("The quest to get rid of all Pokemon has consumed my life...");
        addLoreDialogue("I had to leave my teaching job and come here!");
        addLoreDialogue("BUT ONE DAY I WILL GET RID OF THEM ALL!");

        //After mini game
        addGameReturn("THANK YOU!");
        addGameReturn("You were always my favorite student!");

        //Farewell Dialogue
        addFarewellDialogue("I must go now, as I need to be on the look out.");
        addFarewellDialogue("You never know when pesky Pokemon could be lurking!");
        addFarewellDialogue("Heck! They could be on your back right now and you would never know!");
        addFarewellDialogue("Anyway, I hope your job goes well!");

    }
}
