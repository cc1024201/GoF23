package src.com.gof23.c17observer2;

import java.util.Random;

/**
 * @program: GoF23
 * @description: 生成随机数的类
 * @author: Cc.
 * @create: 2019-04-20 15:03
 **/
public class RandomNumberGenerator extends NumberGenerator {
    private Random random = new Random();
    private int number;
    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void execute() {
        for(int i=0; i<20; i++){
            number = random.nextInt(50);
            notifyObservers();
        }
    }
}
