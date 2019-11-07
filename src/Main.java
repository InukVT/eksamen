public class Main {
    static Location start = new Location("Start", "You're at a new place, you don't know what happened");
    static Location northToStart = new Location("North to South", "You moved north");
    static Location keyRoom = new Location("Key Room", "Congrats, you found the master key");
    static Location bossRoom = new Location("Boss Room", "Use the key to fight the big ol' boss");

    public static void main(String[] args) {
        start.north = northToStart;
        // TODO: Ask user for name, handle exceptions
        String name = "John";
        Player player = new Player(name);

        playerInfoString(player.getHp(), player.name);
    }
    private static String playerInfoString(int hp, String name) {
        return String.format("Hello %s, you currently have %i HP", name, hp);
    }
}
