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
    static Location roomA = new Location("room A", "You're now north from the starting point");
    static Location roomB = new Location("room B", "You're not west from the starting point");
    static Location roomC = new Location("room C", "You're now in room C");
    static Location roomD = new Location("room D", "You're now in room D");
    static Location roomE = new Location("room E", "You're now in room E");
    static Location roomF = new Location("room F", "You're now in room F");
    static Location roomG = new Location("room G", "You're now in room G");
    static Location roomH = new Location("room H", "You're now in room H");
    static Location roomI = new Location("room I", "You're now in room I");
    static Location roomJ = new Location("room J", "You're now in room J");

    @Override
    public String toString() {
        String toPrint = this.name;
        /*
        if(west != null){
            // whats westwards
            toPrint = toPrint + west.name;
        }
        if(east != null){
            // whats westwards
            toPrint = toPrint + east.name;
        }
        if(north != null){
            // whats westwards
            toPrint = toPrint + north.name;
        }
        if(south != null){
            // whats westwards
            toPrint = toPrint + west.name;
        }
         */
        return toPrint;
    }

    /** A connecting location */
    public Location north, south, east, west;

    /** Short description of the location for our traveler */
    String description;

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
        this.key = false;
        this.potions = 0;
    }
    // Using ArrayList, so we can potentially have 1000 items in a room, no issue.
    /** An array of all the items in the room */
    public Item item;
    public Boolean key;
    public int potions;
    public Enemy enemy;

    /** Checks to see if there's a room in the given direction */
    public boolean dirExists(String dir){
        if(stringToDir(dir)!=null){
            return true;
        }
        return false;
    }
    public Location stringToDir(String dir){
        switch (dir) {
            case "north":
                return north ;
            case "south":
                return south;
            case "west":
                return west ;
            case "east":
                return east ;
        }
        return this;
    }
    public Location () {
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


        Location.keyRoom.key = true;
        Location.potionRoom.potions = 5;

        Location.bossRoom.enemy = Enemy.VeryAngryMan;
        Location.miniBossRoom.enemy = Enemy.AngryMan;
        Location.potionRoom.enemy = Enemy.Nurse;
    }
}
//