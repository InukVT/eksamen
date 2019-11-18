import java.util.Scanner;
import java.util.Random;

public class Player extends Creature {
    public int potions = 0;
    private Boolean key = false;

    public Location currentLocation;

    public Player(String name, Item item){
        super(name, 50, item);
        this.currentLocation = Location.start;

    }

    @Override
    public String toString() {
        return name;
    }

    public void pickup (Location location){
        char ctrl = input().charAt(0);
        switch (ctrl){
            case 'y':
                if(location == Location.keyRoom){
                    key = true;
                    location.key = false;
                    Main.println("You picked up the key");
                } else if (location == location.potionRoom) {
                    potions = location.potions;
                    location.potions = 0;
                    Main.println("You picked up the potions!");
                } else if (location == location.start) {
                    if(equip == equip.weapons.get(0)){
                        equip = location.item;
                    }
                    location.item = null;
                }
                break;
            case 'n':
                Main.println("You let the key be");
                break;
            default:
                Main.println("Illegal move");
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
                    usePotion();
                    break;
                default:
                    Main.println("Illegal move");
            }
        }
    }

    public void usePotion(){
        if (potions > 0) {
            if (50 - getHp() < 20) {
                this.hp(50 - getHp());
            } else {
                this.hp(20);
            }
           potions--;
            Main.println("Potions left: "+potions);
        } else {
            Main.println("You don't have any potions");
        }
    }

    public void movePlayer(Location location, String dir){
        if(location.dirExists(dir)) {
            if(location.stringToDir(dir)==Location.bossRoom){
                Main.println("You've encountered the boss room");
                if(key){
                   this.currentLocation = location.stringToDir(dir);
                }
                else {
                    Main.println("You need the key to unlock the dungeon");
                }
            }else {
                this.currentLocation = location.stringToDir(dir);
                Main.println("You are now in " + this.currentLocation.toString());
                int encounter = new Random().nextInt(5);
                if (currentLocation != location.bossRoom || currentLocation != location.miniBossRoom || currentLocation != location.potionRoom) {
                    if (encounter == 3) {
                        Enemy goon = new Enemy("Goon", 15, Item.generateAllItems().get(5));
                        Combat combat = new Combat();
                        combat.combatLoop(this, goon);
                    }
                }
            }
        }else{
        Main.println("That direction doesn't exist, you're still in " + location.name);}
    }
}
