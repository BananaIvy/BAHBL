package edu.up.cs301.bahbl;

/**
 * This class creates the Customer Character "Lug"
 * implements the variables and the methods from
 * the CustomerBase class
 * <p>
 * @author AlexanderBaker
 * @version 02/26/2025
 */
public class BahCLug extends BahCustomerBase {


    public BahCLug(){
        super();
        setCustomerName("Lug");
        setHasGiven(false);
        setHasReceived(false);
        setItem(2);
        setBadButton(1);
        setGoodButton(2);
        resetDialogue();
        setMoney(45);
        setLikeability(80);

        /* dialogues */

        //greeting response
        addGreetingDialogue("Greetings!");
        addGreetingDialogue("My designator is X57345ROBOT!");
        addGreetingDialogue("But you can call me Lug!");
        addGreetingDialogue("It is a pleasure to make your acquaintance!");
        addGreetingDialogue("I am searching for an infobot. It looks like a small computer. Would you happen to have seen it?");

        //happy response
        addHappyResponse("Your assistance is most appreciated!");
        addHappyResponse("I would express my gratitude in a more...");
        addHappyResponse("Elaborate fashion,");
        addHappyResponse("But I suspect time is of the essence.");
        addHappyResponse("So instead,");
        addHappyResponse("I shall condense my sentiment into");
        addHappyResponse("A single, efficient statement:");
        addHappyResponse("Thank you!");
        addHappyResponse("Would you be able to give it to me?");

        //mad response
        addMadResponse("Ahhh!");
        addMadResponse("That was...");
        addMadResponse("Unexpected...");
        addMadResponse("However,");
        addMadResponse("I have calculated a 73% chance that this can still be resolved!");
        addMadResponse("A most encouraging probability!");
        addMadResponse("Unless of course my math is incorrect...");
        addMadResponse("Which is statistically impossible!");

        //lore response
        addLoreDialogue("This infoBot was the last thing I needed to get back!");
        addLoreDialogue("I got stuck down here after trying to travel to another planet.");
        addLoreDialogue("I was on my way to meet my friend Clank!");
        addLoreDialogue("But I took a little detour and got stuck here.");
        addLoreDialogue("I had no coordinates back to my home planet.");
        addLoreDialogue("But with this infoBot I have the coordinates I need!");

        //farewell response
        addFarewellDialogue("If I was coded with feelings and emotions,");
        addFarewellDialogue("I would be sad about my departure... :(");
        addFarewellDialogue("But since I am not I will leave you with a...");
        addFarewellDialogue("Farewell!");

        //button text responses
        setGoodButtonText("I've seen the infoBot!");
        setBadButtonText("I haven't seen an infoBot");

    }

}