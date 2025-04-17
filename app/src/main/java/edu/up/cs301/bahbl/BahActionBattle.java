package edu.up.cs301.bahbl;

import android.view.View;

import edu.up.cs301.GameFramework.actionMessage.GameAction;
import edu.up.cs301.GameFramework.players.GamePlayer;

public class BahActionBattle extends GameAction {
    private String thisPokemon;

    private final String bell = "bell";
    private final String ghast = "ghast";
    private final String pikachu = "pikachu";
    private final String egg = "egg";
    private final String worm = "worm";
    private final String geode = "geode";
    private final String diglett = "diglett";
    private final String ditto = "ditto";

    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public BahActionBattle(GamePlayer player, View pokemon) {
        super(player);
        if(pokemon.getId() == R.id.bell){
            thisPokemon = bell;
        } else if (pokemon.getId() == R.id.ghast) {
            thisPokemon = ghast;
        }else if (pokemon.getId() == R.id.pikachu) {
            thisPokemon = pikachu;
        }else if (pokemon.getId() == R.id.egg) {
            thisPokemon = egg;
        }else if (pokemon.getId() == R.id.worm) {
            thisPokemon = worm;
        }else if (pokemon.getId() == R.id.geode) {
            thisPokemon = geode;
        }else if (pokemon.getId() == R.id.diglett) {
            thisPokemon = diglett;
        }else if (pokemon.getId() == R.id.ditto) {
            thisPokemon = ditto;
        }
    }

    public String getThisPokemon(){return thisPokemon;}
}
