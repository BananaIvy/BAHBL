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
		setLikeability(50);
		setHasGiven(false);
		setHasReceived(false);
		setItem(4);
		setBadButton(1);
		setGoodButton(2);
		resetDialogue();


		/* dialogues */
		//happy response
		addHappyResponse("Indeed!");
		addHappyResponse("You are wise beyond your years mortal!");
		addHappyResponse("May you bloom and bear rich fruit,");
		addHappyResponse("Ere your time here comes to an end!");
		addHappyResponse("Take my money! Click the register!");

		//mad response
		addMadResponse("Alas,");
		addMadResponse("You have disappointed me :(");
		addMadResponse("I am afraid I must depart...");
		addMadResponse("Your presence sickens me.");
		addHappyResponse("Take my money! Click the register!");

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
		addGreetingDialogue("Therefore, which of these can go through the Green Glass Door");

		//lore response
		addLoreDialogue("Alas, I have fallen from grace.");
		addLoreDialogue("Like a gently floating petal on the wind.");
		addLoreDialogue("I must earn my way back to my eternal redemption");

		//farewell response
		addFarewellDialogue("May the ruler and overlord of all look kindly on you, mortal.");
		addFarewellDialogue("Your current soul is too scarred to find rest here.");

		//button text responses
		setGoodButtonText("A pepper");
		setBadButtonText("A piper");

	}

}