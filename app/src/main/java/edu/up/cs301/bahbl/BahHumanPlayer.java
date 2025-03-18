package edu.up.cs301.bahbl;

import edu.up.cs301.GameFramework.players.GameHumanPlayer;
import edu.up.cs301.GameFramework.GameMainActivity;
import edu.up.cs301.GameFramework.actionMessage.GameAction;
import edu.up.cs301.GameFramework.infoMessage.GameInfo;
import android.view.View;
import android.widget.Button;
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
 * @version July 2013
 */
public class BahHumanPlayer extends GameHumanPlayer implements OnClickListener {

	/* instance variables */

	// leftover from frankengaming the code, possibly unnecessary
	private TextView testResultsTextView;

	private TextView customerDialogue = null;

	private TextView registerMoney = null;
	
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
		// set the text in the appropriate widget
		String tempText = state.getCustomerDialogue();

		customerDialogue.setText(tempText);
	}

	/**
	 * this method gets called when the user clicks the '+' or '-' button. It
	 * creates a new CounterMoveAction to return to the parent activity.
	 * 
	 * @param button
	 * 		the button that was clicked
	 */
	public void onClick(View button) {
		// if we are not yet connected to a game, ignore
		if (game == null) return;

		testResultsTextView.setText("");

		BahGameState firstInstance = new BahGameState();

		BahGameState firstCopy = new BahGameState(firstInstance);
		//TODO here you're pretending that the player is clicking the buttons, and calling on what said actions would call
		//todo you're also printing an explanation of this as a string added to thing

		//todo: 1) Customer Greets - Click Dialog, Customer promts - Click Button, 3)Customer Reacts - Click Dialog,
		// todo 4) Customer Reacts - Click Inventory Item, 5) Customer Reacts - Click Dialog, 6) Customer give money - Click register
		//todo 7) Customer says goodbye - Click Dialog

		//When an action is created/sent then Local game makes the changes happen in game state as a reaction
		//so we don't need to manually affect most of the gamestate variables here.

		//todo might need to make all the action be sent to gamestate.
		//todo append custom texts to testResultsTextView
		//You get your first customer
		firstInstance.setCustomer(new BahCGhost());
		firstInstance.setCustomerDialogue("Ghost Boss greets you! \n");
		//Will give greeting dialogue
		testResultsTextView.append(firstInstance.getCustomerDialogue());

		//You click a button to respond to the customers text by clicking Button 1
		game.sendAction(new BahActionButton(this));
		//In response the dialogueType variable gets increased
		firstInstance.setCustomerDialogueType(2);
		firstInstance.setCustomerDialogue("You clicked the top-Happy button where you sign away your soul! \n");
		//Will update to happy response
		testResultsTextView.append(firstInstance.getCustomerDialogue());

		//You progress the text
		game.sendAction(new BahActionProgressText(this));
        //MONEY CHECK :D
        testResultsTextView.append("You currently have: $" + firstInstance.getMoneyCount() + "\n");
		//Will set to goodbye message
		firstInstance.setCustomerDialogue("Boss says bye & gave you key + \n");
		firstInstance.setHasKey(true);
		testResultsTextView.append(firstInstance.getCustomerDialogue());
		firstInstance.setCustomer(new BahCPokeangel());
		testResultsTextView.append("Current Customer is now: " + firstInstance.getCustomer().toString() + "\n");
		firstInstance.setCustomerDialogue("Customer greets you \n");
		testResultsTextView.append(firstInstance.getCustomerDialogue());

		//You click a button to respond to the customers text by clicking Button 1
		game.sendAction(new BahActionButton(this));
		testResultsTextView.append("You've clicked option 1 for this customer! :D \n");

		//You give the customer an item
		game.sendAction(new BahActionItem(this));
		testResultsTextView.append("You have given the customer an item");

		//You click the register
		game.sendAction(new BahActionRegister(this));
		//You get money as a result
		firstInstance.addMoney(1);
		testResultsTextView.append("You now have: $" + firstInstance.getMoneyCount() + "\n");
		//Will set to goodbye message
		firstInstance.setCustomerDialogue("Customer says goodbye \n");
		testResultsTextView.append(firstInstance.getCustomerDialogue());

		//You progress the text & move on to the next customer
		game.sendAction(new BahActionProgressText(this));
		testResultsTextView.append("You get sick of interacting with customers and no more progress is needed for this example! \n" + "You 'won' cuz you got some munz \n");


		//////////////////////////////////

		BahGameState secondInstance = new BahGameState();
		BahGameState secondCopy = new BahGameState(secondInstance);

		//todo compare these two to make sure they're equal by printing them to EditText view or smth
		testResultsTextView.append(firstCopy.toString() + "\n");
		testResultsTextView.append(secondCopy.toString());

		//Savi did this code which might be going ahead:

		if(button.getId() == R.id.Option1){
			game.sendAction(new BahActionButton(this, button));
			customerDialogue.append("You clicked button 1!");
		}
		if(button.getId() == R.id.Option2){
			game.sendAction(new BahActionButton(this, button));
			customerDialogue.append("You clicked button 2!");
		}
		if(button.getId() == R.id.customerDialogue){
			game.sendAction(new BahActionProgressText(this));
			customerDialogue.append("You clicked to Progess Text!");
		}
		if(button.getId() == R.id.register_keyboard){
			game.sendAction(new BahActionRegister(this));
			customerDialogue.append("You clicked the register!");
		}
		if(isItem(button)){
			game.sendAction(new BahActionItem(this, button));
			customerDialogue.append("You clicked an item!");
		}



	}// onClick

	public boolean isItem(View button){
		if(button.getId() == R.id.infoBot || button.getId() == R.id.bag || button.getId() == R.id.pokedex || button.getId() == R.id.pokeball || button.getId() == R.id.key){
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
		activity.setContentView(R.layout.run_test);

		this.testResultsTextView = (TextView) activity.findViewById(R.id.editTextTextMultiLine);

		Button runTestButton = (Button)activity.findViewById(R.id.runTestButton);
		runTestButton.setOnClickListener(this);


		//Code for our game. NOT FOR PART E SO WE COMMENT OUT!!!!


		//Initialize the widget reference member variables
		//this.customerDialogue = (TextView)activity.findViewById(R.id.customerDialogue);

//		// make this object the listener for both the '+' and '-' 'buttons
		//Button goodButton = (Button) activity.findViewById(R.id.Option1);
		//goodButton.setOnClickListener(this);
		//Button badButton = (Button) activity.findViewById(R.id.Option2);
		//badButton.setOnClickListener(this);

//
//		// remember the field that we update to display the counter's value
		//this.counterValueTextView =
				//(TextView) activity.findViewById(R.id.counterValueTextView);
//
		// if we have a game state, "simulate" that we have just received
		// the state from the game so that the GUI values are updated
		if (state != null) {
			receiveInfo(state);
		}
	}

}// class CounterHumanPlayer

