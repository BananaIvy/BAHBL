package edu.up.cs301.bahbl;

import edu.up.cs301.GameFramework.infoMessage.GameInfo;

/**
 * 
 * @author Laura Patla
 * @version 2/26/25
 */
public class
BAHBLGhost extends BAHBLCustomerBase {

    private String customerName;
    private int likeability;
    private boolean hasGiven;
    private boolean hasReceived;
    private String happyResponse;
    private String madResponse;
    private boolean playersTurn;
    private String loreDialogue;
    private String greetingDialogue;
    private String farewellDialogue;

    //If goodButton = 1, then that's the top button. If 2, then bottom button
    private int goodButton;
    private int badButton;
    private String goodButtonText;
    private String badButtonText;
    public BAHBLGhost() {
        super("Ghost");
        customerName = "Ghost";
        likeability = 75;
        hasGiven = false;
        hasReceived = false;
        happyResponse = "Great! I'm glad to hear it, now get to work.";
        madResponse = "Now, come on, I hired you for a reason. Don't disappoint me.";
        playersTurn = super.getPlayersTurn();
        greetingDialogue = "Hey, I'm glad you showed up. I wasn't too sure you would. The last guy quit suddenly and, well, let's just say you didn't look the most trustworthy yourself." +
                " But, don't worry about it, I'm sure you'll be great for the job. Here's the key to the register. If anyone tries to rob you, swallow it.";
        loreDialogue = "Now, I'll try and keep this simple and quick. When a customer comes up, you'll greet them politely and tap on the register to collect their money and send them away." +
                " They may try to offer you items, which you can keep under the counter if you like, but don't take anything dangerous. Some of the folks in these parts are a little unsavory." +
                " Feel free to give away anything you have under the counter (besides the key of course!), but note that most customers won't want those items. Now, if you have no more questions," +
                "just tap on the register to start your shift.";
        farewellDialogue = "All right, get to work, and remember, if you die, that waiver you signed means I can't be held accountable.";
        goodButton = super.getGoodButton();
        badButton = super.getBadButton();
        goodButtonText = "I've got this, no worries!";
        badButtonText = "Uhhhh....";
    }

}