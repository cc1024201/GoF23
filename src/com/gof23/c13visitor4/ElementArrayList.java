package src.com.gof23.c13visitor4;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @program: GoF23
 * @description: 使Directory和File可以被add至ElementArrayList中
 * @author: Cc.
 * @create: 2019-04-20 11:19
 **/
public class ElementArrayList extends ArrayList implements Element {

    @Override
    public void accept(Visitor visitor) {
        Iterator it = iterator();
        while(it.hasNext()){
            Element e = (Element) it.next();
            e.accept(visitor);
        }
    }
}
