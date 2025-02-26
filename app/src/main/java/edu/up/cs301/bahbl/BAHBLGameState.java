package edu.up.cs301.bahbl;

import edu.up.cs301.GameFramework.infoMessage.GameState;


/**
 * This contains the state for the Counter game. The state consist of simply
 * the value of the counter.
 * 
 * @author Savannah M
 * @version Feb 2025
 */
public class BAHBLGameState extends GameState {

	//Tracks where in the story we are
	private int storyProgress;
	private int moneyCount;

	private BAHBLCustomerBase customer;

	//Tells us what we have in our inventory
	private boolean hasKey;
	private boolean hasPokeball;
	private boolean hasInfoBot;
	private boolean hasMysticManItem;

	//Constructor for start of game
	public BAHBLGameState(){
		storyProgress = 0;
		moneyCount = 0;
		hasKey = false;
		hasPokeball = false;
		hasInfoBot = false;
		hasMysticManItem = false;
		customer = new BAHBLGhost();
	}

	//Copy Constructor
	public BAHBLGameState(BAHBLGameState currentState){
		storyProgress = currentState.storyProgress;
		moneyCount = currentState.moneyCount;
		customer = currentState.customer;
		hasKey = currentState.hasKey;
		hasPokeball = currentState.hasPokeball;
		hasInfoBot = currentState.hasInfoBot;
		hasMysticManItem = currentState.hasMysticManItem;
	}

	//Methods
	@Override
	public String toString(){
		return "Scene: " + storyProgress + "/n"     //Story Progress
				+ "Customer: " + customer + "/n"  	//Character
				+ "Money: " + moneyCount + "/n"  	//Money
				+ "Inventory Items: " + "/n"  		//In our inventory
				+ " " + "/n"  //Item 1
				+ " " + "/n"  //Item 2
				+ " " + "/n"  //Item 3
				+ " " + "/n";  //Item 4

	}

	//Getter Methods

	//Setter Methods
}
