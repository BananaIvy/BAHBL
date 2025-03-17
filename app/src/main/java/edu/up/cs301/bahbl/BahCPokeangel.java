package edu.up.cs301.bahbl;


/**
* 
* @author Steven R. Vegdahl
* @author Andrew M. Nuxoll
* @version September 2013
*/
public class BahCPokeangel extends BahCustomerBase {

	
	public BahCPokeangel(){
		super();
		setCustomerName("Pokeangel");
		setItem(4);
		setGreetingDialogue("Greetings, mortal soul. I seek sustenance in this fine establishment. However, all who encounter me must answer my riddle in order to remain in my holy presence." +
				"A puppy can go through the Green Glass Door, but a dog cannot. A school can go through the Green Glass Door, but a house cannot. Which of these can go through the Green Glass Door?");
		setHappyResponse("Indeed! You are wise beyond your years, mortal. May you bloom and bear rich fruit ere your time here comes to an end.");
		setMadResponse ("Alas, you disappoint me. I am afraid I must depart. Your presence sickens me.");
		setLoreDialogue("Alas, I have fallen from grace, like a gently floating petal on the wind. I must earn my way back to my eternal redemption.");
		setFarewellDialogue("May the ruler and overlord of all look kindly on you, mortal. Your current soul is too scarred to find rest here.");
		setGoodButtonText("A pepper");
		setBadButtonText("A piper");
	}

}
