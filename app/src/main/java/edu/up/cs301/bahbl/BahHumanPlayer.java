package edu.up.cs301.bahbl;

import edu.up.cs301.GameFramework.players.GameHumanPlayer;
import edu.up.cs301.GameFramework.GameMainActivity;
import edu.up.cs301.GameFramework.actionMessage.GameAction;
import edu.up.cs301.GameFramework.infoMessage.GameInfo;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;

/**
 * A GUI of a counter-player. The GUI displays the current value of the counter,
 * and allows the human player to press the '+' and '-' buttons in order to
 * send moves to the game.
 * 
 * Just for fun, the GUI is implemented so that if the player presses either button
 * when the counter-value is zero, the screen flashes briefly, with the flash-color
 * being dependent on whether the player is player 0 or player 1.
 * 
 * @author Steven R. Vegdahl
 * @author Andrew M. Nuxoll
 * @author Savannah I. Macdonald
 * @author Laura A. Patla
 * @author Madilynn Greenup
 * @author Alex Baker
 * @version July 2013
 */
public class BahHumanPlayer extends GameHumanPlayer implements OnClickListener {

	/* instance variables */

	// Initializes all the widgets
	//private TextView 		testResultsTextView	= null;
	private TextView 		customerDialogue 	= null;
	private TextView 		registerMoney 		= null;
	private	Button 			button1 			= null;
	private	Button 			button2 			= null;
	private ImageButton 	register 			= null;
	private ImageButton		key					= null;
	private ImageButton		pokeball	    	= null;
	private ImageButton		infoBot				= null;
	private ImageButton		pokeDex				= null;
	private ImageButton		bag					= null;
	private ImageButton     customer            = null;

	//Bad ending widgets
	private TextView		run					= null;
	private TextView		youDied				= null;
	private ImageView		background			= null;

	//Trivia widgets
	private TextView        questions           = null;
	private Button          triviaOptionOne     = null;
	private Button          triviaOptionTwo    	= null;
	private Button          triviaOptionThree   = null;
	private Button          triviaOptionFour    = null;
	private Button          triviaRightButton   = null;
	private Button          triviaWrongButton   = null;
	private ImageView       triviaPokeangel     = null;

	//Pokemon widgets
	//If time & energy exists, convert this all to an array.
	private ImageView		bell				= null;
	private ImageView		ghast				= null;
	private ImageView		pikachu				= null;
	private ImageView		geode				= null;
	private ImageView		diglett				= null;
	private ImageView		ditto				= null;
	private ImageView		egg					= null;
	private ImageView		worm				= null;
	private ImageButton		nbell				= null;
	private ImageButton		nghast				= null;
	private ImageButton		npikachu			= null;
	private ImageButton		ngeode				= null;
	private ImageButton		ndiglett			= null;
	private ImageButton		nditto				= null;
	private ImageButton		negg				= null;
	private ImageButton		nworm				= null;
	private ImageView		pokeballl			= null; //extra l because there's 2 pokeballs lol


	// the most recent game state, as given to us by the CounterLocalGame
	private BahGameState state;

	
	// the android activity that we are running
	private GameMainActivity myActivity;
	// Construct the action and send it to the game
	GameAction action = null;
	
	/**
	 * constructor
	 * @param name
	 * 		the player's name
	 */
	public BahHumanPlayer(String name) {
		super(name);
	}

	/**
	 * Returns the GUI's top view object
	 * 
	 * @return
	 * 		the top object in the GUI's view heirarchy
	 */
	public View getTopView() {
		return myActivity.findViewById(R.id.topLayout);
	}
	
