package edu.up.cs301.bahbl;

public abstract class BAHBLCustomerBase {

    private String name;
    private boolean playersTurn;

    public BAHBLCustomerBase(){
        playersTurn = false;
    }

    public String getName() {
        return name;
    }

    public void setPlayersTurn(boolean playersTurn) {
        this.playersTurn = playersTurn;
    }

    public boolean getPlayersTurn(){
        return playersTurn;
    }
}
