package src.com.gof23.c9bridge4;

/**
 * @program: GoF23
 * @description: 测试
 * @author: Cc.
 * @create: 2019-04-19 11:38
 **/
public class Main {
    public static void main(String[] args) {
        IncreaseDisplay d1 = new IncreaseDisplay(new CharDisplayImpl('<', '*', '>'), 1);
        IncreaseDisplay d2 = new IncreaseDisplay(new CharDisplayImpl('|', '#', '-'), 2);
        d1.increaseDisplay(4);
        d2.increaseDisplay(6);
    }
}
