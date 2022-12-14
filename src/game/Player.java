package game;

import utils.Destructible;

public class Player implements Destructible {
    private String name;
    private int money;

    public Player() {
    }

    public Player(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void destroy() {
        this.name = null;
        this.money = 0;
    }
}
