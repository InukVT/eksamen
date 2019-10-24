package blog.inuk;

import java.util.ArrayList;

public class Player {
    public static ArrayList<Item> inventory;

    /** How much the player can carry */
    private static int carryWeight = 64;

    /** Adds an item to the players inventory, if the player can handle the weight. Returns true if successfull, otherwise false. */
    public static boolean appendInventory(Item item){
        if(canCarry(item)){
            inventory.add(item);
            return true;
        }
        return false;
    }

    /** Calculates weather the player can carry the passed in item */
    private static boolean canCarry(Item itemToAdd){
        int isCarrying = 0;
        for (Item item : inventory){
            isCarrying += item.weight;

        }
        if(isCarrying + itemToAdd.weight <= carryWeight){
            return true;
        }
        return false;
    }
}
