import java.util.Random;

public class Combat {
    // TODO: reference hitrate from weaps from item class
    public int hitRate() {
        int hitRate;
        Random random = new Random();
        hitRate = random.nextInt(20) + 1;
        return hitRate;
    }

    /** Returns the amount of damage, attacker is giving
     * @param sender the {@link Creature} attacking
     * @return the amount of damage dealt by sender
     */
    public int hit(Creature sender) {
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
        return 0;
    }

    /** The combat loop */
    public void combatLoop(Creature player, Creature enemy){
        Main.println(String.format("You've encountered %s, they have %i health, and you have %i. What are you going to do?", enemy.getName(), enemy.getHp(), player.getHp()));
        while (player.getHp() > 0 && enemy.getHp() > 0){
            Main.println("Choose your attack!");
            // TODO: Add choice of action
            player.damage(hit(enemy));
            enemy.damage(hit(player));
        }
    }
}