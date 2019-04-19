package src.com.gof23.c8abstractfactory.listfactory;

import src.com.gof23.c8abstractfactory.factory.Factory;
import src.com.gof23.c8abstractfactory.factory.Link;
import src.com.gof23.c8abstractfactory.factory.Page;
import src.com.gof23.c8abstractfactory.factory.Tray;

/**
 * @program: GoF23
 * @description: 具体的工厂：ListFactory类
 * @author: Cc.
 * @create: 2019-04-19 09:35
 **/
public class ListFactory extends Factory {
    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new ListPage(title, author);
    }
}
