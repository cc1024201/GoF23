package src.com.gof23.c8abstractfactory2.factory;

/**
 * @program: GoF23
 * @description: 抽象的零件类：Link类
 * @author: Cc.
 * @create: 2019-04-18 21:32
 **/
public abstract class Link extends Item {
    protected String url;

    public Link(String caption, String url) {
        super(caption);
        this.url = url;
    }
}
