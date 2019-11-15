
/** Game class, this is where the game is run */
public class Main {


    public static void main(String[] args) {
        Location.start.north = Location.roomA;
        Location.start.west = Location.roomB;
        

        // TODO: Ask user for name, handle exceptions
        String name = "John";
        Player player = new Player(name);

        playerInfoString(player.getHp(), player.name);
    }
    private static String playerInfoString(int hp, String name) {
        return String.format("Hello %s, you currently have %i HP", name, hp);
    }

    /** Convenience function over std out */
    public static void println(String toPrint){
        System.out.println(toPrint);
    }
}
