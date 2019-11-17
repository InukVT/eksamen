import java.util.ArrayList;

public class Item {
    /**
     * Items name
     */

    static public ArrayList<Item> weapons = new ArrayList<Item>();
    public ArrayList<Item> potions = new ArrayList<Item>();
    static public ArrayList<Item> generateAllItems() {
        ArrayList<Item> weapons = new ArrayList<Item>();
        weapons.add(new Item("Bare hands", 1, true));
        weapons.add(new Item("Stick",2, true));
        weapons.add(new Item("Plunger", 4, true));
        weapons.add(new Item("Swordfish", 4, true));
        weapons.add(new Item("Flail", 6, true));
        weapons.add(new Item("Enemy Weap", 5, true));
        return weapons;
    }
    Item(){
        weapons = generateAllItems();
    }
    Item(String name, int amount, boolean isWeapon) {
        this.name = name;

        if (isWeapon){
            this.damage = amount;
        }
        else {
            this.heal = amount;
        }

    }




    public String name;

    public int damage;

    public int heal;
}
