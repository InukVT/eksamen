public class Main {

    public static void main(String[] args) {
        // TODO: Ask user for name, handle exceptions
        String name = "John";
        Player player = new Player(name);

        playerInfoString(player.getHp(), player.name);
    }
    private static String playerInfoString(int hp, String name) {
        return String.format("Hello %s, you currently have %i HP", name, hp);
    }
}
