package src.com.gof23.c9bridge;

/**
 * @program: GoF23
 * @description: 类的实现层次结构：StringDisplayImpl
 * @author: Cc.
 * @create: 2019-04-19 11:35
 **/
public class StringDisplayImpl extends DisplayImpl {
    private String string;
    private int width;

    public StringDisplayImpl(String string) {
        this.string = string;
        this.width = string.getBytes().length;
    }

    @Override
    public void rawOpen() {
        printLine();
    }

    @Override
    public void rawPrint() {
        System.out.println("|" + string + "|");
    }

    @Override
    public void rawClose() {
        printLine();
    }
    private void printLine(){
        System.out.print("+");
        for(int i=0; i<width; i++){
            System.out.print("-");
        }
        System.out.println("+");
    }
}
