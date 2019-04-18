package src.com.gof23.c7builder;

/**
 * @program: GoF23
 * @description: 编写文档的方法的抽象类
 * @author: Cc.
 * @create: 2019-04-18 15:49
 **/
public abstract class Builder {
    public abstract void makeTitle(String title);

    public abstract void makeString(String str);

    public abstract void makeItems(String[] items);

    public abstract void close();
}
