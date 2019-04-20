package src.com.gof23.c12decorator2;

/**
 * @program: GoF23
 * @description: 装饰边框的抽象类
 * @author: Cc.
 * @create: 2019-04-20 09:10
 **/
public abstract class Border extends Display {
    protected Display display;  //表示被装饰物
    protected Border(Display display){  //在生成实例时通过参数制定被装饰物
        this.display = display;
    }
}
