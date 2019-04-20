package src.com.gof23.c14chainofresponsibility;

/**
 * @program: GoF23
 * @description: 表示发生问题的类
 * @author: Cc.
 * @create: 2019-04-20 11:38
 **/
public class Trouble {
    private int number; //问题编号

    public Trouble(int number) {
        this.number = number;
    }

    public int getNumber(){
        return number;
    }

    @Override
    public String toString() {
        return "Trouble{" +
                "number=" + number +
                '}';
    }
}
