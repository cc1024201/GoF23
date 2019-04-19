package src.com.gof23.c9bridge3;

/**
 * @program: GoF23
 * @description: 测试
 * @author: Cc.
 * @create: 2019-04-19 11:38
 **/
public class Main {
    public static void main(String[] args) {
        CountDisplay d = new CountDisplay(new FileDisplayImpl("star.txt"));
        d.multiDisplay(3);
    }
}
