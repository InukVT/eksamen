import java.util.ArrayList;

/** The player class
 * @author Bastian Inuk Christensen: inuk@ruc.dk
 * */
public class Player {

    /** What the player carries */
    private ArrayList<Item> inventory;
    /** Players health */
    private int hp;

    /** Name og Player */
    public String name;

    /** How much the player can carry */
    private int carryWeight;

    /** Create a new player
     * @param name Required for {@link #toString()} */
    public Player(String name){
        this.carryWeight = 64;
        this.name = name;
        this.hp = 20;
    }

    /** Player represented as a String
     *  <p>
     *  TODO: Find a better representation of player, like health
     *
     *  @return {@link Player}'s {@link #name}, as that represent the player the best
     *
     *  */
    @Override
    public String toString() {
        return name;
    }

    /** @return {@link #hp}*/
    public int getHp() {
        return hp;
    }

    /** Damage player
     *  @param amount the amount of health point to remove from the player*/
    public void damage(int amount){
        this.hp -= amount;
    }

    /** Adds an item to the players inventory, if the player can handle the weight. Returns true if successfull, otherwise false.
     *
     * @param item a {@link Item} to be added to the players {@link #inventory}.
     *
     * @return <code>true</code> if the item added <code>false</code> if the item is too heavy for the user, and thus can't be added.
     * */
    public boolean appendInventory(Item item){
        if(canCarry(item)){
            this.inventory.add(item);
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

    /** @return a list of {@link Item} the user is carrying. */
    public ArrayList<Item> getInventory() {
        return inventory;
    }

    /** Calculates weather the player can carry the passed in item
     * @param itemToAdd the item to calculate if is light enough to be added to the inventory
     * @return true if the item can be added, false if too heavy*/
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