	/**
	 * sets the dialog in the text view
	 */
	protected void updateDisplay() {

		//MAIN GAME-LINE
		if(!state.isGameTime()){

			mainLayout();

			//IF IT's THE ENDING
			if((state.getStoryProgress() >= 6)){
				if(state.getMoneyCount() > 71) { //todo fix this condition after fixing $ amounts.
					goodLayout();
				}
				else{
					badLayout();
				}
			}

		//POKEMON INTERACTION
		} else if (state.isGameTime() && state.getCustomer().getCustomerName().equals("Demon Lord Nux")) {
			boolean nextGameScreen = false;
			for(BahPokemon poke : state.getPokemons()){
				if(poke.isCatchable()){
					nextGameScreen = true;
				}
			}
			if(!nextGameScreen){
				nuxLayout();
			}else{
				pokeBattleLayout();
			}
		}



// for the trivia screen
		else if((state.isGameTime()) && (state.getCustomer()).getCustomerName().equals("Pokeangel")){

				if(!state.isTriviaButtonClicked()) {

					triviaLayout();
					questions.setText("" + state.getTriviaQuestions(state.getTriviaSection()));
					triviaOptionOne.setText("" + state.getTriviaAnswer1(state.getTriviaSection()));
					triviaOptionTwo.setText("" + state.getTriviaAnswer2(state.getTriviaSection()));
					triviaOptionThree.setText("" + state.getTriviaAnswer3(state.getTriviaSection()));
					triviaOptionFour.setText("" + state.getTriviaAnswer4(state.getTriviaSection()));

				}
				else if ((state.isCorrectAnswer() == true) && (state.isTriviaButtonClicked() == true)){

					triviaRightLayout();

				}
				else if ((state.isCorrectAnswer() == false) && state.isTriviaButtonClicked() == true) {

					triviaWrongLayout();

				}

		}
//end of trivia code
	}

	public void onClick(View button) {
		// if we are not yet connected to a game, ignore
		if (game == null) return;

		if(button.getId() == R.id.Option1){
			game.sendAction(new BahActionButton(this, button));
		}
		else if(button.getId() == R.id.Option2){
			game.sendAction(new BahActionButton(this, button));
		}
		else if(button.getId() == R.id.customerDialogue){
			game.sendAction(new BahActionProgressText(this));
		}
		else if(button.getId() == R.id.total_monitor || button.getId() == R.id.register_keyboard){
			game.sendAction(new BahActionRegister(this));
		}
		else if(isItem(button)){
			game.sendAction(new BahActionItem(this, button));
		}
		else if(button.getId() == R.id.run){
			game.sendAction(new BahActionRun(this));

		} else if(isTriviaButton(button)){
			game.sendAction(new BahActionTriviaButton(this, button));

		}else if(button.getId() == R.id.wrong){
			game.sendAction(new BahActionTriviaButton(this, button));

		}else if(button.getId() == R.id.right){
			game.sendAction(new BahActionTriviaButton(this, button));

		}else if (button.getId() == R.id.pokeballl) {
			game.sendAction(new BahActionCatch(this));

		}else if (isPokemon(button)) {
			game.sendAction((new BahActionBattle(this, button)));

		}
	}// onClick

	public boolean isItem(View button){
		if(button.getId() == R.id.infoBot || button.getId() == R.id.bag || button.getId() == R.id.pokedex || button.getId() == R.id.pokeball || button.getId() == R.id.key){
			return true;
		}
		return false;
	}

	public boolean isPokemon(View button){
		if(button.getId() == R.id.nditto || button.getId() == R.id.ndiglett || button.getId() == R.id.ngeode || button.getId() == R.id.negg || button.getId() == R.id.nbell || button.getId() == R.id.npikachu || button.getId() == R.id.nworm || button.getId() == R.id.nghast){
			return true;
		}
		return false;
	}

	public boolean isTriviaButton(View button){
		if(button.getId() == R.id.Trivia1 || button.getId() == R.id.Trivia2 || button.getId() == R.id.Trivia3 || button.getId() == R.id.Trivia4){
			return true;
		}
		return false;
	}

	public GameAction getAction() {
		return action;
	}

	/**
	 * callback method when we get a message (e.g., from the game)
	 * 
	 * @param info
	 * 		the message
	 */
	@Override
	public void receiveInfo(GameInfo info) {
		// ignore the message if it's not a CounterState message
		if (!(info instanceof BahGameState)) return;
		
		// update our state; then update the display
		this.state = (BahGameState)info;
		updateDisplay();
	}
	
