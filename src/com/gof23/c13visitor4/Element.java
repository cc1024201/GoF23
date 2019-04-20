package src.com.gof23.c13visitor4;

/**
 * @program: GoF23
 * @description: 接受访问者的访问接口
 * @author: Cc.
 * @create: 2019-04-20 10:18
 **/
public interface Element {
    public abstract void accept(Visitor visitor);
}
