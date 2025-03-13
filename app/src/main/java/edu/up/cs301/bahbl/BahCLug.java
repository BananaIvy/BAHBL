package edu.up.cs301.bahbl;

//import space

/**
 * This class creates the Customer Character "Lug"
 * implements the variables and the methods from
 * the CustomerBase class
 * <p>
 * author:AlexanderBaker
 * version:02/26/2025
 */
public class BahCLug extends BahCustomerBase {


    //instance variables
    private String happyResponse;
    private String madResponse;
    private String loreDialogue;
    private String greetingDialogue;
    private String farewellDialogue;


    /**
     * constructor for the Lug object
     * implements the CustomerBase constructor
     * <p>
     * param String name - sets the name for the character
     */
    public BahCLug(){
        super();
        setCustomerName("Lug");
        setLikeability(75);
        setHasGiven(false);
        setHasReceived(false);

        //dialogues
        setHappyResponse("Your assistance is most appreciated. I would express my gratitude in" +
                " a more elaborate fashion, but I suspect time is of the essence. So instead," +
                " I shall condense my sentiment into a single, efficient statement: thank you");
        setMadResponse("Ah. That was... unexpected. However, I have calculated a 73% chance that" +
                " this can still be resolved. A most encouraging probability! Unless, of course," +
                " my math is incorrect—which is statistically unlikely.");
        setGreetingDialogue("Greetings! My designator is X57345ROBOT but you can call me Lug!" +
                " It is a pleasure to make your acquaintance!");
        setLoreDialogue("This infoBot was the last thing I needed to get back. I got stuck down " +
                "here after trying to travel to another planet to meet my friend Clank, but I " +
                "took a little detour and got stuck here. I had no coordinates back to my " +
                "home planet but this infoBot will give me the coordinates I need!");
        setFarewellDialogue("If I was coded with feelings and emotions I would be sad about my " +
                "departure, but since I am not I will leave you with a 'farewell!'");
        setGoodButtonText("Give Lug the infoBot you found");
        setBadButtonText("Tell Lug you haven't seen an infoBot");
    }

}