import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
/** The player class
 * */
public class Player extends Creature {
    public int potions = 0;
    /** What the player carries */
    private ArrayList<Item> inventory;
    private Boolean key = false;

    public Location currentLocation;
    public Item currentWeapon;


    /** Create a new player
     * @param name Required for {@link #toString()} */
    public Player(String name, Item item){
        super(name, 50, item);
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


    // key bound functions
    // y for pickup
    // n to reject pickup
    public void pickup (Location location){
        char ctrl = input().charAt(0);
        switch (ctrl){
            case 'y':
                if(location == Location.roomP){
                    key = true;
                    location.key = false;
                    Main.println("You picked up the key!");
                } else if (location == location.potionRoom) {
                    potions = location.potions;
                    location.potions = 0;
                    Main.println("You picked up the potions!");
                } else if (location == location.start) {
                    Main.println("You picked up the weapon! Go find the key! \nChose a way you wanna go:");
                    if(equip == equip.weapons.get(0)){
                        equip = location.item;
                    }
                    location.item = null;
                } else if (location == location.roomWeap) {
                    Main.println("You picked up the weapon");
                    if (equip == equip.weapons.get(0)) {
                        equip = location.item;
                    }
                    location.item = null;
                }
                break;
            case 'n':
                Main.println("You let the key be!");
                break;
            default:
                Main.println("Illegal move!");
        }
    }
    public String input(){
        Scanner scanner = new Scanner(System.in);
        // Stores the scanned string as all lowercase, to be case incensitive
        return scanner.next().toLowerCase();
    }

    public void move() {
        if (potions > 0 && getHp() < 50) {
            Main.println("Your HP is currently " + getHp() + ". Press (P) to use potions (+20 HP)");
        }
        if (currentLocation.north != null) {
            Main.println("Press (N) to move north");
        }
        if (currentLocation.south != null) {
            Main.println("Press (S) to move south");
        }
        if (currentLocation.east != null) {
            Main.println("Press (E) to move east");

        }if (currentLocation.west != null) {
            Main.println("Press (W) to move west");
        }

        String string = input();
        // Checks if the inputted text is more than a character
        // assigns the keys NSWE to move the player around
        // p key to use potions if the player has any
        if (string.length() > 1){
            Main.println("You've got too many characters!");
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
                    usePotion();
                    break;
                default:
                    Main.println("Illegal move!");
            }
        }


    }
    // removes a potion from the stack of potions each time a potions is used
    // also prevents the player from having negative potions
    public void usePotion(){
        if (potions > 0) {
            if (50 - getHp() < 10) {
                this.hp(50 - getHp());
            } else {
                this.hp(10);
            }
            potions--;
            Main.println("Potions left: "+potions);
        } else {
            Main.println("You don't have any potions!");
        }
    }
    


    public void movePlayer(Location location, String dir){
        if(location.dirExists(dir)) {
            if(location.stringToDir(dir)==Location.bossRoom){
                Main.println("You've encountered the dungeon!");
                if(key){
                   this.currentLocation = location.stringToDir(dir);
                }
                else {
                    Main.println("You need the key to unlock the dungeon!");
                }
            }else {
                // TODO: Add enemy encounter logic here
                this.currentLocation = location.stringToDir(dir);
                Main.println("" + this.currentLocation.toString());
                int encounter = new Random().nextInt(5);
                if (currentLocation != location.bossRoom || currentLocation != location.miniBossRoom || currentLocation != location.potionRoom ) {
                    if (encounter == 3) {
                        Enemy goon = new Enemy("Goon", 15, Item.generateAllItems().get(6));
                        Combat combat = new Combat();
                        combat.combatLoop(this, goon);
                    }
                }/* else if (currentLocation == location.roomWeap) {
                    Main.println("You see a " + location.roomWeap.item.name + ". Press (Y) to pick it up!");
                    Item item = new Item();
                    item = item.generateAllItems().get(6);

                } */
            }
        }else{
        Main.println("That direction doesn't exist, you're still in " + location.name + "!");}
    }
}
