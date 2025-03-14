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

	// The TextView the displays the current counter value
	private TextView testResultsTextView;
	
	// The TextView the displays the current counter value
	private TextView customerDialogue = null;
	
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
		String tempText = state.getText();

		customerDialogue.setText(tempText + "");
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

		//testResultsTextView.setText("");

		//MODIFIED CODE COMMENTED OUT FOR NOW!!!

		//sends it to see which button it iws
 		action = new BahActionButton(this, button);

	}// onClick


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


		//Code for our game. NOT FOR PART E SO WE COMMENT OUT!!!!


		//Initialize the widget reference member variables
		this.customerDialogue = (TextView)activity.findViewById(R.id.customerDialogue);

//		// make this object the listener for both the '+' and '-' 'buttons
		Button goodButton = (Button) activity.findViewById(R.id.Option1);
		goodButton.setOnClickListener(this);
		Button badButton = (Button) activity.findViewById(R.id.Option2);
		badButton.setOnClickListener(this);

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