	/**
	 * callback method--our game has been chosen/rechosen to be the GUI,
	 * called from the GUI thread
	 * 
	 * @param activity
	 * 		the activity under which we are running
	 */
	public void setAsGui(GameMainActivity activity) {
		
		// remember the activity
		this.myActivity = activity;

		// Load the layout resource for our GUI
		activity.setContentView(R.layout.bahbl_human_player);

		//Initialize the widget reference member variables
		this.customerDialogue = (TextView) activity.findViewById(R.id.customerDialogue);
		this.button1 = (Button) activity.findViewById(R.id.Option1);
		this.button2 = (Button) activity.findViewById(R.id.Option2);
		this.register = (android.widget.ImageButton) activity.findViewById((R.id.register_keyboard));
		this.infoBot = (android.widget.ImageButton) activity.findViewById(R.id.infoBot);
		this.bag = (android.widget.ImageButton) activity.findViewById(R.id.bag);
		this.pokeball = (android.widget.ImageButton) activity.findViewById((R.id.pokeball));
		this.pokeDex = (android.widget.ImageButton) activity.findViewById((R.id.pokedex));
		this.key = (android.widget.ImageButton) activity.findViewById((R.id.key));
		this.registerMoney = (TextView) activity.findViewById((R.id.total_monitor));
		this.customer = (ImageButton) activity.findViewById(R.id.customer);

		// make this object listen for widget clicks
		customerDialogue.setOnClickListener(this);
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		registerMoney.setOnClickListener(this);
		register.setOnClickListener(this);
		infoBot.setOnClickListener(this);
		bag.setOnClickListener(this);
		pokeball.setOnClickListener(this);
		pokeDex.setOnClickListener(this);
		key.setOnClickListener(this);
		customer.setOnClickListener(this);


		// if we have a game state, "simulate" that we have just received
		// the state from the game so that the GUI values are updated
		if (state != null) {
			receiveInfo(state);
		}
	}

	public void setUpTexts(){
		// Customer text/Dialogue
		String tempText = state.getCustomerDialogue();
		customerDialogue.setText(tempText);

		// Register Text
		tempText = Integer.toString(state.getMoneyCount());
		registerMoney.setText(tempText);

		//Button Texts
		if (state.getCustomer().getGoodButton() == 1) {
			tempText = state.getGoodButtonText();
			button1.setText(tempText);

			tempText = state.getBadButtonText();
			button2.setText(tempText);
		}
		else{
			tempText = state.getGoodButtonText();
			button2.setText(tempText);//todo maybe this is where we fix what buttons display?

			tempText = state.getBadButtonText();
			button1.setText(tempText);
		}

		customerDialogue.setClickable(true);

	}//texts

	public void setUpCustomer(){
		//Changes the customer to the gamestates one
		if(state.getCustomer() instanceof BahCGhost) {
			int resID = R.drawable.ghost;
			customer.setImageResource(resID);
		}
		else if(state.getCustomer() instanceof BahCPokeangel){
			int resID = R.drawable.pokeangel;
			customer.setImageResource(resID);
		}
		else if(state.getCustomer() instanceof BahCLug){
			int resID = R.drawable.lug;
			customer.setImageResource(resID);
		}
		else if(state.getCustomer() instanceof BahCMysticMan){
			int resID = R.drawable.mysticman;
			customer.setImageResource(resID);
		}
		else if(state.getCustomer() instanceof BahCNux){
			int resID = R.drawable.purple_delete_button;
			if(state.getCustomer().getLikeability() < 71){
				resID = R.drawable.nux;
			}else {
				resID = R.drawable.happynux;
			}
			customer.setImageResource(resID);
		}
		else{
			int resID = R.drawable.purple_delete_button;
			customer.setImageResource(resID);
		}
	}//customers

	public void setUpItems(){
		//Items
		if(state.isHasKey()){
			key.setClickable(true);
			key.setVisibility(View.VISIBLE);
		}
		else{
			key.setClickable(false);
			key.setVisibility(View.INVISIBLE);
		}
		if(state.isHasPokeball()){
			pokeball.setClickable(true);
			pokeball.setVisibility(View.VISIBLE);
		}
		else{
			pokeball.setClickable(false);
			pokeball.setVisibility(View.INVISIBLE);
		}
		if(state.isHasBag()){
			bag.setClickable(true);
			bag.setVisibility(View.VISIBLE);
		}
		else{
			bag.setClickable(false);
			bag.setVisibility(View.INVISIBLE);
		}
		if(state.isHasInfoBot()){
			infoBot.setClickable(true);
			infoBot.setVisibility(View.VISIBLE);
		}
		else{
			infoBot.setClickable(false);
			infoBot.setVisibility(View.INVISIBLE);
		}
		if(state.isHasPokeDex()){
			pokeDex.setClickable(true);
			pokeDex.setVisibility(View.VISIBLE);
		}
		else{
			pokeDex.setClickable(false);
			pokeDex.setVisibility(View.INVISIBLE);
		}
	}//items

