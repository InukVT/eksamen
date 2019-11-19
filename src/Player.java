import java.util.Scanner;
import java.util.Random;
//* The player class
public class Player extends Creature {
    // What the player carries
    public int potions = 0;
    private Boolean key = false;
    // Where is the player?
    public Location currentLocation;

    // Create a new player
    // Create a new player
    // @param name Required for toString
    public Player(String name, Item item){
        super(name, 50, item);
        this.currentLocation = Location.start;
    }

    // Small function to take the item from location into players inventory
    public void pickup (Location location){
        char ctrl = input().charAt(0);
        // Switch statements are better maintainable than if blocks, for this kind of iterations.
        switch (ctrl){
            case 'y':
                // This could easily be a switch statement instead, we know the key is only true in the keyroom,
                // but to show that we know about if else statements, we used if
                // We move the item to the plater, to change players item value to the item and then the locations
                // item value to null / zero.
                if(location.key == true){
                    key = true;
                    location.key = false;
                    Main.println("You picked up the key!");
                } else if (location == location.potionRoom) {
                    potions = location.potions;
                    location.potions = 0;
                    Main.println("You picked up the potions!");
                } else if (location == location.start) {
                    Main.println("You picked up the weapon! \nChose a way you wanna go:");
                    if(equip == equip.weapons.get(0)){
                        equip = location.item;
                    }
                    location.item = null;
                } else if (location == location.roomWeap) {
                    Main.println("You picked up the " + location.item.name);
                    equip = location.item;
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

    // Because we use this twice, this is how we do it
    public String input(){
        Scanner scanner = new Scanner(System.in);
        // Stores the scanned string as all lowercase, to be case incensitive
        return scanner.next().toLowerCase();
    }
    // Asks the player where to move, and moves the player accordingly
    public void move() {
        if (potions > 0 && getHp() < 50) {
            Main.println("Your HP is currently " + getHp() + ". Press (P) to use potions (+10 HP)");
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

    // Move the player in the direction assigned
    public void movePlayer(Location location, String dir){
        if(location.dirExists(dir)) {
            if(location.stringToDir(dir)==Location.bossRoom){
                if(key){
                   this.currentLocation = location.stringToDir(dir);
                } else {
                    Main.println("You need some sort of key to gain access here");
                }
            } else {
                this.currentLocation = location.stringToDir(dir);
                Main.println("" + this.currentLocation.toString());
                int encounter = new Random().nextInt(5);
                if (currentLocation != location.bossRoom && currentLocation != location.miniBossRoom && currentLocation != location.potionRoom ) {
                    if (encounter == 3) {
                        Enemy goon = new Enemy("Goon", 15, Item.generateAllItems().get(6));
                        Combat combat = new Combat();
                        combat.combatLoop(this, goon);
                    }
                }
                if (currentLocation.item != null){
                    Main.println("You see a " + currentLocation.item.name + ". Press (Y) to pick it up!");
                    pickup(currentLocation);
                }
            }
        } else {
        Main.println("That direction doesn't exist, you're still in " + location.description + "!");}
    }
}
