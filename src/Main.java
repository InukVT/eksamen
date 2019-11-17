
/** Game class, this is where the game is run */
public class Main {


    public static void main(String[] args) {
        // Generates all default items
        Item items = new Item();

        Location.start.north = Location.roomA;
        Location.start.west = Location.roomB;
        Location.start.south = Location.roomH;

        Location.roomB.west = Location.keyRoom;
        Location.roomB.east = Location.start;
        Location.keyRoom.east = Location.roomB;

        Location.roomA.south = Location.start;
        Location.roomA.east = Location.roomC;

        Location.roomC.east = Location.roomD;
        Location.roomC.west = Location.roomA;

        Location.roomD.west = Location.roomC;
        Location.roomD.south = Location.roomE;
        Location.roomD.north = Location.roomF;

        Location.roomE.north = Location.roomD;

        Location.roomF.south = Location.roomD;
        Location.roomF.north = Location.roomG;

        Location.roomG.south = Location.roomF;
        Location.roomG.east = Location.bossRoom;

        Location.bossRoom.west = Location.roomG;

        Location.roomH.north = Location.start;
        Location.roomH.east = Location.roomI;

        Location.roomI.west = Location.roomH;
        Location.roomI.south = Location.roomJ;

        Location.roomJ.north = Location.roomI;
        Location.roomJ.east = Location.potionRoom;

        Location.potionRoom.west = Location.roomJ;
        Location.potionRoom.south = Location.miniBossRoom;

        Location.miniBossRoom.north = Location.potionRoom;

        // TODO: Ask user for name, handle exceptions
        String name = "John";
        Player player = new Player(name);

        println(playerInfoString(player.getHp(), player.name));

        while (player.getHp() > 0 && Enemy.VeryAngryMan.getHp() > 0){
            // game
        }
        println("Game Over");
    }

    private static String playerInfoString(int hp, String name) {
        return String.format("Hello %s, you currently have %d HP", name, hp);
    }

    /** Convenience function over std out */
    public static void println(String toPrint){
        System.out.println(toPrint);
    }
}
