
/** Game class, this is where the game is run */
public class Main {


    public static void main(String[] args) {
        // Generates all default items
        Item items = new Item();
        Location locations = new Location();

        // TODO: Ask user for name, handle exceptions
        String name = "traveler";
        Player player = new Player(name, items.weapons.get(0));
        println(playerInfoString(player.name));

        gameLoop(player);

        println("Game Over");
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
            if (player.getHp()>0) {
                if (player.currentLocation.key == true) {
                    println("There's a key in the room, pick it up? y/n");
                    player.pickup(Location.keyRoom);
                } else if (player.currentLocation.potions > 0) {
                    println("There's x5 potions, pick it up? y/n");
                    player.pickup(Location.potionRoom);
                }

                Main.println("Your HP is currently " + player.getHp() + ". Press P to use potions (+20 HP)");

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
