package blog.inuk;
import java.util.Random;

public class Combat {
    public int hitRate() {
        int hitRate;
        Random random = new Random();
        hitRate = random.nextInt(20) + 1;
        return hitRate;
    }
}