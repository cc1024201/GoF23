package src.com.gof23.c8abstractfactory;

import src.com.gof23.c8abstractfactory.factory.Factory;
import src.com.gof23.c8abstractfactory.factory.Link;

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

        Link people = factory.createLink("人民日报", "http://www.people.com.cn/");
        Link gmw = factory.createLink("光明日报", "http://www.gmw.cn");

        Link us_yahoo = factory.createLink("Yahoo", "http://www.yahoo.com/");
        Link jp_yahoo = factory.createLink("Yahoo!Japan", "http://www.yahoo.co.jp/");
        Link excite = factory.createLink()
    }
}
