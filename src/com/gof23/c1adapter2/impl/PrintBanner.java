package src.com.gof23.c1adapter2.impl;

import src.com.gof23.c1adapter2.Print;

/**
 * @program: GoF23
 * @description: 适配器
 * @author: Cc.
 * @create: 2019-04-18 09:42
 **/
public class PrintBanner extends Print {
    private Banner banner;

    public PrintBanner(String string) {
        this.banner = new Banner(string);
    }

    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
