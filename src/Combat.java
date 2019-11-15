import java.util.Random;

public class Combat {
    // TODO: reference hitrate from weaps from item class
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
    public int hit(Creature receiver, Creature sender) {
       int hitRate = hitRate();
       int defRate = hitRate();
       if (hitRate > defRate) {
           int dmgDealt = sender.equip.damage;
           System.out.println("You've dealt " + dmgDealt + "damage");
           return sender.equip.damage;

       } else if (hitRate == defRate) {
           int dmgDealt = 2/sender.equip.damage;
           System.out.println("You've dealt " + dmgDealt + " damage");
           return dmgDealt;
       } else if (hitRate < defRate) {
           System.out.println("You missed");
           return 0;
       }
    }

    /** The combat loop */
    public void combatLoop(Creature player, Creature enemy){
        Main.println(String.format("You've encountered %s, they have %i health, and you have %i. What are you going to do?", enemy.getName(), enemy.getHp(), player.getHp()));
        while (player.getHp() > 0 && enemy.getHp() > 0){

        }
    }
}