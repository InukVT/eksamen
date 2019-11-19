import java.util.Random;

/*
  Game class, this is where the game is run
 */
public class Main {


    public static void main(String[] args) {
        // Generates all default items
        // randomly spawns of the five viable weapons from the weapons arraylist in the item class
        // below is the constructor for the weapon spawner at the starting point
        int pickAWeap = new Random().nextInt(4);
        Item item = new Item();
        //Item item2 = new Item();
        item = item.generateAllItems().get(pickAWeap);
        //item2 = item.generateAllItems().get(6);
        Location locations = new Location();
        locations.start.item = item;

        // spawns the player at the starting point
        String name = "traveler";
        Player player = new Player(name, item);
        println("You wake up and find that you fallen down into some sort of labyrinth");
        if (locations.start.item != item.generateAllItems().get(0)){
            println("You see a " + locations.start.item.name + ". Press (Y) to pick it up!");
            player.pickup(locations.start);
        }

        //if (player.currentLocation == Location.roomWeap) {
        //    println("You see a " + locations.roomWeap.item.name + ". Press (Y) to pick it up!");
        //    locations.roomWeap.item = item2;
        //}


        gameLoop(player);
        if (player.getHp() > 0 ) {
            println("Game Clear!");
        } else {
            println("Game Over!");
        }
    }

    private static void gameLoop(Player player) {
        Combat combat = new Combat();
        // as long as the players hp is above 0 the game runs
        // if the players hp is is or below 0, the program spits out "game over" and the program stops
        // Very Angry Man is the last boss of the game, and his hp hits 0, it's game clear. The program spits out "game over" and the program stops
        while (player.getHp() > 0 && Enemy.VeryAngryMan.getHp() > 0) {
            // game
            if (player.currentLocation.enemy != null) {
                if (player.currentLocation.enemy.getHp() > 0) {

                    combat.combatLoop(player, player.currentLocation.enemy);
                }
            }
            // Because the while loop doesn't stop exactly when player dies
            if (player.getHp() > 0 && Enemy.VeryAngryMan.getHp() > 0) {
                // the Very Angry Man's room is locked. as long as the key ain't obtained, this room can't be accessed
                // below the pick up function allows the player to pick up the key
                if (player.currentLocation.key == true) {
                    println("There's a key on the key hanger. Want to pick it up? (Y)es or (N)o?");
                    player.pickup(player.currentLocation);
                } else if (player.currentLocation.potions > 0) {
                    // a room called potion room, which contain the mini boss nurse and x5 potions that can be picked up
                    // each potions heals the players hit points up to by 10. and they can't heal above the players max hp
                    println("There's 5 potions in some crate. Want to pick it up? (Y)es or (N)o?");
                    player.pickup(Location.potionRoom);
                }
                player.move();
            }
        }
    }

    // Convinience function, because we stdout all the time.
    public static void println(String toPrint) {
        System.out.println(toPrint);
    }
}
