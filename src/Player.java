import java.util.ArrayList;
import java.util.Scanner;
/** The player class
 * */
public class Player extends Creature {
    private int potions = 0;
    /** What the player carries */
    private ArrayList<Item> inventory;
    private Boolean key = false;

    public Location currentLocation;


    /** Create a new player
     * @param name Required for {@link #toString()} */
    public Player(String name){
        super(name, 20);
        this.name = name;
        this.currentLocation = Location.start;
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



    /** Adds an item to the players inventory, if the player can handle the weight. Returns true if successfull, otherwise false.
     *
     * @param item a {@link Item} to be added to the players {@link #inventory}.
     *
     * @return <code>true</code> if the item added <code>false</code> if the item is too heavy for the user, and thus can't be added.
     * */
    public void appendInventory(Item item){
            this.inventory.add(item);
    }

    public void pickup (Location location){
        Scanner Controls = new Scanner(System.in);
        char ctrl = Controls.next().charAt(0);
        switch (ctrl){
            case 'y':
                if(location == Location.keyRoom){
                    key = true;
                    location.key = false;
                    Main.println("You picked up a key");
                } else if (location == location.potionRoom) {
                    potions = location.potions;
                    location.potions = 0;
                    Main.println("You picked up the potions!");
                }
                break;
            case 'n':
                Main.println("You let the key be");
                break;
            default:
                Main.println("Illegal move");
        }
    }


    public void move() {
        Scanner Controls = new Scanner(System.in);
        String string = Controls.next();
        if (string.length() > 1){
            Main.println("You've got too many characters");
        }else {
            char ctrl = string.charAt(0);
            switch (ctrl) {
                case 'e':
                    this.movePlayer(currentLocation, "east");
                    break;
                case 'w':
                    this.movePlayer(currentLocation, "west");
                    break;
                case 's':
                    this.movePlayer(currentLocation, "south");
                    break;
                case 'n':
                    this.movePlayer(currentLocation, "north");
                    break;
                case 'p':
                    if (potions > 0) {
                        if (50 - getHp() < 20) {
                            this.hp(50 - getHp());
                        } else {
                            this.hp(20);
                        }
                    } else {
                        Main.println("You don't have potions");
                    }
                    break;
                case 'p':
                    // use potion
                    // If none other key is keyed, this is what happens
                default:
                    Main.println("Illegal move");
            }
        }


    }


    /** @return a list of {@link Item} the user is carrying. AKA the Inventory */
    public ArrayList<Item> getInventory() {
        return inventory;
    }


    public void movePlayer(Location location, String dir){
        if(location.dirExists(dir)) {
            if(location.stringToDir(dir)==Location.bossRoom){
                Main.println("You've encountered the boss room");
                if(key){
                   this.currentLocation = location.stringToDir(dir);
                }
                else {
                    Main.println("You need the key to unlock the boss room");
                }
            }else {
                // TODO: Add enemy encounter logic here
                this.currentLocation = location.stringToDir(dir);
                Main.println("You are now in " + this.currentLocation.toString());
            }
        }else{
        Main.println("That direction doesn't exist, you're still in " + location.name);}
    }
}
