package blog.inuk;

import java.util.ArrayList;

/** The player class */
public class Player {
    public static ArrayList<Item> inventory;
    public static int hp;
    public static String name;

    /** How much the player can carry */
    private static int carryWeight = 64;

    /** Create a new player */
    public Player(){
    }

    @Override
    /** Player represented as a String
     *  @return Players name, as that represent the player the best
     *  TODO: Find a better representation of player, like health
     *  */
    public String toString() {
        return name;
    }

    /** Adds an item to the players inventory, if the player can handle the weight. Returns true if successfull, otherwise false.
     *
     * @param item The item to be added to the players inventory, only one inventory.
     *
     * @return <code>true</code> if the item added <code>false</code> if the item is too heavy for the user, and thus can't be added.
     * */
    public static boolean appendInventory(Item item){
        if(canCarry(item)){
            inventory.add(item);
            return true;
        }
        return false;
    }

    /** Drops item at index in inventory
     * @param item Where in <code>inventory</code> the item should be removed.
     * */
    public static void dropItem(int item){
       inventory.remove(item);
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
