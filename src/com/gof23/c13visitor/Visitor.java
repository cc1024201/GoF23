package src.com.gof23.c13visitor;

/**
 * @program: GoF23
 * @description: 表示访问者的抽象类
 * @author: Cc.
 * @create: 2019-04-20 10:17
 **/
public abstract class Visitor {
    public abstract void visit(File file);

    public abstract void visit(Directory directory);
}
