package src.com.gof23.c6prototype;

import src.com.gof23.c6prototype.framework.Manager;
import src.com.gof23.c6prototype.framework.Product;
import src.com.gof23.c6prototype.impl.MessageBox;
import src.com.gof23.c6prototype.impl.UnderlinePen;

/**
 * @program: GoF23
 * @description: 测试
 * @author: Cc.
 * @create: 2019-04-18 14:25
 **/
public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        UnderlinePen upen = new UnderlinePen('~');
        MessageBox mbox = new MessageBox('*');
        MessageBox sbox = new MessageBox('/');
        manager.register("strong message", upen);
        manager.register("warning box", mbox);
        manager.register("slash box", sbox);

        Product p1 = manager.create("strong message");
        p1.use("Hello, world.");
        Product p2 = manager.create("warning box");
        p2.use("Hello, world.");
        Product p3 = manager.create("slash box");
        p3.use("Hello, world.");
    }
}
