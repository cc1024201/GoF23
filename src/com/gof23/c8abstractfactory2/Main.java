package src.com.gof23.c8abstractfactory2;

import src.com.gof23.c8abstractfactory2.factory.Factory;
import src.com.gof23.c8abstractfactory2.factory.Page;

/**
 * @program: GoF23
 * @description: 测试
 * @author: Cc.
 * @create: 2019-04-18 21:53
 **/
public class Main {
    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("Usage: java Main class.name.of.concreteFactory");
            System.out.println("Example 1: java Main listfactory.ListFactory");
            System.out.println("Example 2: java Main tablefactory TableFactory");
            System.exit(0);
        }
        Factory factory = Factory.getFactory(args[0]);
        Page page = factory.createYahooPage();
        page.output();
    }
}
