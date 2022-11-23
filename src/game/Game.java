package game;

import java.util.Scanner;

import core.Pokeball;
import core.Pokemon;
import core.Stats;
import core.Type;
import engine.Encounter;
import utils.Destructible;

public class Game implements Destructible {
    private Player player;
    private Pokedex pokedex;
    private Inventory inventory;
    private Encounter encounter;
    private Scanner scanner;

    public Game(Player player, Pokemon starterPokemon, Inventory startingInventory) {
        this.player = player;
        this.inventory = startingInventory;

        this.pokedex = new Pokedex();
        this.pokedex.addPokemon(starterPokemon);

        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            System.out.println("\nYou are now ready to start your adventure " + player.getName() + "!");
            System.out.println("1. Walk");
            System.out.println("2. Pokedex");
            System.out.println("3. Visit Pokemon Center");
            System.out.println("4. Exit");

            System.out.print("> ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    this.walk();
                    break;
                case 2:
                    this.pokedex();
                    break;
                case 3:
                    this.visitPokemonCenter();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    this.start();
                    break;
            }
        } while (choice != 4);
    }

    public void walk() {
        double encounterChance = Math.random();
        if (encounterChance < 0.5) {
            this.handleEncounter();
        } else {
            System.out.println("You walked around and found nothing...");
        }
    }

    public void pokedex() {
        System.out.println("\nAll the pokemon you have caught so far:");
        for (int i = 0; i < this.pokedex.getOwnedPokemons().size(); i++) {
            Pokemon pokemon = this.pokedex.getOwnedPokemons().get(i);
            Stats stats = pokemon.getStats();
            System.out
                    .println((i + 1) + ". " + pokemon.getName() + " (" + stats.getCurrentHealthPoints() + "/"
                            + stats.getBaseHealthPoints() + ")");

            System.out.print("Type: ");
            for (int j = 0; j < pokemon.getTypes().length; j++) {
                Type type = pokemon.getTypes()[j];
                System.out.print(type);
                if (j < pokemon.getTypes().length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
            System.out.println();
        }
    }

    public void visitPokemonCenter() {
        System.out.println("\nWelcome to the Pokemon Center!");
        System.out.println("1. Heal all pokemon");
        System.out.println("2. Exit");

        System.out.print("> ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                for (Pokemon pokemon : this.pokedex.getOwnedPokemons()) {
                    pokemon.getStats().setCurrentHealthPoints(pokemon.getStats().getBaseHealthPoints());
                }
                System.out.println("All your pokemon have been healed!");
                break;
            case 2:
                System.out.println("Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
                this.visitPokemonCenter();
                break;
        }
    }

    private void handleEncounter() {
        Pokemon wildPokemon = this.getRandomPokemon();

        System.out.println("\nA wild " + wildPokemon.getName() + " appeared!");

        // Get currently available pokemon from the pokedex
        Pokemon availablePokemon = null;
        for (Pokemon pokemon : this.pokedex.getOwnedPokemons()) {
            if (pokemon.getStats().getCurrentHealthPoints() > 0) {
                availablePokemon = pokemon;
                break;
            }
        }

        if (availablePokemon == null) {
            System.out.println("You have no pokemon available to fight with!");
            System.out.println("You ran away...");
            return;
        }

        this.encounter = new Encounter(availablePokemon, wildPokemon);

        System.out.println("You sent out " + this.encounter.getAllyPokemon().getName() + "!");

        while (!this.encounter.isAllyDead() && !this.encounter.isOpponentDead()) {
            System.out.println("===========================");
            System.out.println("1. Fight");
            System.out.println("2. Inventory");
            System.out.println("3. Escape");
            System.out.println("===========================");

            Stats allyStats = this.encounter.getAllyPokemon().getStats();
            System.out.println("Your " +
                    this.encounter.getAllyPokemon().getName() + " HP: " + allyStats.getCurrentHealthPoints() + "/"
                    + allyStats.getBaseHealthPoints());

            Stats opponentStats = this.encounter.getOpponentPokemon().getStats();
            System.out.println("Wild " +
                    this.encounter.getOpponentPokemon().getName() + " HP: " + opponentStats.getCurrentHealthPoints()
                    + "/"
                    + opponentStats.getBaseHealthPoints());

            System.out.println("\nWhat will you do?");
            System.out.print("> ");
            int choice = this.scanner.nextInt();

            if (choice == 1) {
                this.fight();
            } else if (choice == 2) {
                boolean isPokemonCaptured = this.inventory();
                if (isPokemonCaptured) {
                    break;
                }
            } else if (choice == 3) {
                System.out.println("You escaped!");
                break;
            } else {
                System.out.println("Invalid choice");
                break;
            }
        }

    }

    private void fight() {
        System.out.println("You chose to fight!");

        this.encounter.allyAttack();

        System.out.println("Your " + this.encounter.getAllyPokemon().getName() + " attacked the wild "
                + this.encounter.getOpponentPokemon().getName() + "!");

        if (this.encounter.isOpponentDead()) {
            System.out.println("The wild Pokemon fainted!");
            return;
        }

        this.encounter.opponentAttack();

        System.out.println("The wild " + this.encounter.getOpponentPokemon().getName() + " attacked your "
                + this.encounter.getAllyPokemon().getName() + "!");

        if (this.encounter.isAllyDead()) {
            System.out.println("Your Pokemon fainted!");
        }
    }

    private boolean inventory() {
        boolean captured = false;
        System.out.println("You chose to check your inventory!");

        for (int i = 0; i < this.inventory.getItems().size(); i++) {
            System.out.println((i + 1) + ". " + this.inventory.getItems().get(i).getName());
        }

        System.out.print("> ");

        int choice = this.scanner.nextInt();
        if (choice > 0 && choice <= this.inventory.getItems().size()) {
            Item selectedItem = this.inventory.getItems().get(choice - 1);
            Pokeball pokeball = selectedItem.getPokeball();

            System.out.println("You chose to use " + pokeball.getName() + "!");
            if (this.encounter.attemptCapture(pokeball)) {
                System.out.println("You caught the wild Pokemon!");
                this.pokedex.addPokemon(this.encounter.getOpponentPokemon());
                captured = true;
            } else {
                System.out.println("The wild Pokemon broke free!");
            }

            this.inventory.removeItem(selectedItem, 1);
        } else {
            System.out.println("Invalid choice!");
        }

        return captured;
    }

    private Pokemon getRandomPokemon() {
        int pokemonAmount = Pokemon.values().length;
        int randomIndex = (int) (Math.random() * pokemonAmount);

        return Pokemon.values()[randomIndex];
    }

    public void destroy() {
        this.scanner.close();
        this.encounter.destroy();
        this.encounter = null;
        this.inventory.destroy();
        this.inventory = null;
        this.pokedex.destroy();
        this.pokedex = null;
        this.player.destroy();
        this.player = null;
    }
}
