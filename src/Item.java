import java.util.ArrayList;

public class Item {
    // array list containing viable weapons
    static public ArrayList<Item> weapons = new ArrayList<Item>();
    // inits all items*/
    static public ArrayList<Item> generateAllItems() {
        ArrayList<Item> weapons = new ArrayList<Item>();
        // Player weapons
        weapons.add(new Item("Bare hands", 2, 24));
        weapons.add(new Item("Stick",4, 24));
        weapons.add(new Item("Plunger", 8, 24));
        weapons.add(new Item("Swordfish", 8, 48));
        weapons.add(new Item("Flail", 12, 24));
        weapons.add(new Item("Gun", 999, 1000));
        // Enemy weapons
        weapons.add(new Item("Goon Weap", 3, 16)); //6
        weapons.add(new Item("Angry Weap", 5, 28));//7
        weapons.add(new Item("Very Angry Weap", 6, 32));//8
        weapons.add(new Item("Nurse Weap", 3, 20));//9
        return weapons;
    }
    Item(){
        weapons = generateAllItems();
    }
    // constructor for items and weapons
    Item(String name, int amount, int accuracy) {
        this.name = name;
        this.damage = amount;
        this.accuracy = accuracy;

    }

    public String name; // item damage
    public int damage; // item damage
    public int accuracy; // item accuracy/ hit rate
}
