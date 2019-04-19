package src.com.gof23.c8abstractfactory.tablefactory;

import src.com.gof23.c8abstractfactory.factory.Item;
import src.com.gof23.c8abstractfactory.factory.Page;

import java.util.Iterator;

/**
 * @program: GoF23
 * @description: 具体的产品：TablePage类
 * @author: Cc.
 * @create: 2019-04-19 10:20
 **/
public class TablePage extends Page {
    public TablePage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHTML() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<html><head><title>" + title + "</title></head>\n");
        buffer.append("<body>\n");
        buffer.append("<h1>" + title + "</h1>\n");
        buffer.append("<table width=\"80@\" border=\"2\">\n");
        Iterator it = content.iterator();
        while(it.hasNext()){
            Item item = (Item) it.next();
            buffer.append("<tr>" + item.makeHTML() + "</tr>");
        }
        buffer.append("</table>\n");
        buffer.append("<hr><address>" + author + "</addredd>");
        buffer.append("</body></html>\n");
        return buffer.toString();
    }
}
