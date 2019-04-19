package src.com.gof23.c9bridge3;

/**
 * @program: GoF23
 * @description: 类的功能层次结构：CountDisplay
 * @author: Cc.
 * @create: 2019-04-19 11:31
 **/
public class CountDisplay extends Display {
    public CountDisplay(DisplayImpl impl) {
        super(impl);
    }
    public void multiDisplay(int times){
        open();
        for(int i=0; i<times; i++){
            print();
        }
        close();
    }
}
