/** Enemy class */
public class Enemy extends Creature {
    public Enemy(String name, int hp) {
        super(name, hp);
    }

    /** special enemies */
    static Enemy AngryMan = new Enemy ("Angry Man", 60); // mini boss
    static Enemy Nurse = new Enemy ("Nurse", 50); // Boss for potions
    /** normal enemies */
    static Enemy Goon = new Enemy("Goon", 15);


}

