/** Enemy class */
public class Enemy extends Creature {
    public Enemy(String name, int hp, Item equip) {
        super(name, hp, equip);
    }


    /** special enemies */
    // item.generateALLItems fetches the item in the 6th row on the weapon arraylist in the item class
    static Enemy AngryMan = new Enemy ("Angry Man", 60, Item.generateAllItems().get(5)); // Mini Boss
    static Enemy Nurse = new Enemy ("Nurse", 50, Item.generateAllItems().get(5)); // Boss for potions
    static Enemy VeryAngryMan = new Enemy("Very Angry Man", 150, Item.generateAllItems().get(5)); //Boss
}

