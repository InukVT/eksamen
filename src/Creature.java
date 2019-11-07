public class Creature {
    /** Players health */
    private int hp;

    public Creature(int hp){
        this.hp = hp;
    }

    /** @return {@link #hp}*/
    public int getHp() {
        return hp;
    }

    /** Damage player
     *  @param amount the amount of health point to remove from the player*/
    public void damage(int amount){
        this.hp -= amount;
    }
}
