package src.com.gof23.c10strategy2;

import java.util.Random;

/**
 * @program: GoF23
 * @description: 随机出手势
 * @author: Cc.
 * @create: 2019-04-19 15:20
 **/
public class RandomStrategy implements Strategy{
    private Random random;
    public RandomStrategy(int seed){
        random = new Random(seed);
    }
    @Override
    public Hand nextHand() {
        return Hand.getHand(random.nextInt(3));
    }

    @Override
    public void study(boolean win) {

    }
}
