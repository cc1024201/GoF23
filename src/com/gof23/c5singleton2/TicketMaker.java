package src.com.gof23.c5singleton2;

/**
 * @program: GoF23
 * @description: 售票类
 * @author: Cc.
 * @create: 2019-04-18 13:35
 **/
public class TicketMaker {
    private int ticket = 1000;
    private static TicketMaker singleton = new TicketMaker();
    private TicketMaker(){
        System.out.println("生成了一个售票类！");
    }
    public static TicketMaker getInstance(){
        return singleton;
    }
    public int getNextTicketNumber(){
        return ticket++;
    }
}
