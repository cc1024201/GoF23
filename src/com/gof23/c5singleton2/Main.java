package src.com.gof23.c5singleton2;

/**
 * @program: GoF23
 * @description: 测试
 * @author: Cc.
 * @create: 2019-04-18 13:38
 **/
public class Main {
    public static void main(String[] args) {
        System.out.println("Start.");
        for(int i=0; i<10; i++){
            System.out.println(i + ":" + TicketMaker.getInstance().getNextTicketNumber());
        }
        System.out.println("End.");

    }
}
