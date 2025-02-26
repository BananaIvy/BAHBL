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

	//Each customer can have an ID number
	private int customer;

	//Tells us what we have in our inventory
	private boolean hasKey;
	private boolean hasPokeball;
	private boolean hasInfoBot;
	private boolean hasMysticManItem;

	//Constructor for start of game
	public BAHBLGameState(){
		storyProgress = 0;
		moneyCount = 0;
		customer = 78151920; //This is the word "ghost" but in numbers
		hasKey = false;
		hasPokeball = false;
		hasInfoBot = false;
		hasMysticManItem = false;
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

	//Getter Methods

	//Setter Methods
}
