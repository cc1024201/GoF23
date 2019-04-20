package src.com.gof23.c17observer2;

/**
 * @program: GoF23
 * @description: 具有数值递增功能的类
 * @author: Cc.
 * @create: 2019-04-20 15:29
 **/
public class IncrementalNumberGenerator extends NumberGenerator {
    private int number;
    private int end;
    private int inc;

    public IncrementalNumberGenerator(int number, int end, int inc) {
        this.number = number;
        this.end = end;
        this.inc = inc;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void execute() {
        while (number < end){
            notifyObservers();
            number += inc;
        }
    }
}
