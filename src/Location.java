public class Location {
    /** Name of location */
    public String name;
    /** special rooms */
    static Location start = new Location("in the city");
    // + you picked up the key
    static Location keyRoom= new Location("You entered the cave"); //Playground
    static Location bossRoom = new Location("Moms house!"); //Home Town
    static Location potionRoom = new Location(" at the hospital!"); //Hospital
    static Location miniBossRoom = new Location("dads home"); //The other side
    // TODO Pickup
    static Location roomWeap = new Location("You entered the armory!"); //Village
    /** normal rooms */
    // TODO ændre A og B (Går kun 1 vej)
            //TODO Kaiyin ret alt!
    static Location roomA = new Location("(A) on the road. The road splits into two ways, which way you wanna go?"); //Road
    static Location roomB = new Location("(B )on the road. The road splits two ways, which way you wanna go?"); //Road
    static Location roomC = new Location("(C) seeing your hometown in the view!"); //Home town
    static Location roomD = new Location("(D) close the city sign. If you go south you will get to the hospital. If you go north you getting to the town\" "); //Home town
    static Location roomE = new Location("(E) You are on the hospitals parking lot..... "); //Hospital
    static Location roomF = new Location("(F) You are now in your hometown!"); //Home town
    static Location roomG = new Location("(G) If you got the key, go find the kidnappers house on the right. Else try go back or left\""); //Home town
    static Location roomH = new Location("(H)"); //Road
    static Location roomI = new Location("(I)"); //Hospital
    static Location roomJ = new Location("(J)"); //The other side
    static Location roomK = new Location("(K)"); //The other side
    static Location roomL = new Location("(L)"); //Playground
    static Location roomM = new Location("(M) "); //Playground
    static Location roomN = new Location("(N) To the south, you see some sort of cave! Check it out! "); //Playground
    static Location roomO = new Location("(O) You see some kids playing. Go south to check it out!"); //Playground
    // + back
    static Location roomP = new Location("(P) You entered the playground. You can go two ways. Choose one wisely"); //Playground
    static Location roomQ = new Location("(Q) Far far away you see an armory. Go north to check it out, or go back"); //Village
    static Location roomR = new Location("(R) Are you sure u wanna go? If yes, keep going"); //Village
    static Location roomS = new Location("(S)"); //Village
    static Location roomT = new Location("(T)"); //Village
    static Location roomU = new Location("(U)"); //Home town


    @Override
    public String toString() {
        String toPrint = this.name;
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
    /** An array of all the items in the labyrinth */
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

        Location.roomA.south = Location.start;
        Location.roomA.east = Location.roomC;

        Location.roomB.west = Location.roomP;
        Location.roomB.east = Location.start;

        Location.roomC.east = Location.roomD;
        Location.roomC.west = Location.roomA;

        Location.roomD.west = Location.roomC;
        Location.roomD.south = Location.potionRoom;
        Location.roomD.north = Location.roomF;

        Location.roomE.north = Location.potionRoom;
        Location.roomE.west = Location.roomI;
        Location.roomE.south = Location.roomJ;

        Location.roomF.south = Location.roomD;
        Location.roomF.north = Location.roomG;

        Location.roomG.west = Location.roomU;
        Location.roomG.south = Location.roomF;
        Location.roomG.east = Location.bossRoom;

        Location.roomH.north = Location.start;
        Location.roomH.east = Location.roomI;

        Location.roomI.west = Location.roomH;
        Location.roomI.east = Location.roomE;

        Location.roomJ.north = Location.roomE;
        Location.roomJ.south = Location.miniBossRoom;

        Location.roomK.east = Location.miniBossRoom;
        Location.roomK.west = Location.roomL;

        Location.roomL.east = Location.roomK;
        Location.roomL.west = Location.roomM;

        Location.roomM.east = Location.roomL;
        Location.roomM.west = Location.keyRoom;

        Location.roomN.south = Location.keyRoom;
        Location.roomN.north = Location.roomO;

        Location.roomO.south = Location.roomN;
        Location.roomO.north = Location.roomP;

        Location.roomP.south = Location.roomO;
        Location.roomP.east = Location.roomB;
        Location.roomP.north = Location.roomQ;

        Location.roomQ.south = Location.roomP;
        Location.roomQ.north = Location.roomR;

        Location.roomR.south = Location.roomQ;
        Location.roomR.north = Location.roomWeap;

        Location.roomS.west = Location.roomWeap;
        Location.roomS.east = Location.roomT;

        Location.roomT.west = Location.roomS;
        Location.roomT.east = Location.roomU;

        Location.roomU.west = Location.roomT;
        Location.roomU.east = Location.roomG;

        Location.potionRoom.south = Location.roomE;
        Location.potionRoom.north = Location.roomD;

        Location.miniBossRoom.west = Location.roomK;
        Location.miniBossRoom.north = Location.roomJ;

        Location.keyRoom.east = Location.roomM;
        Location.keyRoom.north = Location.roomN;

        Location.roomWeap.south = Location.roomR;
        Location.roomWeap.east = Location.roomS;

        Location.bossRoom.east = Location.roomG;

        Location.keyRoom.key = true;
        Location.potionRoom.potions = 5;
        Location.roomWeap.item = Item.generateAllItems().get(6);

        Location.bossRoom.enemy = Enemy.VeryAngryMan;
        Location.miniBossRoom.enemy = Enemy.AngryMan;
        Location.potionRoom.enemy = Enemy.Nurse;

    }
}
//