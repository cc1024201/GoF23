package src.com.gof23.templatemethod.impl;

import src.com.gof23.templatemethod.AbstractDisplay;

/**
 * @program: GoF23
 * @description: 测试
 * @author: Cc.
 * @create: 2019-04-18 10:55
 **/
public class Main {
    public static void main(String[] args) {
        AbstractDisplay d1 = new CharDisplay('H');
        AbstractDisplay d2 = new StringDisplay("Hello, world.");
        AbstractDisplay d3 = new StringDisplay("你好，世界！");
        d1.display();
        d2.display();
        d3.display();
    }
}
