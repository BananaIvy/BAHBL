package edu.up.cs301.bahbl;

import edu.up.cs301.GameFramework.infoMessage.GameState;

/**
 * This contains the state for the Counter game. The state consist of simply
 * the value of the counter.
 * 
 * @author Savannah M
 * @version Feb 2025
 */
public class BahGameState extends GameState {

	//Tracks where in the story we are
	private int storyProgress;
	private int moneyCount;


	private BahCustomerBase customer;
	//this int represents which set of customer dialogue we're currently on. The ints have the following meanings:
	//1: greeting, 2: happy response, 3: mad response, 4: lore 5: goodbye
	private int customerDialogue;
	//this number represents the index of the current text being displayed
	private int text;

	//Tells us what we have in our inventory
	private boolean hasKey;
	private boolean hasPokeball;
	private boolean hasInfoBot;
	private boolean hasBag;
	private boolean hasPokeDex;

	//Constructor for start of game
	public BahGameState(){
		storyProgress = 0;
		moneyCount = 0;
		hasKey = false;
		hasPokeball = false;
		hasInfoBot = false;
		hasBag = false;
		hasPokeDex = false;
		customer = new BahCGhost();
		customerDialogue = 1;
		text = 0;
	}

	//Copy Constructor
	public BahGameState(BahGameState currentState){
		storyProgress = currentState.storyProgress;
		moneyCount = currentState.moneyCount;
		customer = currentState.customer;
		hasKey = currentState.hasKey;
		hasPokeball = currentState.hasPokeball;
		hasInfoBot = currentState.hasInfoBot;
		hasBag = currentState.hasBag;
		hasPokeDex = currentState.hasPokeDex;
		customerDialogue = currentState.customerDialogue;
		text = currentState.text;
	}

	//Methods
	@Override
	public String toString(){
		String key = returnNo(hasKey) + "Key";
		String pokeball  = returnNo(hasPokeball) + "Pokeball";
		String infoBot = returnNo(hasInfoBot) + "Info Bot";
		String bag = returnNo(hasBag) + "Bag";

		return "Scene: " + storyProgress + "/n"     					//Story Progress
				+ "Customer: " + customer.getCustomerName() + "/n"  	//Character
				+ "Money: " + moneyCount + "/n"  						//Money
				+ "Inventory Items: " + "/n"  							//In our inventory
				+ key + "/n"  											//Item 1 = Key
				+ pokeball + "/n" 				 						//Item 2
				+ infoBot + "/n"  										//Item 3
				+ bag + "/n";  											//Item 4

	}

	//If we don't have an item, then the word "No" is added before the item in toString
	public String returnNo(boolean has){
		if(!has){return "No ";}
		else{return "";}
	}


	//Getter Methods
	public int getCustomerDialogue(){return customerDialogue;}
	public int getStoryProgress() {return storyProgress;}
	public int getMoneyCount() {return moneyCount;}
	public BahCustomerBase getCustomer() {return customer;}
	public boolean isHasBag() {return hasBag;}
	public boolean isHasInfoBot() {return hasInfoBot;}
	public boolean isHasKey() {return hasKey;}
	public boolean isHasPokeball() {return hasPokeball;}
	public boolean isHasPokeDex() {return hasPokeDex;}

	public int getText() {return text;}

	//Setter Methods
	public void setCustomer(BahCustomerBase customer) {this.customer = customer;}
	public void setCustomerDialogue(int newDialogue){customerDialogue = newDialogue;}

	public void setText(int text) {this.text = text;}
	public void setHasBag(boolean hasBag) {this.hasBag = hasBag;}
	public void setHasInfoBot(boolean hasInfoBot) {this.hasInfoBot = hasInfoBot;}
	public void setHasKey(boolean hasKey) {this.hasKey = hasKey;}
	public void setHasPokeball(boolean hasPokeball) {this.hasPokeball = hasPokeball;}
	public void setHasPokeDex(boolean hasPokeDex) {this.hasPokeDex = hasPokeDex;}
	public void setMoneyCount(int moneyCount) {this.moneyCount = moneyCount;}
	public void setStoryProgress(int storyProgress) {this.storyProgress = storyProgress;}

}