	public void mainLayout(){

		// Load the layout resource for our GUI
		myActivity.setContentView(R.layout.bahbl_human_player);

		//Initialize the widget reference member variables
		this.customerDialogue = (TextView) myActivity.findViewById(R.id.customerDialogue);
		this.button1 = (Button) myActivity.findViewById(R.id.Option1);
		this.button2 = (Button) myActivity.findViewById(R.id.Option2);
		this.register = (android.widget.ImageButton) myActivity.findViewById((R.id.register_keyboard));
		this.infoBot = (android.widget.ImageButton) myActivity.findViewById(R.id.infoBot);
		this.bag = (android.widget.ImageButton) myActivity.findViewById(R.id.bag);
		this.pokeball = (android.widget.ImageButton) myActivity.findViewById((R.id.pokeball));
		this.pokeDex = (android.widget.ImageButton) myActivity.findViewById((R.id.pokedex));
		this.key = (android.widget.ImageButton) myActivity.findViewById((R.id.key));
		this.registerMoney = (TextView) myActivity.findViewById((R.id.total_monitor));
		this.customer = (ImageButton) myActivity.findViewById(R.id.customer);

		// make this object listen for widget clicks
		customerDialogue.setOnClickListener(this);
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		registerMoney.setOnClickListener(this);
		register.setOnClickListener(this);
		infoBot.setOnClickListener(this);
		bag.setOnClickListener(this);
		pokeball.setOnClickListener(this);
		pokeDex.setOnClickListener(this);
		key.setOnClickListener(this);
		customer.setOnClickListener(this);

		setUpCustomer();
		setUpTexts();
		setUpItems();
	}

	public void badLayout(){
		//Initialize the xml View
		myActivity.setContentView(R.layout.bahbl_bad_ending);
		this.run = (TextView) myActivity.findViewById(R.id.run);
		this.youDied = (TextView) myActivity.findViewById(R.id.deathmessage);
		this.background = (ImageView) myActivity.findViewById(R.id.bad_background);

		//The run text
		this.run.setOnClickListener(this);

		run.setClickable(true);
		youDied.setVisibility(View.INVISIBLE);

		//Cycles through the corridor animation
		if (state.getEndScene() == 0){
			int resId = R.drawable.first;
			background.setImageResource(resId);
		} else if (state.getEndScene() == 1) {
			int resId = R.drawable.second;
			background.setImageResource(resId);
		} else if (state.getEndScene() == 2) {
			int resId = R.drawable.third;
			background.setImageResource(resId);
		} else if (state.getEndScene() == 3) {
			int resId = R.drawable.fourth;
			background.setImageResource(resId);
		} else {

			//End screen!
			int resId = R.drawable.death;
			background.setImageResource(resId);

			run.setClickable(false);
			run.setVisibility(View.INVISIBLE);
			youDied.setVisibility(View.VISIBLE);
		}
	}//badLayout

	public void goodLayout(){
		this.myActivity.setContentView(R.layout.bahbl_good_ending);
	}

	public void triviaLayout(){
		//The xml view
		this.myActivity.setContentView(R.layout.bahbl_trivia_screen);

		//Sets up so we can change the question and button options
		this.questions = (TextView) myActivity.findViewById(R.id.Questions);
		this.triviaOptionOne = (Button) myActivity.findViewById(R.id.Trivia1);
		this.triviaOptionTwo = (Button) myActivity.findViewById(R.id.Trivia2);
		this.triviaOptionThree = (Button) myActivity.findViewById(R.id.Trivia3);
		this.triviaOptionFour = (Button) myActivity.findViewById(R.id.Trivia4);
		this.triviaPokeangel = (ImageView) myActivity.findViewById(R.id.triviaPokeangel);

		triviaOptionOne.setOnClickListener(this);
		triviaOptionTwo.setOnClickListener(this);
		triviaOptionThree.setOnClickListener(this);
		triviaOptionFour.setOnClickListener(this);


	}//triviaLayout

	public void triviaWrongLayout(){
		//The xml view
		this.myActivity.setContentView(R.layout.bahbl_trivia_wrong_screen);

		//sets up the one button
		this.triviaWrongButton = (Button) myActivity.findViewById(R.id.wrong);
		triviaWrongButton.setOnClickListener(this);
	}

	public void triviaRightLayout(){
		//The xml view
		this.myActivity.setContentView(R.layout.bahbl_trivia_right_screen);

		//sets up the one button
		this.triviaRightButton = (Button) myActivity.findViewById(R.id.right);
		triviaRightButton.setOnClickListener(this);
	}

