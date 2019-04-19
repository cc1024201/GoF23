package src.com.gof23.c9bridge2;

import java.util.Random;

/**
 * @program: GoF23
 * @description: 增加类的功能层次RandomCountDisplay
 * @author: Cc.
 * @create: 2019-04-19 11:58
 **/
public class RandomCountDisplay extends CountDisplay {
    private Random random = new Random();
    public RandomCountDisplay(DisplayImpl impl) {
        super(impl);
    }
    public void randomDisplay(int times){
        multiDisplay(random.nextInt(times));
    }
}
