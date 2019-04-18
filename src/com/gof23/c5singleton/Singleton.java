package src.com.gof23.c5singleton;

/**
 * @program: GoF23
 * @description: 只生成一个实例
 * @author: Cc.
 * @create: 2019-04-18 13:28
 **/
public class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton() {
        System.out.println("生成了一个实例！");
    }

    public static Singleton getInstance() {
        return singleton;
    }
}
