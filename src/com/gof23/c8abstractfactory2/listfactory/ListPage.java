package src.com.gof23.c8abstractfactory2.listfactory;

import src.com.gof23.c8abstractfactory2.factory.Item;
import src.com.gof23.c8abstractfactory2.factory.Page;

import java.util.Iterator;

/**
 * @program: GoF23
 * @description: 具体的产品：ListPage类
 * @author: Cc.
 * @create: 2019-04-19 09:53
 **/
public class ListPage extends Page {
    public ListPage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHTML() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<html><head><title>" + title + "</title></head>\n");
        buffer.append("<body>\n");
        buffer.append("<h1>" + title + "</h1>\n");
        buffer.append("<ul>\n");
        Iterator it = content.iterator();
        while(it.hasNext()){
            Item item = (Item) it.next();
            buffer.append(item.makeHTML());
        }
        buffer.append("</ul>\n");
        buffer.append("<hr><address>" + author + "</addredd>");
        buffer.append("</body></html>\n");
        return buffer.toString();
    }
}
