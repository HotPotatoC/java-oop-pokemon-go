package core;

import utils.Destructible;

public enum Pokeball implements Destructible {
    POKEBALL("Pokeball", 1.0),
    GREATBALL("Greatball", 1.5),
    ULTRABALL("Ultraball", 2.0),
    MASTERBALL("Masterball", 255.0);

    private String name;
    private double successRate;

    Pokeball(String name, double successRate) {
        this.name = name;
        this.successRate = successRate;
    }

    public String getName() {
        return name;
    }

    public double getSuccessRate() {
        return successRate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSuccessRate(double successRate) {
        this.successRate = successRate;
    }

    public void destroy() {
        this.name = null;
        this.successRate = 0.0;
    }
}
