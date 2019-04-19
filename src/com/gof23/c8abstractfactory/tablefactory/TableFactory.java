package src.com.gof23.c8abstractfactory.tablefactory;

import src.com.gof23.c8abstractfactory.factory.Factory;
import src.com.gof23.c8abstractfactory.factory.Link;
import src.com.gof23.c8abstractfactory.factory.Page;
import src.com.gof23.c8abstractfactory.factory.Tray;

/**
 * @program: GoF23
 * @description: 具体的工厂：TableFactory
 * @author: Cc.
 * @create: 2019-04-19 10:09
 **/
public class TableFactory extends Factory {
    @Override
    public Link createLink(String caption, String url) {
        return new TableLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new TableTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new TablePage(title, author);
    }
}
