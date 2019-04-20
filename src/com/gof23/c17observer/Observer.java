package src.com.gof23.c17observer;

/**
 * @program: GoF23
 * @description: 表示观察者的接口
 * @author: Cc.
 * @create: 2019-04-20 14:57
 **/
public interface Observer {
    public abstract void update(NumberGenerator generator);
}
