package src.com.gof23.c5singleton3;

/**
 * @program: GoF23
 * @description: 测试
 * @author: Cc.
 * @create: 2019-04-18 13:53
 **/
public class Main {
    public static void main(String[] args) {
        System.out.println("Start.");
        for(int i=0; i<9; i++){
            Triple triple = Triple.getInstance(i%3);
            System.out.println(i + ":" + triple);
        }
        System.out.println("End.");
    }
}
