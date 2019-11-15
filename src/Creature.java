/** Generic creatures class */
public class Creature {
    /** Equipped weapon for use in combat */
    public Item equip;

    /** Creatures HP */
    private int hp;

    /** Creatures defense */
    private int defence;

    public Creature(int hp, int defence){
        this.hp = hp;
        this.defence = defence;
    }

    /** @return {@link #hp}*/
    public int getHp() {
        return hp;
    }

    public int getDefence() {
        return defence;
    }

    /** Damage player
     *  @param amount the amount of health point to remove from the player*/
    public void damage(int amount){
        this.hp -= amount;
    }
}
