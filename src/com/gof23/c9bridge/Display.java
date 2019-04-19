package src.com.gof23.c9bridge;

/**
 * @program: GoF23
 * @description: 类的功能层次结构：Display类
 * @author: Cc.
 * @create: 2019-04-19 11:28
 **/
public class Display {
    private DisplayImpl impl;

    public Display(DisplayImpl impl) {
        this.impl = impl;
    }
    public void open(){
        impl.rawOpen();
    }
    public void print(){
        impl.rawPrint();
    }
    public void close(){
        impl.rawClose();
    }
    public final void display(){
        open();
        print();
        close();
    }
}
