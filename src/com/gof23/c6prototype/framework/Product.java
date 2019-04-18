package src.com.gof23.c6prototype.framework;

/**
 * @program: GoF23
 * @description: 复制功能的接口
 * @author: Cc.
 * @create: 2019-04-18 14:06
 **/
public interface Product extends Cloneable {
    public abstract void use(String s);

    public abstract Product createClone();
}
