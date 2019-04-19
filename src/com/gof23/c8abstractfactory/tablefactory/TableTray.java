package src.com.gof23.c8abstractfactory.tablefactory;

import src.com.gof23.c8abstractfactory.factory.Item;
import src.com.gof23.c8abstractfactory.factory.Tray;

import java.util.Iterator;

/**
 * @program: GoF23
 * @description: 具体的零件类：TableTray类
 * @author: Cc.
 * @create: 2019-04-19 10:14
 **/
public class TableTray extends Tray {
    public TableTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<td>");
        buffer.append("<table width=\"100%\" border=\"1\"><tr>");
        buffer.append("<td bgcolor=\"#cccccc\" align=\"center\" colspan=\"" + tray.size() + "\"><b>" + caption + "</b></td>");
        buffer.append("</tr>\n");
        buffer.append("<tr>\n");
        Iterator it = tray.iterator();
        while(it.hasNext()){
            Item item = (Item) it.next();
            buffer.append(item.makeHTML());
        }
        buffer.append("</tr></table>");
        buffer.append("</td>");
        return buffer.toString();
    }
}
