import java.util.Random;

/** Game class, this is where the game is run */
public class Main {


    public static void main(String[] args) {
        // Generates all default items

        int pickAWeap = new Random().nextInt(4);
        Item item = new Item();
        item = item.generateAllItems().get(pickAWeap);
        Location locations = new Location();
        locations.start.item = item;


        String name = "traveler";
        Player player = new Player(name, item);
        println("Hello Traveler");

        println("You see a " + locations.start.item.name + ". Press (Y) to pick it up!");
        player.pickup(locations.start);

        gameLoop(player);

        println("Game Over!");
    }

    private static void gameLoop(Player player){
        Combat combat = new Combat();
        while (player.getHp() > 0 && Enemy.VeryAngryMan.getHp() > 0){
            // game
            if(player.currentLocation.enemy != null){
                if (player.currentLocation.enemy.getHp() > 0){

                    combat.combatLoop(player, player.currentLocation.enemy);
                }
            }
            // Because the while loop doesn't stop exactly when player dies
            if (player.getHp()>0&&Enemy.VeryAngryMan.getHp() > 0) {
                if (player.currentLocation.key == true) {
                    println("There's a key on the ground. Want to pick it up? (Y)es or (N)o?");
                    player.pickup(Location.keyRoom);
                } else if (player.currentLocation.potions > 0) {
                    println("There's 5 potions on the ground. Want to pick it up? (Y)es or (N)o?");
                    player.pickup(Location.potionRoom);
                }
<<<<<<< HEAD
                if (player.potions > 0 && player.getHp() < 50) {
                    Main.println("Your HP is currently " + player.getHp() + "! Press (P) to use potions (+20 HP)!");
                }
                if (player.currentLocation.north != null) {
                    println("Press (N) to move north!");
                }
                if (player.currentLocation.south != null) {
                    println("Press (S) to move south!");
                }
                if (player.currentLocation.east != null) {
                    println("Press (E) to move east!");

                }if (player.currentLocation.west != null) {
                    println("Press (W) to move west!");
                }
=======
>>>>>>> 9d99d0e327bf7db86b1f7ed428dd80383d63711c
                    player.move();
            }
        }
    }

    public static void println(String toPrint){
        System.out.println(toPrint);
    }
}
