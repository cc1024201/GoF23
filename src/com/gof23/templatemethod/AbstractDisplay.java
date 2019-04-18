package src.com.gof23.templatemethod;

/**
 * @program: GoF23
 * @description: 抽象类
 * @author: Cc.
 * @create: 2019-04-18 10:47
 **/
public abstract class AbstractDisplay {
    public abstract void open();
    public abstract void print();
    public abstract void close();
    public final void display(){
        open();
        for(int i=0; i<5; i++){
            print();
        }
        close();;
    }
}
