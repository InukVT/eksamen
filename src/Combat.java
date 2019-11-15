import java.util.Random;

public class Combat {
    public int hitRate() {
        int hitRate;
        Random random = new Random();
        hitRate = random.nextInt(20) + 1;
        return hitRate;

    }

    /** Returns creature
     * TODO: Make it return damage instead, and when called, call it from {@link Creature}
     * @param receiver the {@link Creature} getting attacked
     * @param sender the {@link Creature} attacking
     * @return
     */
    public Creature hit(Creature receiver, Creature sender) {
        int defRate = hitRate();
        int hitRate = hitRate();
        if (hitRate > defRate) {
            receiver.damage( sender.equip.damage);
        } else if (hitRate == defRate) {
            receiver.damage(2/sender.equip.damage);
        }
        return receiver;
    }


    /** The combat loop */
    public void combatLoop(Creature player, Creature enemy){
        Main.println(String.format("You've encountered %s, they have %i health, and you have %i. What are you going to do?", enemy.getName(), enemy.getHp(), player.getHp()));
        while (player.getHp() > 0 && enemy.getHp() > 0){

        }
    }
}