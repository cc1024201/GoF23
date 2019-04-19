package src.com.gof23.c8abstractfactory2.listfactory;

import src.com.gof23.c8abstractfactory2.factory.Item;
import src.com.gof23.c8abstractfactory2.factory.Tray;

import java.util.Iterator;

/**
 * @program: GoF23
 * @description: 具体的零件类：ListTray
 * @author: Cc.
 * @create: 2019-04-19 09:49
 **/
public class ListTray extends Tray {
    public ListTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<li>\n");
        buffer.append(caption + "\n");
        buffer.append("<ul>\n");
        Iterator it = tray.iterator();
        while(it.hasNext()){
            Item item = (Item) it.next();
            buffer.append(item.makeHTML());
        }
        buffer.append("</ul>\n");
        buffer.append("</li>\n");
        return buffer.toString();
    }
}
