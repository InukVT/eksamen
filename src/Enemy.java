// Enemy class
public class Enemy extends Creature {
    public Enemy(String name, int hp, Item equip) {
        super(name, hp, equip);
    }

    // Special enemies
    // Each enemy is an instance.
    static Enemy AngryMan = new Enemy ("Angry Man", 60, Item.generateAllItems().get(7)); // Mini Boss
    static Enemy Nurse = new Enemy ("Nurse", 50, Item.generateAllItems().get(9)); // Boss for potions
    static Enemy VeryAngryMan = new Enemy("Very Angry Man", 150, Item.generateAllItems().get(8)); //Boss
}

