package edu.up.cs301.bahbl;

public class BahPokemon {
    private String name;
    private boolean isOnNux;
    private boolean catchable;
    private int failCount;
    private boolean escaped;

    public BahPokemon(String name){
        this.name = name;
        isOnNux = true;
        catchable = false;
        escaped = false;
    }

    public BahPokemon(BahPokemon pokemon){
        this.name = pokemon.name;
        this.isOnNux = pokemon.isOnNux;
        this.catchable = pokemon.catchable;
        this.escaped = pokemon.escaped;
    }

    public void battle(){
        isOnNux = false;
        catchable = true;
    }

    public void capture(boolean caught){
        isOnNux = !caught;
        catchable = false;
        if (!caught) {
            failCount++;
            escaped = true;
        }
    }

    public boolean isOnNux(){
        return isOnNux;
    }

    public boolean isCatchable() {
        return catchable;
    }

    public String getName() {return name;}

    public int getFailCount(){return failCount;}

    public boolean hasEscaped() {return escaped;}

    public void escape(boolean escaped) {this.escaped = escaped;}
}
