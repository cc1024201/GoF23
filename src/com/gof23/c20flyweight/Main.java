package src.com.gof23.c20flyweight;

/**
 * @program: GoF23
 * @description: 测试
 * @author: Cc.
 * @create: 2019-04-20 21:29
 **/
public class Main {
    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println("Usage: java Main digits");
            System.out.println("Example: java Main 1212123");
            System.exit(0);
        }

        /*BigString bs = new BigString(args[0]);*/
        BigString bs = new BigString("1212");
        bs.print();
    }
}
