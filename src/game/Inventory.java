package game;

import java.util.ArrayList;

import utils.Destructible;

public class Inventory implements Destructible {
    private ArrayList<Item> items;

    public Inventory() {
        this.items = new ArrayList<Item>();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public Item findItem(Item item) {
        for (Item existingItem : this.items) {
            if (existingItem == item) {
                return existingItem;
            }
        }

        return null;
    }

    public void addItem(Item item) {
        Item existingItem = this.findItem(item);

        if (existingItem != null) {
            existingItem.setAmount(existingItem.getAmount() + item.getAmount());
        } else {
            this.items.add(item);
        }
    }

    public void removeItem(Item item, int amount) {
        Item existingItem = this.findItem(item);

        if (existingItem != null) {
            existingItem.setAmount(existingItem.getAmount() - amount);
        }
    }

    public void destroy() {
        this.items = null;
    }
}
