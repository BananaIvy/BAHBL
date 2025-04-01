package edu.up.cs301.bahbl;

import edu.up.cs301.GameFramework.players.GameHumanPlayer;
import edu.up.cs301.GameFramework.GameMainActivity;
import edu.up.cs301.GameFramework.actionMessage.GameAction;
import edu.up.cs301.GameFramework.infoMessage.GameInfo;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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

	// Initializes all the widgets
	//private TextView 		testResultsTextView	= null;
	private TextView 		customerDialogue 	= null;
	private TextView 		registerMoney 		= null;
	private	Button 			goodButton 			= null;
	private	Button 			badButton 			= null;
	private ImageButton 	register 			= null;
	private ImageButton		key					= null;
	private ImageButton		pokeball	    	= null;
	private ImageButton		infoBot				= null;
	private ImageButton		pokeDex				= null;
	private ImageButton		bag					= null;

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


		goodButton.isClickable();

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

		if(button.getId() == R.id.Option1){
			game.sendAction(new BahActionButton(this, button));

		}
		else if(button.getId() == R.id.Option2){
			game.sendAction(new BahActionButton(this, button));

		}
		else if(button.getId() == R.id.customerDialogue){
			game.sendAction(new BahActionProgressText(this));

		}
		else if(button.getId() == R.id.register_keyboard){
			game.sendAction(new BahActionRegister(this));

		}
		else if(isItem(button)){
			game.sendAction(new BahActionItem(this, button));

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
		activity.setContentView(R.layout.bahbl_human_player);

		//this.testResultsTextView = (TextView) activity.findViewById(R.id.editTextTextMultiLine);

		//Button runTestButton = (Button)activity.findViewById(R.id.runTestButton);
		//runTestButton.setOnClickListener(this);


		//Initialize the widget reference member variables
		this.customerDialogue = (TextView)activity.findViewById(R.id.customerDialogue);
		this.goodButton = (Button) activity.findViewById(R.id.Option1);
		this.badButton = (Button) activity.findViewById(R.id.Option2);
		this.register = (android.widget.ImageButton) activity.findViewById((R.id.register_screen));
		this.infoBot = (android.widget.ImageButton) activity.findViewById(R.id.infoBot);
		this.bag = (android.widget.ImageButton) activity.findViewById(R.id.bag);
		this.pokeball = (android.widget.ImageButton) activity.findViewById((R.id.pokeball));
		this.pokeDex = (android.widget.ImageButton) activity.findViewById((R.id.pokedex));
		this.key  = (android.widget.ImageButton) activity.findViewById((R.id.key));
		this.registerMoney  = (TextView) activity.findViewById((R.id.total_monitor));


		// make this object listen for widget clicks
		customerDialogue.setOnClickListener(this);
		goodButton.setOnClickListener(this);
		badButton.setOnClickListener(this);
		register.setOnClickListener(this);
		infoBot.setOnClickListener(this);
		bag.setOnClickListener(this);
		pokeball.setOnClickListener(this);
		pokeDex.setOnClickListener(this);
		key.setOnClickListener(this);

		// if we have a game state, "simulate" that we have just received
		// the state from the game so that the GUI values are updated
		if (state != null) {
			receiveInfo(state);
		}
	}

}// class CounterHumanPlayer

