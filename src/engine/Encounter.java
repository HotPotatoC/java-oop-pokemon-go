package engine;

import core.Pokeball;
import core.Pokemon;
import core.Stats;
import utils.Destructible;

public class Encounter implements Destructible {
    private Pokemon ally, opponent;

    public Encounter(Pokemon ally, Pokemon opponent) {
        this.ally = ally;
        this.opponent = opponent;
    }

    public Pokemon getAllyPokemon() {
        return this.ally;
    }

    public Pokemon setAllyPokemon(Pokemon pokemon) {
        return this.ally = pokemon;
    }

    public Pokemon getOpponentPokemon() {
        return this.opponent;
    }

    public void allyAttack() {
        double damage = Math.abs(this.ally.getStats().getAttack() - this.opponent.getStats().getDefense());
        this.opponent.getStats().setCurrentHealthPoints(this.opponent.getStats().getCurrentHealthPoints() - damage);
    }

    public void opponentAttack() {
        double damage = Math.abs(this.opponent.getStats().getAttack() - this.ally.getStats().getDefense());
        this.ally.getStats().setCurrentHealthPoints(this.ally.getStats().getCurrentHealthPoints() - damage);
    }

    public boolean isAllyDead() {
        return this.ally.getStats().getCurrentHealthPoints() <= 0;
    }

    public boolean isOpponentDead() {
        return this.opponent.getStats().getCurrentHealthPoints() <= 0;
    }

    public boolean attemptCapture(Pokeball pokeball) {
        if (pokeball == Pokeball.MASTERBALL) {
            return true;
        }

        Stats pokemonStats = this.opponent.getStats();
        double maxHP = pokemonStats.getBaseHealthPoints();
        double currentHP = pokemonStats.getCurrentHealthPoints();
        double randomRate = Math.random() * 0.5;
        double randomStatusRate = Math.random() * 0.5;
        double result = ((3 * maxHP - 2 * currentHP) * randomRate * randomStatusRate * pokeball.getSuccessRate()) / 3
                * maxHP;

        double shakeProbability = 65536 * Math.pow(255 / result, -0.1875);

        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("It shakes " + (i + 1) + " times");
            double shakeCheck = Math.random() * 65536;
            if (shakeCheck >= shakeProbability) {
                return false;
            }
        }

        return true;
    }

    public void destroy() {
        this.ally = null;
        this.opponent = null;
    }
}
