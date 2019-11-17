import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Creature {

    /** What the player carries */
    private ArrayList<Item> inventory;

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
    public void controls () {
        Scanner Controls = new Scanner(System.in);
        char ctrl = Controls.next().charAt(0);
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
        }


    }


    /** @return a list of {@link Item} the user is carrying. AKA the Inventory */
    public ArrayList<Item> getInventory() {
        return inventory;
    }


    public void movePlayer(Location location, String dir){
        if(location.dirExists(dir)) {
            // TODO: Add enemy encounter logic here
            this.currentLocation = location.stringToDir(dir);
            Main.println("You are now in " + this.currentLocation.toString());

        }else{
        Main.println("That direction doesn't exist, you're still in " + location.name);}
    }
}
