package src.com.gof23.c8abstractfactory.tablefactory;

import src.com.gof23.c8abstractfactory.factory.Link;

/**
 * @program: GoF23
 * @description: 具体的零件：TableLink类
 * @author: Cc.
 * @create: 2019-04-19 10:11
 **/
public class TableLink extends Link {
    public TableLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    public String makeHTML() {
        return "<td><a href=\"" + url + "\">" + caption + "</a></td>\n";
    }
}
