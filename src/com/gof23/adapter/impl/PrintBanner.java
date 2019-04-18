package src.com.gof23.adapter.impl;

import src.com.gof23.adapter.Print;

/**
 * @program: GoF23
 * @description: 适配器角色
 * @author: Cc.
 * @create: 2019-04-18 09:30
 **/
public class PrintBanner extends Banner implements Print {
    public PrintBanner(String string) {
        super(string);
    }

    @Override
    public void printWeak() {
        showWithParen();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}
