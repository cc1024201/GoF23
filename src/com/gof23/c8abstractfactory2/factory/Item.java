package src.com.gof23.c8abstractfactory2.factory;

/**
 * @program: GoF23
 * @description: 抽象的零件，item类
 * @author: Cc.
 * @create: 2019-04-18 21:28
 **/
public abstract class Item {
    protected String caption;

    public Item(String caption) {
        this.caption = caption;
    }

    public abstract String makeHTML();
}
