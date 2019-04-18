package src.com.gof23.c2iterator2;

/**
 * @program: GoF23
 * @description: Iterator接口用于遍历集合中的元素
 * @author: Cc.
 * @create: 2019-04-17 21:55
 **/
public interface Iterator {
    /**
     * @Description: 判断是否存在下一个元素 
     * @Param: [] 
     * @return: boolean 
     * @Author: Cc.
     * @Date: 2019/4/17 
     */
    public abstract boolean hasNext();
    
    /**
     * @Description: 获取下一个元素
     * @Param: [] 
     * @return: java.lang.Object 
     * @Author: Cc.
     * @Date: 2019/4/17 
     */
    public abstract Object next();
}
