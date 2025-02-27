package edu.up.cs301.bahbl;

import android.widget.TextView;

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
	private String customerDialogue;

	//Tells us what we have in our inventory
	private boolean hasKey;
	private boolean hasPokeball;
	private boolean hasInfoBot;
	private boolean hasBag;
	private boolean hasPokeDex;

	//Constructor for start of game
	public BAHBLGameState(){
		storyProgress = 0;
		moneyCount = 0;
		hasKey = false;
		hasPokeball = false;
		hasInfoBot = false;
		hasBag = false;
		hasPokeDex = false;
		customer = new BAHBLGhost();
		customerDialogue = customer.getGreetingDialogue();
	}

	//Copy Constructor
	public BAHBLGameState(BAHBLGameState currentState){
		storyProgress = currentState.storyProgress;
		moneyCount = currentState.moneyCount;
		customer = currentState.customer;
		hasKey = currentState.hasKey;
		hasPokeball = currentState.hasPokeball;
		hasInfoBot = currentState.hasInfoBot;
		hasBag = currentState.hasBag;
		hasPokeDex = currentState.hasPokeDex;
		customerDialogue = currentState.customerDialogue;
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
	String returnNo(boolean has){
		if(!has){return "No ";}
		else{return "";}
	}


	/*
	Methods for each action
	 */
	public boolean buttonAction(BAHBLButtonAction action){
		//This action is valid when it is the players turn
		if(customer.getPlayersTurn()){
			//Modify the state of the game to match action taken
			if(action.getWhichButton() == customer.getGoodButton()){ //customers good button
				updateCustomerDialogue(customer.getHappyResponse());
				return true;
			}
			if(action.getWhichButton() == customer.getBadButton()){ //customers bad button
				updateCustomerDialogue(customer.getMadResponse());
				return true;
			}
		}
		return false; //action is not valid
	}

	public boolean itemAction(BAHBLItemAction action){
		//This action is valid when it is the players turn
		if(customer.getPlayersTurn()){
			//Checks if we have the item that was clicked
			if(action.getThisItem() == 1 && hasKey){
				return true;
			}
			else if(action.getThisItem() == 2 && hasInfoBot){
				return true;
			}
			else if(action.getThisItem() == 3 && hasBag){
				return true;
			}
			else if(action.getThisItem() == 4 && hasPokeball){
				return true;
			}
			else if(action.getThisItem() == 5 && hasPokeDex){
				return true;
			}
			else{
				return false; //we do not have the item, invalid move
			}
		}
		return false; //if action doesn't return true, then by default it's invalid
    }

	public boolean registerAction(BAHBLRegisterAction action){
		//This action is valid when it is the players turn
		if(customer.getPlayersTurn()){
			//Modify the state of the game to match action taken
			return true;
		}
		else{
			return false; //action is not valid
		}
	}

	public boolean progressTextAction(BAHBLProgressTextAction action){
		//This action is valid when it's the customers turn to speak & there's no action to do
		if(!customer.getPlayersTurn()){
			//Modify the state of the game to match action taken
			return true;
		}
		else{
			return false; //action is not valid
		}
	}

	public void updateCustomerDialogue(String newDialogue){
		customerDialogue = newDialogue;
	}

	//Getter Methods

	public String getCustomerDialogue(){return customerDialogue;}

	//Setter Methods
}
