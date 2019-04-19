package src.com.gof23.c10strategy2;

import java.util.Random;

/**
 * @program: GoF23
 * @description: 表示“如果这局猜拳获胜，那么下一局也出一样的手势”这一策略类
 * @author: Cc.
 * @create: 2019-04-19 14:22
 **/
public class WinningStrategy implements Strategy {
    private Random random;
    private boolean won = false;
    private Hand prevHand;
    public WinningStrategy(int seed){
        random = new Random(seed);
    }
    @Override
    public Hand nextHand() {
        if(!won){
            prevHand = Hand.getHand(random.nextInt(3));
        }
        return prevHand;
    }

    @Override
    public void study(boolean win) {
        won = win;
    }
}