	public void nuxLayout(){
		myActivity.setContentView(R.layout.bahbl_pokemon);

		nbell = myActivity.findViewById(R.id.nbell);
		nghast = myActivity.findViewById(R.id.nghast);
		npikachu = myActivity.findViewById(R.id.npikachu);
		nworm = myActivity.findViewById(R.id.nworm);
		ndiglett = myActivity.findViewById(R.id.ndiglett);
		nditto = myActivity.findViewById(R.id.nditto);
		ngeode = myActivity.findViewById(R.id.ngeode);
		negg = myActivity.findViewById(R.id.negg);

		nbell.setOnClickListener(this);
		nghast.setOnClickListener(this);
		npikachu.setOnClickListener(this);
		nworm.setOnClickListener(this);
		ndiglett.setOnClickListener(this);
		nditto.setOnClickListener(this);
		ngeode.setOnClickListener(this);
		negg.setOnClickListener(this);

		for (BahPokemon poke : state.getPokemons()) {
			// finds the catchable pokemon & makes them visible
			if (poke.isOnNux()) {
				if ("bell".equals(poke.getName())) {
					nbell.setVisibility(View.VISIBLE);
				} else if ("ghast".equals(poke.getName())) {
					nghast.setVisibility(View.VISIBLE);
				} else if ("pikachu".equals(poke.getName())) {
					npikachu.setVisibility(View.VISIBLE);
				} else if ("egg".equals(poke.getName())) {
					negg.setVisibility(View.VISIBLE);
				} else if ("worm".equals(poke.getName())) {
					nworm.setVisibility(View.VISIBLE);
				} else if ("geode".equals(poke.getName())) {
					ngeode.setVisibility(View.VISIBLE);
				} else if ("diglett".equals(poke.getName())) {
					ndiglett.setVisibility(View.VISIBLE);
				} else if ("ditto".equals(poke.getName())) {
					nditto.setVisibility(View.VISIBLE);
				}
			} else {
				if ("bell".equals(poke.getName())) {
					nbell.setVisibility(View.INVISIBLE);
					nbell.setClickable(false);
				} else if ("ghast".equals(poke.getName())) {
					nghast.setVisibility(View.INVISIBLE);
					nghast.setClickable(false);
				} else if ("pikachu".equals(poke.getName())) {
					npikachu.setVisibility(View.INVISIBLE);
					npikachu.setClickable(false);
				} else if ("egg".equals(poke.getName())) {
					negg.setVisibility(View.INVISIBLE);
					negg.setClickable(false);
				} else if ("worm".equals(poke.getName())) {
					nworm.setVisibility(View.INVISIBLE);
					nworm.setClickable(false);
				} else if ("geode".equals(poke.getName())) {
					ngeode.setVisibility(View.INVISIBLE);
					ngeode.setClickable(false);
				} else if ("diglett".equals(poke.getName())) {
					ndiglett.setVisibility(View.INVISIBLE);
					ndiglett.setClickable(false);
				} else if ("ditto".equals(poke.getName())) {
					nditto.setVisibility(View.INVISIBLE);
					nditto.setClickable(false);
				}
			}
		}


	}

	public void pokeBattleLayout(){
		myActivity.setContentView(R.layout.bahbl_pokemon_fight);

		bell = myActivity.findViewById(R.id.bell);
		ghast = myActivity.findViewById(R.id.ghast);
		pikachu = myActivity.findViewById(R.id.pikachu);
		worm = myActivity.findViewById(R.id.worm);
		diglett = myActivity.findViewById(R.id.diglett);
		ditto = myActivity.findViewById(R.id.ditto);
		geode = myActivity.findViewById(R.id.geode);
		egg = myActivity.findViewById(R.id.egg);
		pokeballl = myActivity.findViewById(R.id.pokeballl);

		pokeballl.setOnClickListener(this);

		for(BahPokemon poke : state.getPokemons()){
			//finds the catchable pokemon & makes them visible
			if(poke.isCatchable()){
				if(poke.getName() == "bell"){
					bell.setVisibility(View.VISIBLE);
				}else if (poke.getName() == "ghast") {
					ghast.setVisibility(View.VISIBLE);
				}else if (poke.getName() == "pikachu") {
					pikachu.setVisibility(View.VISIBLE);
				}else if (poke.getName() == "egg") {
					egg.setVisibility(View.VISIBLE);
				}else if (poke.getName() == "worm") {
					worm.setVisibility(View.VISIBLE);
				}else if (poke.getName() == "geode") {
					geode.setVisibility(View.VISIBLE);
				}else if (poke.getName() == "diglett") {
					diglett.setVisibility(View.VISIBLE);
				}else if (poke.getName() == "ditto") {
					ditto.setVisibility(View.VISIBLE);
				}
			}
		}
	}


}// class CounterHumanPlayer

//hi