public class Location {
    /** Name of location */
    public String name;
    /** special rooms */
    static Location start = new Location("You're at the start. Way above you in the celling you see the hole where you fell through");
    // + you picked up the key
    static Location keyRoom= new Location("You're at the main hall of the Keyhold"); //Keyhold
    static Location bossRoom = new Location("You're at the room of owner of this labyrinth. Prepare yourself"); //Sinister part
    static Location potionRoom = new Location("You're in the supply room. You may find something that may help you here"); //Supply room
    static Location miniBossRoom = new Location("You're at the HQ. And you see a Angry Man. You nw understand the earlier shouting"); //Barracks
    // TODO Pickup
    static Location roomWeap = new Location("You entered the armory!"); //Armoury
    /** normal rooms */
    // TODO ændre A og B (Går kun 1 vej)
            //TODO Kaiyin ret alt!
    static Location roomA = new Location("You're still in the labyrinth. You see nothing to your left or in front you, so your only options to go south or go east"); //Armoury (North-western part of the labyrinth)
    static Location roomB = new Location("You're still in the labyrinth. You see nothing in front of you nor behind, so your only options are to go west or east"); //Armoury (North-western part of the labyrinth)
    static Location roomC = new Location("You're at the sinister part of the labyrinth. Your options are to west or east"); //Sinister part (North-eastern part of the labyrinth)
    static Location roomD = new Location("You're still at the sinister part of the labyrinth. You see a supply room to your south and a corridor, that leads you deeper into the labyrinth, in front of you\" "); //Sinister part (North-easter part of the labyrinth)
    static Location roomE = new Location("You're at the barracks. You see a corridor west of you, a corridor south of you and to your front you see a supply room"); //Barracks (South-western part of the labyrinth)
    static Location roomF = new Location("You're deep within the sinister part of the labyrinth. You see nothing adjacent to you, but see a corridor south and north from where you're standing!"); //Sinister part (North-eastern part of the labyrinth)
    static Location roomG = new Location("You're at the deepest part of the labyrinth. You see a corridor leading away from here, to your west and a giant red glowing gate to your east. And it looks like you need some sort of key to access the room. Else try go back or left\""); //Home town
    static Location roomH = new Location("You're somewhere...? Nothing seems of interest here.. But you do see a corridor to your north and to your west"); //just a corridor
    static Location roomI = new Location("You're at the barracks. Nothing of interests here other than two corridors. One to your east and one to your west");//ordinary corridor
    static Location roomJ = new Location("You're near the barracks HQ. You begin to hear someone shouting. There's a corridor north from here. South from here you see the barracks HQ where the shouting is coming from"); //Barracks (South-western part of the labyrinth)
    static Location roomK = new Location("You're near the barracks HQ. You begin to hear someone shouting. There's a corridor leading away from the barracks west from here. And east from here you see the barracks HQ where the shouting is coming from"); //Barracks (South-western part of the labyrinth)
    static Location roomL = new Location("You're at just another corridor of the Keyhold. You see a corridor to your right and to your left"); //Keyhold (South-western part of the labyrinth)
    static Location roomM = new Location("You're still at the Keyhold. To your left you see key hangers, you might find a key that may come in handy later. And to your right you see a corridor"); //Keyhold (South-western part of the labyrinth)
    static Location roomN = new Location("You're still at the Keyhold. To your south you see key hangers, you might find a key that may come in handy later. And north from here you see a corridor"); //Keyhold (South-western part of the labyrinth)
    static Location roomO = new Location("You're at the Keyhold. You're sweating a little bit, since you can hear goons roaming around. You see two corridors one south and one north from here");
    static Location roomP = new Location("You're at the start of the Keyhold. You get a little bit anxious because you feel something is roaming around. From here you can go north or south"); //Keyhold (South-western part of the labyrinth)
    static Location roomQ = new Location("You're at the Armoury. You see a lot boxes and cargos loaded with sharp blades and fire arms. You may proceed north or south from here"); //Armoury (North-western part of the labyrinth)
    static Location roomR = new Location("You're at the Armoury. You see a lot boxes and cargos loaded with sharp blades and fire arms. North from here you see a room with a table and south from here you see a corridor"); //Armoury (North-western part of the labyrinth)
    static Location roomS = new Location("You're at the Armoury. You see a lot boxes and cargos loaded with sharp blades and fire arms. West from here you see a room with a table and east from here you see a corridor"); //Armoury (North-western part of the labyrinth)
    static Location roomT = new Location("You're at the Armoury. You see a lot boxes and cargos loaded with sharp blades and fire arms. West from here you see a corridor leading deeper into the Armoury and east from here you see a corridor that seems to lead you deeper into the Sinister part of the labyrinth \n"); //Village
    static Location roomU = new Location("You're at the Sinister part of the labyrinth. To your left you see a corridor leading into the Armoury and to right you see a corridor leading deeper into the Sinister part"); //Home town


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