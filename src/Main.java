import java.util.Random;

/** Game class, this is where the game is run */
public class Main {


    public static void main(String[] args) {
        // Generates all default items
        /** randomly spawns of the five viable weapons from the weapons arraylist in the item class*/
        // below is the constructor for the weapon spawner at the starting point
        int pickAWeap = new Random().nextInt(4);
        Item item = new Item();
        item = item.generateAllItems().get(pickAWeap);
        Location locations = new Location();
        locations.start.item = item;

        // spawns the player at the starting point
        String name = "traveler";
        Player player = new Player(name, item);
        println(playerInfoString(player.name));
        // pick up function to pick up items by hitting the y key
        println("You see a " + locations.start.item.name + ". press (Y) to pick it up!");
        player.pickup(locations.start);

        gameLoop(player);

        println("Game Over");
    }

    private static void gameLoop(Player player){
        Combat combat = new Combat();
        // as long as the players hp is above 0 the game runs
        // if the players hp is is or below 0, the program spits out "game over" and the program stops
        // Very Angry Man is the last boss of the game, and his hp hits 0, it's game clear. The program spits out "game over" and the program stops
        while (player.getHp() > 0 && Enemy.VeryAngryMan.getHp() > 0){
            // game
            if(player.currentLocation.enemy != null){
                if (player.currentLocation.enemy.getHp() > 0){

                    combat.combatLoop(player, player.currentLocation.enemy);
                }
            }
            // Because the while loop doesn't stop exactly when player dies
            if (player.getHp()>0&&Enemy.VeryAngryMan.getHp() > 0) {
                // the Very Angry Man's room is locked. as long as the key ain't obtained, this room can't be accessed
                // below the pick up function allows the player to pick up the key
                if (player.currentLocation.key == true) {
                    println("There's a key on the ground. Want to pick it up? (Y)es or (N)o?");
                    player.pickup(Location.keyRoom);
                } else if (player.currentLocation.potions > 0) {
                    // a room called potion room, which contain the mini boss nurse and x5 potions that can be picked up
                    // each potions heals the players hit points up to 20. and they can't heal above the players max hp
                    println("There's 5 potions on the ground. Want to pick it up? (Y)es or (N)o?");
                    player.pickup(Location.potionRoom);
                }
                if (player.potions > 0 && player.getHp() < 50) {
                    Main.println("Your HP is currently " + player.getHp() + ". Press (P) to use potions (+20 HP)");
                }
                // functions that assigns the keys NSEW to be used to move around in the game
                if (player.currentLocation.north != null) {
                    println("Press (N) to move north");
                }
                if (player.currentLocation.south != null) {
                    println("Press (S) to move south");
                }
                if (player.currentLocation.east != null) {
                    println("Press (E) to move east");

                }if (player.currentLocation.west != null) {
                    println("Press (W) to move west");
                }
                    player.move();
            }
        }
    }

    private static String playerInfoString( String name) {
        return String.format("Hello %s.", name );
    }

    /** Convenience function over std out */
    public static void println(String toPrint){
        System.out.println(toPrint);
    }
}
