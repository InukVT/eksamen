import java.lang.reflect.Array;
import java.util.ArrayList;

public class Location {
    /** Name of location */
    public String name;


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