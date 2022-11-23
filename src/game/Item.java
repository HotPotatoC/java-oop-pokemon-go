package game;

import core.Pokeball;
import utils.Destructible;

public class Item implements Destructible {
    private Pokeball pokeball;
    private int amount;

    public Item(Pokeball pokeball, int amount) {
        this.pokeball = pokeball;
        this.amount = amount;
    }

    public Pokeball getPokeball() {
        return pokeball;
    }

    public String getName() {
        return this.pokeball.getName();
    }

    public void setPokeball(Pokeball pokeball) {
        this.pokeball = pokeball;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void destroy() {
        this.pokeball = null;
        this.amount = 0;
    }
}
