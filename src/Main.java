import java.util.Scanner;

import core.Pokeball;
import core.Pokemon;
import game.Game;
import game.Inventory;
import game.Item;
import game.Player;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pokémon Go");
        System.out.println("==========");

        String name;
        System.out.println("What is your name?");
        System.out.print("> ");
        name = scanner.nextLine();

        Player player = new Player(name, 1000);
        System.out.println("\nHello, " + player.getName() + "!");

        System.out.println("Choose your starter pokemon");
        System.out.println("1. Bulbasaur");
        System.out.println("2. Charmander");
        System.out.println("3. Squirtle");

        System.out.print("> ");

        int starterPokemonChoice = scanner.nextInt();
        Pokemon starterPokemon = null;

        switch (starterPokemonChoice) {
            case 1:
                starterPokemon = Pokemon.BULBASAUR;
                break;
            case 2:
                starterPokemon = Pokemon.CHARMANDER;
                break;
            case 3:
                starterPokemon = Pokemon.SQUIRTLE;
                break;
            default:
                System.out.println("Invalid choice");
                System.exit(0);
        }

        Inventory startingInventory = new Inventory();
        startingInventory.addItem(new Item(Pokeball.POKEBALL, 10));
        startingInventory.addItem(new Item(Pokeball.GREATBALL, 5));
        startingInventory.addItem(new Item(Pokeball.ULTRABALL, 2));
        startingInventory.addItem(new Item(Pokeball.MASTERBALL, 1));

        Game game = new Game(player, starterPokemon, startingInventory);

        game.start();

        scanner.close();

        game.destroy();
        System.gc();
    }
}
