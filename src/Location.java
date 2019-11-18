import java.util.ArrayList;
import java.util.Random;
public class Location {
    /** Name of location */
    public String name;
    /** special rooms */
    static Location start = new Location("the city");
    static Location keyRoom = new Location("the cave");
    static Location bossRoom = new Location("the dungeon");
    static Location potionRoom = new Location("the hospital");
    static Location miniBossRoom = new Location("the toilet");
    /** normal rooms */
    static Location roomA = new Location("woods A");
    static Location roomB = new Location("woods B");
    static Location roomC = new Location("woods C");
    static Location roomD = new Location("woods D");
    static Location roomE = new Location("woods E");
    static Location roomF = new Location("woods F");
    static Location roomG = new Location("woods G");
    static Location roomH = new Location("woods H");
    static Location roomI = new Location("woods I");
    static Location roomJ = new Location("woods J");

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

    public Location(String name) {
        this.name = name;
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