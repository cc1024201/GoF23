package src.com.gof23.c4factorymethod;

import src.com.gof23.c4factorymethod.framework.Factory;
import src.com.gof23.c4factorymethod.framework.Product;
import src.com.gof23.c4factorymethod.idcard.IDCardFactory;

/**
 * @program: GoF23
 * @description: 测试
 * @author: Cc.
 * @create: 2019-04-18 11:57
 **/
public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("小明");
        Product card2 = factory.create("小红");
        Product catd3 = factory.create("小刚");
        card1.use();
        card2.use();
        catd3.use();
    }
}
