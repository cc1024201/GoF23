package src.com.gof23.c23interpreter2.language;


/**
 * @program: GoF23
 * @description: 表示语法树节点的类
 * @author: Cc.
 * @create: 2019-04-21 13:39
 **/
public abstract class Node implements Executor{
    public abstract void parse(Context context) throws ParseException;
}
