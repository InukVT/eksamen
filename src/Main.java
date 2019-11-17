
/** Game class, this is where the game is run */
public class Main {


    public static void main(String[] args) {
        // Generates all default items
        Item items = new Item();


        // TODO: Ask user for name, handle exceptions
        String name = "John";
        Player player = new Player(name);

        println(playerInfoString(player.getHp(), player.name));

        gameLoop(player);

        println("Game Over");
    }

    private static void gameLoop(Creature player){
        while (player.getHp() > 0 && Enemy.VeryAngryMan.getHp() > 0){
            // game
        }
    }

    private static String playerInfoString(int hp, String name) {
        return String.format("Hello %s, you currently have %d HP", name, hp);
    }

    /** Convenience function over std out */
    public static void println(String toPrint){
        System.out.println(toPrint);
    }
}
