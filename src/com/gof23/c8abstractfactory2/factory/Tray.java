package src.com.gof23.c8abstractfactory2.factory;

import java.util.ArrayList;

/**
 * @program: GoF23
 * @description: 抽象的零件类：Tray类
 * @author: Cc.
 * @create: 2019-04-18 21:33
 **/
public abstract class Tray extends Item {
    protected ArrayList tray = new ArrayList();

    public Tray(String caption) {
        super(caption);
    }

    public void add(Item item) {
        tray.add(item);
    }
}
