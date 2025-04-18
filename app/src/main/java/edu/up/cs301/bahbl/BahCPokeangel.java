package edu.up.cs301.bahbl;

/**
 * This class creates the Customer Character "Ghost"
 * implements the variables and the methods from
 * the CustomerBase class
 * <p>
 * @author Laura Patla
 * @version 3/17/25
 */
public class BahCPokeangel extends BahCustomerBase {

	
	public BahCPokeangel(){
		super();
		setCustomerName("Pokeangel");
		setHasGiven(false);
		setHasReceived(false);
		setItem(4);
		setBadButton(1);
		setGoodButton(2);
		resetDialogue();
		setMoney(55);
		setLikeability(40);

		/* dialogues */
		//happy response
		addHappyResponse("Indeed!");
		addHappyResponse("You are wise beyond your years mortal!");
		addHappyResponse("May you bloom and bear rich fruit,");
		addHappyResponse("Ere your time here comes to an end!");
		addHappyResponse("As a reward here is your prize, an infobot!");
		addHappyResponse("And since you have pleased me...");
		addHappyResponse("Please play this trivia game with me!");

		//mad response
		addMadResponse("Alas,");
		addMadResponse("You disappoint me :(");
		addMadResponse("I am afraid I must depart...");
		addMadResponse("Your presence sickens me.");

		//greeting response
		addGreetingDialogue("Greetings, mortal soul!");
		addGreetingDialogue("I seek sustenance in this fine establishment.");
		addGreetingDialogue("However, all who encounter me must first answer my riddle.");
		addGreetingDialogue("Only then will you be allowed to remain in my holy presence.");
		addGreetingDialogue("Here is the riddle.");
		addGreetingDialogue("A puppy can go through the Green Glass Door...");
		addGreetingDialogue("But a dog cannot!");
		addGreetingDialogue("A school can go through the Green Glass Door...");
		addGreetingDialogue("But a house cannot!");
		addGreetingDialogue("Therefore, which of these can go through the Green Glass Door?");

		//lore response
		addLoreDialogue("Ooohh pretty! It's a little me! I never thought I'd see such a perfect item *here*.");
		addLoreDialogue("It's a very difficult place to be, hell. If only I hadn't fallen from grace...");
		addLoreDialogue("...Like a gently floating petal on the wind...");
		addLoreDialogue("Alas, mortal, I must earn my way back to my eternal redemption.");
		addLoreDialogue("Until we meet again, at the gates of heaven or hell, young one!");

		//the after trivia game response
		addGameReturn("Thank you for playing my trivia game, it was a lot of fun.");
		addGameReturn("I'd like to buy my items, now. I have important demons to fight.");

		//farewell response
		addFarewellDialogue("Thank you, and may the ruler and overlord of all look kindly on you, mortal.");
		addFarewellDialogue("Your current soul is too scarred to find rest here.");

		//button text responses
		setGoodButtonText("A pepper");
		setBadButtonText("A piper");

	}

}