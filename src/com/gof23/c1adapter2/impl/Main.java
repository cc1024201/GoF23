package src.com.gof23.c1adapter2.impl;

import src.com.gof23.c1adapter.Print;
import src.com.gof23.c1adapter.impl.PrintBanner;

/**
 * @program: GoF23
 * @description: 测试
 * @author: Cc.
 * @create: 2019-04-18 09:32
 **/
public class Main {
    public static void main(String[] args) {
        Print p = new PrintBanner("Hello");
        p.printWeak();
        p.printStrong();
    }
}
