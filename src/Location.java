import java.util.ArrayList;

public class Location {
    /** Name of location */
    public String name;
    /** special rooms */
    static Location start = new Location("Start", "You're at a new place, you don't know what happened");
    static Location keyRoom = new Location("Key Room", "Congrats, you found the master key");
    static Location bossRoom = new Location("Boss Room", "You see a dragon behind iron bars, seem you need som sort key to gain access");
    static Location potionRoom = new Location("East from roomJ", "You've found x5 healing potions");
    static Location miniBossRoom = new Location("South from potionRoom", "You've encountered Angry Man");
    /** normal rooms */
    static Location roomA = new Location("North from StartingPoint", "You're now north from the starting point");
    static Location roomB = new Location("West from StartingPoint", "You're not west from the starting point");
    static Location roomC = new Location("East from roomA", "You're now in room C");
    static Location roomD = new Location("East from roomC", "You're now in room D");
    static Location roomE = new Location("South from roomD", "You're now in room E");
    static Location roomF = new Location("North from roomD", "You're now in room F");
    static Location roomG = new Location("North from roomF", "You're now in room G");
    static Location roomH = new Location("South from StartingPoint", "You're now in room H");
    static Location roomI = new Location("East from roomH", "You're now in room I");
    static Location roomJ = new Location("South from roomI", "You're now in room J");

    @Override
    public String toString() {
        String toPrint = "";
        if(west != null){
            // whats westwards
            toPrint = toPrint + "westwards of here is " + west.name;
        }
        if(east != null){
            // whats westwards
            toPrint = toPrint + "eastwards of here is " + east.name;
        }
        if(north != null){
            // whats westwards
            toPrint = toPrint + "westwards of here is " + north.name;
        }
        if(south != null){
            // whats westwards
            toPrint = toPrint + "westwards of here is " + west.name;
        }
        return toPrint;
    }

    /** A connecting location */
    public Location north, south, east, west;

    /** Short description of the location for our traveler */
    String description;

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
    }
    // Using ArrayList, so we can potentially have 1000 items in a room, no issue.
    /** An array of all the items in the room */
    public ArrayList<Item> items;
}
//