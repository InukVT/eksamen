import java.util.ArrayList;

public class Item {
    /**
     * Items name
     */
    // Bare hand, Stick, plunger, swordfish & flail
    public ArrayList<Item> weapons = new ArrayList<Item>();
    public void generateAllItems() {
        weapons.add(new Item("Bare hands", 0, 1));
        weapons.add(new Item("Stick",0,2));
        weapons.add(new Item("Plunger", 0, 4));
        weapons.add(new Item("Swordfish", 0, 4));
        weapons.add(new Item("Flail", 0, 6));
    }
    Item(){
        generateAllItems();
    }
    Item(String name, int weight, int damage) {
        this.name = name;
        this.weight = weight;
        this.damage = damage;
    }




    public String name;

    public  int weight;

    public int damage;
}
