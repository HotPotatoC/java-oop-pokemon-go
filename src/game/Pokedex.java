package game;

import java.util.ArrayList;

import core.Pokemon;
import utils.Destructible;

public class Pokedex implements Destructible {
    private ArrayList<Pokemon> ownedPokemons;

    public Pokedex() {
        this.ownedPokemons = new ArrayList<Pokemon>();
    }

    public ArrayList<Pokemon> getOwnedPokemons() {
        return ownedPokemons;
    }

    public Pokemon findPokemon(Pokemon pokemon) {
        for (Pokemon ownedPokemon : this.ownedPokemons) {
            if (ownedPokemon == pokemon) {
                return ownedPokemon;
            }
        }

        return null;
    }

    public void addPokemon(Pokemon pokemon) {
        this.ownedPokemons.add(pokemon);
    }

    public void destroy() {
        this.ownedPokemons = null;
    }
}
