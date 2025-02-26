package edu.up.cs301.bahbl;

import edu.up.cs301.GameFramework.players.GameComputerPlayer;
import edu.up.cs301.GameFramework.infoMessage.GameInfo;
import edu.up.cs301.GameFramework.utilities.Tickable;

/**
 * A computer-version of a counter-player.  Since this is such a simple game,
 * it just sends "+" and "-" commands with equal probability, at an average
 * rate of one per second. 
 * 
 * @author Steven R. Vegdahl
 * @author Andrew M. Nuxoll
 * @version September 2013
 */
public class BAHBLCP1Ghost extends BAHBLComputerPlayerBase {
	
    /**
     * Constructor for objects of class BAHBLComputerPlayer1
     * 
     * @param name
     * 		the player's name
     */
    public BAHBLCP1Ghost(String name) {
        // invoke superclass constructor
        super(name);
    }
    
    /**
     * callback method--game's state has changed
     * 
     * @param info
     * 		the information (presumably containing the game's state)
     */
	@Override
	protected void receiveInfo(GameInfo info) {
		// Do something, most likely
	}

}
