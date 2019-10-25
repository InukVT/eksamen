
import java.util.ArrayList;

/** The player class
 * @author Bastian Inuk Christensen: inuk@ruc.dk
 * */
public class Player {
    /** What the player carries */
    public ArrayList<Item> inventory;
    /** Players health */
    public int hp;
    /** Name og Player */
    public String name;

    /** How much the player can carry */
    private int carryWeight;

    /** Create a new player
     * @param name Required for {@link #toString()} */
    public Player(String name){
        this.carryWeight = 64;
        this.name = name;
    }

    /** Player represented as a String
     *  <p>
     *  TODO: Find a better representation of player, like health
     *
     *  @return Players name, as that represent the player the best
     *
     *  */
    @Override

    public String toString() {
        return name;
    }

    /** Adds an item to the players inventory, if the player can handle the weight. Returns true if successfull, otherwise false.
     *
     * @param item a {@link Item} to be added to the players {@link #inventory}.
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
