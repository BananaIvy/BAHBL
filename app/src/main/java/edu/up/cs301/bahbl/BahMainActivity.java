package edu.up.cs301.bahbl;

import android.media.MediaPlayer;

import java.util.ArrayList;

import edu.up.cs301.GameFramework.GameMainActivity;
import edu.up.cs301.GameFramework.infoMessage.GameState;
import edu.up.cs301.GameFramework.players.GamePlayer;
import edu.up.cs301.GameFramework.LocalGame;
import edu.up.cs301.GameFramework.gameConfiguration.*;

/**
 * this is the primary activity for bahbl
 * 
 * @author Andrew Nuxoll
 * @author Steven Vegdahl
 * @author Laura Patla
 * @author Madilynn Greenup
 * @author Savannah Macdonald
 * @author Alex Baker
 * @version April 2025
 */
public class BahMainActivity extends GameMainActivity {
	
	// the port number that this game will use when playing over the network
	private static final int PORT_NUMBER = 2234;



	/**
	 * Create the default configuration for this game:
	 * - one human player vs. one computer player
	 * - minimum of 1 player, maximum of 2
	 * - one kind of computer player and one kind of human player available
	 * 
	 * @return
	 * 		the new configuration object, representing the default configuration
	 */
	@Override
	public GameConfig createDefaultConfig() {

		// Define the allowed player types
		ArrayList<GamePlayerType> playerTypes = new ArrayList<GamePlayerType>();
		
		// a human player player type (player type 0)
		playerTypes.add(new GamePlayerType("Local Human Player") {
			public GamePlayer createPlayer(String name) {
				return new BahHumanPlayer(name);
			}});

		// Create a game configuration class for Counter:
		// - player types as given above
		// - from 1 to 2 players
		// - name of game is "Counter Game"
		// - port number as defined above
		GameConfig defaultConfig = new GameConfig(playerTypes, 1, 2, "BAHBL",
				PORT_NUMBER);

		// Add the default players to the configuration
		defaultConfig.addPlayer("Human", 0); // player 1: a human player

		//We do not need a computer in our game, but I am commenting it out as we don't know if this will
		//cause issues

		//defaultConfig.addPlayer("Computer", 1); // player 2: a computer player
		
		// Set the default remote-player setup:
		// - player name: "Remote Player"
		// - IP code: (empty string)
		// - default player type: human player
		defaultConfig.setRemoteData("Remote Player", "", 0);
		
		// return the configuration
		return defaultConfig;

	}//createDefaultConfig

	/**
	 * create a local game
	 * 
	 * @return
	 * 		the local game, bahbl
	 */
	@Override
	public LocalGame createLocalGame(GameState state) {
		if (state == null) state = new BahGameState();
		return new BahLocalGame(state);
	}

}
