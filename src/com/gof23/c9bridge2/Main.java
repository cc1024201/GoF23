package src.com.gof23.c9bridge2;

/**
 * @program: GoF23
 * @description: 测试
 * @author: Cc.
 * @create: 2019-04-19 11:38
 **/
public class Main {
    public static void main(String[] args) {
        RandomCountDisplay d = new RandomCountDisplay(new StringDisplayImpl("Hello, China."));
        d.randomDisplay(10);
    }
}
