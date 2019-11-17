/** Enemy class */
public class Enemy extends Creature {
    public Enemy(String name, int hp) {
        super(name, hp);
    }

    /** special enemies */
    static Enemy AngryMan = new Enemy ("Angry Man", 60); // mini boss
    static Enemy Nurse = new Enemy ("Nurse", 50); // potion boss
    /** normal enemies */
    static Enemy Goon = new Enemy("Goon", 15); // enemy that has a chance to spawn upon entering a new room


}

