package src.com.gof23.c8abstractfactory.listfactory;

import src.com.gof23.c8abstractfactory.factory.Link;

/**
 * @program: GoF23
 * @description: 具体的零件：ListLink类
 * @author: Cc.
 * @create: 2019-04-19 09:42
 **/
public class ListLink extends Link {
    public ListLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    public String makeHTML() {
        return "<li><a href=\"" + url + "\">" + caption + "</a></li>\n";
    }
}
