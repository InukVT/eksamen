import java.util.Random;

public class Combat {
    // TODO: reference hitrate from weaps from item class
    public int hitRate(Item item) {
        int hitRate;
        Random random = new Random();

        hitRate = random.nextInt(item.accuracy);

        return hitRate;
    }

    /** Returns creature
     * TODO: Make it return damage instead, and when called, call it from {@link Creature}
     * @param receiver the {@link Creature} getting attacked
     * @param sender the {@link Creature} attacking
     * @return
     */
    public void hit(Creature receiver, Creature sender) {
       int hitRate = hitRate(sender.equip);
       // This weapon has a 1/6 change of hitting, therefor this is chosen
       int defRate = hitRate(receiver.equip);
       if (hitRate > defRate) {
           int dmgDealt = sender.equip.damage;
           System.out.println(sender.name + " dealt " + dmgDealt + "damage");
           receiver.damage(dmgDealt);
       } else if (hitRate == defRate) {
           int dmgDealt = 2/sender.equip.damage;
           System.out.println(sender.name + " dealt " + dmgDealt + " damage");
           receiver.damage(dmgDealt);
       } else if (hitRate < defRate) {
           System.out.println(sender.name + " missed");
       }
    }

    /** The combat loop */
    public void combatLoop(Player player,Enemy enemy){
        Main.println(String.format("You've encountered %s, they have %d health, and you have %d. What are you going to do?", enemy.getName(), enemy.getHp(), player.getHp()));
        while (player.getHp() > 0 && enemy.getHp() > 0){
            Main.println("Want to use a potion? press (P) \nPress (A) to attack");
            char ctrl = player.input().charAt(0);
            switch (ctrl) {
                case 'p':
                    player.usePotion();
                    break;
                case 'a':
                    hit(enemy, player);
                    break;
                default:
                    Main.println("I told you to choose an action, and now:");
            }
            hit(player, enemy);

        }
        if(player.getHp()>0) {
            Main.println("You've defeated " + enemy.name);
        }
    }
}