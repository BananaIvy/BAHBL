package edu.up.cs301.bahbl;

import java.util.Timer;

import edu.up.cs301.GameFramework.infoMessage.GameState;

/**
 * This contains the state for the Counter game. This class contains all the variables
 * that keep track of the progress of the game. For example the array of customers,
 * the story progress, dialogue indexs, etc.
 *
 * @author Savannah I. Macdonald
 * @author Laura A. Patla
 * @author Madilynn Greenup
 * @author Alex Baker
 * @version Feb 2025
 */
public class BahGameState extends GameState {

	private final Timer time = new Timer(true);
	public long endSceneStartTime = -1;
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
	private int totalLikeability;

	//Tells us what we have in our inventory
	private boolean hasKey;
	private boolean hasPokeball;
	private boolean hasInfoBot;
	private boolean hasBag;
	private boolean hasPokeDex;
	private Boolean buttonIsVisible;
	private String goodButtonText;
	private String badButtonText;

	//For the Bad Ending
	private int endScene;

	//For Trivia Mini Game
	private int correctAnswersCount;

	//The correct answers go in the order 2, 4, 1, 4, 2
	private String[] triviaQuestions = {"What should I quiz you on?", "Okay so, what is the mascot of Pokemon?",
			"Which one of these is a God Pokemon?", "Which of these is a Pokemon?", "Am I adorable?" };
	private String[] triviaAnswer1= {"Cats", "Squirtle", "Mew", "Luxiq", "No way"};
	private String[] triviaAnswer2= {"Pokemon", "Bongo Cat", "Pikachu", "Ticlid", "Just a little"};
	private String[] triviaAnswer3= {"Nothing", "Charizard", "Abra", "Carnitor", "Nope"};
	private String[] triviaAnswer4= {"Everything", "Pikachu", "Ditto", "Sentret", "Very, like a pet"};
	private int questionsAnwsered;
    private boolean gameTime;
	private boolean correctAnswer;
	private boolean triviaButtonClicked;
	//To update the trivia questions
	private int triviaSection;

	private BahPokemon[] pokemons = {new BahPokemon("bell"),new BahPokemon("ghast"),new BahPokemon("pikachu"),new BahPokemon("egg"),new BahPokemon("worm"),new BahPokemon("geode"),new BahPokemon("diglett"),new BahPokemon("ditto")};


	//Constructor for start of game
	public BahGameState(){
		storyProgress = 0;
		moneyCount = 0;
		totalLikeability = 0;
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
		endScene = 0;
		correctAnswersCount = 0;
		triviaButtonClicked = false;
		triviaSection = 0;
		gameTime = false;
		questionsAnwsered = 0;

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
		endScene = currentState.endScene;
		correctAnswersCount = currentState.correctAnswersCount;
		triviaQuestions = currentState.triviaQuestions;
		triviaAnswer1 = currentState.triviaAnswer1;
		triviaAnswer2 = currentState.triviaAnswer2;
		triviaAnswer3 = currentState.triviaAnswer3;
		triviaAnswer4 = currentState.triviaAnswer4;
        gameTime = currentState.gameTime;
		correctAnswer = currentState.correctAnswer;
		triviaButtonClicked = currentState.triviaButtonClicked;
		triviaSection = currentState.triviaSection;
		gameTime = currentState.gameTime;
		questionsAnwsered = currentState.questionsAnwsered;
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
		if(customerDialogueType == 6) {
			return customers[customerIndex].getGameReturn(dialogueIndex);
		}
		return "somethings wrong with getCustomerDialogue";
	}
	public int getQuestionsAnwsered(){return questionsAnwsered;}
	public int getTriviaSection(){return triviaSection;}
	public boolean isCorrectAnswer(){return correctAnswer;}
	public boolean isTriviaButtonClicked() {return triviaButtonClicked;}
	public boolean isGameTime(){return gameTime;}
	public int getCorrectAnswersCount() {return correctAnswersCount;}
	public String getTriviaQuestions(int i) {return triviaQuestions[i];}
	public String getTriviaAnswer1(int i) {return triviaAnswer1[i];}
	public String getTriviaAnswer2(int i) {return triviaAnswer2[i];}
	public String getTriviaAnswer3(int i) {return triviaAnswer3[i];}
	public String getTriviaAnswer4(int i) {return triviaAnswer4[i];}
	public int getCustomerDialogueType() {return customerDialogueType;}
	public String getGoodButtonText() {return goodButtonText;}
	public String getBadButtonText() {return badButtonText;}
	public Boolean getButtonIsVisible() {return buttonIsVisible;}
	public int getStoryProgress() {return storyProgress;}
	public int getMoneyCount() {return moneyCount;}
	public int getTotalLikeability() {return totalLikeability;}
	public BahCustomerBase getCustomer() {return customers[customerIndex];}
	public boolean isHasBag() {return hasBag;}
	public boolean isHasInfoBot() {return hasInfoBot;}
	public boolean isHasKey() {return hasKey;}
	public boolean isHasPokeball() {return hasPokeball;}
	public boolean isHasPokeDex() {return hasPokeDex;}
	public int getDialogueIndex() {return dialogueIndex;}
	public int getEndScene() {return endScene;}
	public BahPokemon[] getPokemons(){return pokemons;}

	//Setter Methods

	//For trivia section we only increase by one each time
	public void setQuestionsAnwsered(int questionsAnwsered){this.questionsAnwsered = questionsAnwsered;}
	public void setTriviaSection(){this.triviaSection++;}
	public void setCorrectAnswer(boolean correctAnswer){this.correctAnswer = correctAnswer;}
	public void setTriviaButtonClicked(boolean triviaButtonClicked){this.triviaButtonClicked = triviaButtonClicked;}
	public void setGameTime(boolean gameTime){this.gameTime = gameTime;}
	public void setCorrectAnswersCount(int correctAnswersCount) {this.correctAnswersCount = correctAnswersCount;}
	public void setTriviaQuestions(String triviaQuestions, int i) {this.triviaQuestions[i] = triviaQuestions;}
	public void setTriviaAnswer1(String triviaAnswer1, int i) {this.triviaAnswer1[i] = triviaAnswer1;}
	public void setTriviaAnswer2(String triviaAnswer2, int i) {this.triviaAnswer2[i] = triviaAnswer2;}
	public void setTriviaAnswer3(String triviaAnswer3, int i) {this.triviaAnswer3[i] = triviaAnswer3;}
	public void setTriviaAnswer4(String triviaAnswer4, int i) {this.triviaAnswer4[i] = triviaAnswer4;}
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
	public void progressStory() {this.storyProgress++;}

	//We don't want to be able to set the money, just add or lose money.
	public void addMoney(int moneyCount) {this.moneyCount += moneyCount;}
	public void loseMoney(int moneyCount) {this.moneyCount -= moneyCount;}
	public void addLikeability(int opinion) {this.totalLikeability += opinion;}
	public void loseLikeability(int opinion) {this.totalLikeability -= opinion;}
	public void nextCustomer(){
		customerIndex++;
	}

	public void nextEndScene(boolean isEnd){
		if(isEnd){
			endScene = 4;
			progressStory();
		}
		else{
			if (endSceneStartTime == -1) {
				endSceneStartTime = System.currentTimeMillis(); // set when first called
			}
			endScene = (endScene + 1) % 4;
			time.schedule(new BahTimer(this), 10000); // wait 10s before next step
		}
	}

	public void nextDialogue(){
		dialogueIndex++;
	}


}
