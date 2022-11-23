package core;

import utils.Destructible;

public class Stats implements Destructible {
    private int level;
    private int attack;
    private int defense;
    private double baseHealthPoints;
    private double currentHealthPoints;

    public Stats(int level, int attack, int defense, double baseHealthPoints) {
        this.level = level;
        this.attack = attack;
        this.defense = defense;
        this.baseHealthPoints = baseHealthPoints;
        this.currentHealthPoints = baseHealthPoints;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAttack() {
        double rngFactor = Math.random() * 0.15;
        return attack + (int) (attack * rngFactor);
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public double getBaseHealthPoints() {
        return baseHealthPoints;
    }

    public void setBaseHealthPoints(double baseHealthPoints) {
        this.baseHealthPoints = baseHealthPoints;
    }

    public double getCurrentHealthPoints() {
        return currentHealthPoints;
    }

    public void setCurrentHealthPoints(double currentHealthPoints) {
        this.currentHealthPoints = currentHealthPoints;
    }

    public void destroy() {
        this.level = 0;
        this.attack = 0;
        this.defense = 0;
        this.baseHealthPoints = 0.0;
        this.currentHealthPoints = 0.0;
    }
}
