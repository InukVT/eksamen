import java.util.ArrayList;

public class Item {
    /**
     * Items name
     */
    // Bare hand, Stick, plunger, swordfish & flail
    public ArrayList<Item> weapons = new ArrayList<Item>();
    public void generateAllItems() {
        weapons.add(new Item("Bare hands", 0, 1, true));
        weapons.add(new Item("Stick",0,2, true));
        weapons.add(new Item("Plunger", 0, 4, true));
        weapons.add(new Item("Swordfish", 0, 4, true));
        weapons.add(new Item("Flail", 0, 6, true));
        weapons.add(new Item("potion", 0, 0, false));
        
    }
    Item(){
        generateAllItems();
    }
    Item(String name, int weight, int amount, boolean isWeapon) {
        this.name = name;
        this.weight = weight;

        if (isWeapon){
            this.damage = amount;
        }
        else {
            this.heal = amount;
        }

    }




    public String name;

    public  int weight;

    public int damage;

    public int heal;
}
