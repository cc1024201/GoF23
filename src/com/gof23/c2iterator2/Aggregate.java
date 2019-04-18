package src.com.gof23.c2iterator2;

/**
 * @program: GoF23
 * @description: 表示集合的接口
 * @author: Cc.
 * @create: 2019-04-17 21:53
 **/
public interface Aggregate {
    /**
     * @Description: 此方法会生成一个用于遍历集合的迭代器
     * @Param: []
     * @return: java.util.Iterator
     * @Author: Cc.
     * @Date: 2019/4/17
     */
    public abstract Iterator iterator();
}
