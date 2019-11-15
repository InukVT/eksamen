import java.util.ArrayList;

public class Item {
    /**
     * Items name
     */
    // Bare hand, Stick, plunger, swordfish & flail
    public ArrayList<item> weapons = new ArrayList<item>();
public void generateAllItems() {
    weapons.add("Bare hands");
    weapons.add("Stick");
    weapons.add("Plunger");
    weapons.add("Swordfish");
    weapons.add("Flail");
}





    public String name;

    public  int weight;

    public int damage;
}
