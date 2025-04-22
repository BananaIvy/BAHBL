package edu.up.cs301.bahbl;

public class BahPokemon {
    private String name;
    private boolean isOnNux;
    private boolean catchable;
    private int failCount;

    public BahPokemon(String name){
        this.name = name;
        isOnNux = true;
        catchable = false;
    }

    public BahPokemon(BahPokemon pokemon){
        this.name = pokemon.name;
        this.isOnNux = pokemon.isOnNux;
        this.catchable = pokemon.catchable;
    }

    public void battle(){
        isOnNux = false;
        catchable = true;
    }

    public void capture(boolean caught){
        isOnNux = !caught;
        catchable = false;
        if (!caught) {failCount++;}
    }

    public boolean isOnNux(){
        return isOnNux;
    }

    public boolean isCatchable() {
        return catchable;
    }

    public String getName() {return name;}

    public int getFailCount(){return failCount;}
}
