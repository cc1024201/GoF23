package src.com.gof23.c1adapter.impl;

/**
 * @program: GoF23
 * @description: 比喻：交流100伏特
 * @author: Cc.
 * @create: 2019-04-18 09:21
 **/
public class Banner {
    private String string;

    public Banner(String string) {
        this.string = string;
    }

    public void showWithParen() {
        System.out.println("(" + string + ")");
    }

    public void showWithAster() {
        System.out.println("*" + string + "*");
    }
}
