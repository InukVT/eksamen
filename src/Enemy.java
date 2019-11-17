/** Enemy class */
public class Enemy extends Creature {
    public Enemy(String name, int hp) {
        super(name, hp);
    }

    /** special enemies */
    static Enemy AngryMan = new Enemy ("Angry Man", 60); // Mini Boss
    static Enemy Nurse = new Enemy ("Nurse", 50); // Boss for potions
    static Enemy VeryAngryMan = new Enemy("Very Angry Man", 70); //Boss
    /** normal enemies */
    static Enemy Goon = new Enemy("Goon", 15); // Normal enemies


}

