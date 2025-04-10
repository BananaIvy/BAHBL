package edu.up.cs301.bahbl;

import edu.up.cs301.GameFramework.infoMessage.GameState;

/**
 * This contains the state for the Counter game. This class contains all the variables
 * that keep track of the progress of the game. For example the array of customers,
 * the story progress, dialogue indexs, etc.
 *
 * @author Savannah I. Macdonald
 * @author Laura A. Patly
 * @author Madilynn Greenup
 * @author Alex Baker
 * @version Feb 2025
 */
public class BahGameState extends GameState {

	private final BahCustomerBase manager = new BahCGhost();
	private final BahCustomerBase[] customers = {manager, new BahCPokeangel(), new BahCLug(), new BahCMysticMan(), new BahCNux(), new BahCGhost(manager)};
	private int customerIndex;
	/**
	 * this int represents which set of customer dialogue we're currently on. The ints have the following meanings:
	 * 1: greeting, 2: happy response, 3: mad response, 4: lore 5: goodbye
	*/
	private int customerDialogueType;
	private int dialogueIndex;
	private String customerDialogue;
	private int storyProgress;
	private int moneyCount;

	//Tells us what we have in our inventory
	private boolean hasKey;
	private boolean hasPokeball;
	private boolean hasInfoBot;
	private boolean hasBag;
	private boolean hasPokeDex;
	private Boolean buttonIsVisible;
	private String goodButtonText;
	private String badButtonText;

	//Constructor for start of game
	public BahGameState(){
		storyProgress = 0;
		moneyCount = 0;
		hasKey = false;
		hasPokeball = false;
		hasInfoBot = false;
		hasBag = false;
		hasPokeDex = false;
		customerIndex = 0;
		customerDialogueType = 1;
		dialogueIndex = 0;
		customerDialogue = customers[customerIndex].getGreetingDialogue(0);
		buttonIsVisible = false;
		goodButtonText = "";
		badButtonText = "";
	}

	//Copy Constructor
	public BahGameState(BahGameState currentState){
		storyProgress = currentState.storyProgress;
		moneyCount = currentState.moneyCount;
		hasKey = currentState.hasKey;
		hasPokeball = currentState.hasPokeball;
		hasInfoBot = currentState.hasInfoBot;
		hasBag = currentState.hasBag;
		hasPokeDex = currentState.hasPokeDex;
		customerIndex = currentState.customerIndex;
		customerDialogueType = currentState.customerDialogueType;
		dialogueIndex = currentState.dialogueIndex;
		customerDialogue = currentState.customerDialogue;
		buttonIsVisible = currentState.buttonIsVisible;
		goodButtonText = currentState.goodButtonText;
		badButtonText = currentState.badButtonText;
	}

	//Methods
	@Override
	public String toString(){
		String key = returnNo(hasKey) + "Key";
		String pokeball  = returnNo(hasPokeball) + "Pokeball";
		String infoBot = returnNo(hasInfoBot) + "Info Bot";
		String bag = returnNo(hasBag) + "Bag";

		return  "GAMESTATE-TO-STRING! \n"
				+ "Scene: " + storyProgress + "\n"     					//Story Progress
				+ "Customer: " + customers[customerIndex].getCustomerName() + "\n"  	//Character
				+ "Dialogue Type: " + customerDialogueType + "\n"		//Dialogue Type
				+ "Dialogue Progress: " + dialogueIndex + "\n"					//Dialogue Progress
				+ "Money: " + moneyCount + "\n"  						//Money
				+ "Inventory Items: " + "\n"  							//In our inventory
				+ key + "\n"  											//Item 1 = Key
				+ pokeball + "\n" 				 						//Item 2
				+ infoBot + "\n"  										//Item 3
				+ bag + "\n";  											//Item 4

	}

	//If we don't have an item, then the word "No" is added before the item in toString
	public String returnNo(boolean has){
		if(!has){return "No ";}
		else{return "";}
	}

	//Getter Methods
	public String getCustomerDialogue() {
		if(customerDialogueType == 1){
			return customers[customerIndex].getGreetingDialogue(dialogueIndex);
		}
		if(customerDialogueType == 2){
			return customers[customerIndex].getHappyResponse(dialogueIndex);
		}
		if(customerDialogueType == 3){
			return customers[customerIndex].getMadResponse(dialogueIndex);
		}
		if(customerDialogueType == 4){
			return customers[customerIndex].getLoreDialogue(dialogueIndex);
		}
		if(customerDialogueType == 5){
			return customers[customerIndex].getFarewellDialogue(dialogueIndex);
		}
		return "somethings wrong with getCustomerDialogue";
	}
	public int getCustomerDialogueType() {return customerDialogueType;}
	public String getGoodButtonText() {return goodButtonText;}
	public String getBadButtonText() {return badButtonText;}
	public Boolean getButtonIsVisible() {return buttonIsVisible;}
	public int getStoryProgress() {return storyProgress;}
	public int getMoneyCount() {return moneyCount;}
	public BahCustomerBase getCustomer() {return customers[customerIndex];}
	public boolean isHasBag() {return hasBag;}
	public boolean isHasInfoBot() {return hasInfoBot;}
	public boolean isHasKey() {return hasKey;}
	public boolean isHasPokeball() {return hasPokeball;}
	public boolean isHasPokeDex() {return hasPokeDex;}
	public int getDialogueIndex() {return dialogueIndex;}


	//Setter Methods
	public void setGoodButtonText(String goodButtonText) {this.goodButtonText = goodButtonText;}
	public void setBadButtonText(String badButtonText) {this.badButtonText = badButtonText;}
	public void setButtonIsVisible(Boolean buttonIsVisible) {this.buttonIsVisible = buttonIsVisible;}
	public void setCustomerDialogueType(int newDialogueType){this.customerDialogueType = newDialogueType;}
	public void setDialogueIndex(int dialogueIndex) {this.dialogueIndex = dialogueIndex;}
	public void setHasBag(boolean hasBag) {this.hasBag = hasBag;}
	public void setHasInfoBot(boolean hasInfoBot) {this.hasInfoBot = hasInfoBot;}
	public void setHasKey(boolean hasKey) {this.hasKey = hasKey;}
	public void setHasPokeball(boolean hasPokeball) {this.hasPokeball = hasPokeball;}
	public void setHasPokeDex(boolean hasPokeDex) {this.hasPokeDex = hasPokeDex;}
	public void setStoryProgress(int storyProgress) {this.storyProgress = storyProgress;}

	//We don't want to be able to set the money, just add or lose money.
	public void addMoney(int moneyCount) {this.moneyCount += moneyCount;}
	public void loseMoney(int moneyCount) {this.moneyCount -= moneyCount;}
	public void nextCustomer(){
		customerIndex++;
	}


}
