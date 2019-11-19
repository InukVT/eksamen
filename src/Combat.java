import java.util.Random;

public class Combat {
    /** hit rate is a random number between 0 and the weapons maximum hit rate number*/
    public int hitRate(Item item) {

        int hitRate;
        Random random = new Random();

        hitRate = random.nextInt(item.accuracy);

        return hitRate;
    }

    /** Returns creature
     * @param receiver the {@link Creature} getting attacked
     * @param sender the {@link Creature} attacking
     * @return
     */
    /** the program compares hit rate and def rate */
    /** where hit rate is the senders weapons hit rate, and the def rate is the receivers weapons hit rate*/
    /** if the senders hit rate rolls higher than the receivers def rate. The senders weapons damage is subtracted from the receivers hit points*/
    /** if hit rate and def rate are the same, the senders damage still applies, but only half of it*/
    public void hit(Creature receiver, Creature sender) {
       int hitRate = hitRate(sender.equip);
       // This weapon has a 1/6 change of hitting, therefor this is chosen
       int defRate = hitRate(receiver.equip);
       if (hitRate > defRate) {
           int dmgDealt = sender.equip.damage;
           System.out.println(sender.name + " dealt " + dmgDealt + " damage!");
           receiver.damage(dmgDealt);
       } else if (hitRate == defRate) {
           int dmgDealt = 2/sender.equip.damage;
           System.out.println(sender.name + " dealt " + dmgDealt + " damage!");
           receiver.damage(dmgDealt);
       } else if (hitRate < defRate) {
           System.out.println(sender.name + " missed!");
       }
    }

    /** The combat loop */
    /** every combat starts the program goes through the entire loop below, and returns back to start and stops
     * this makes the combat non-automated*/
    public void combatLoop(Player player,Enemy enemy){
        Main.println(String.format("Fuck! You´ve encountered %s.", enemy.name));
       // Main.println(String.format("You've encountered %s, they have %d health, and you have %d. What are you going to do?", enemy.getName(), enemy.getHp(), player.getHp()));
        while (player.getHp() > 0 && enemy.getHp() > 0){
            Main.println("you have " + player.getHp() + " HP! | " + enemy.getName() + " have " + enemy.getHp() + " HP!");
            if(player.potions > 0 ) {
                Main.println("Press (P) to use potions!");
            }
            Main.println("Press (A) to attack!");
            char ctrl = player.input().charAt(0);
            switch (ctrl) {
                case 'p':
                    player.usePotion();
                    break;
                case 'a':
                    hit(enemy, player);
                    break;
                default:
                    Main.println("I told you to choose an action, but now:");
            }
            hit(player, enemy);

        }
        if(player.getHp()>0) {
            Main.println("You've defeated " + enemy.name + "!");
        }
    }
}