package src.com.gof23.c17observer3;

/**
 * @program: GoF23
 * @description: 表示以图示显示数值的类
 * @author: Cc.
 * @create: 2019-04-20 15:11
 **/
public class GraphObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) {
        System.out.println("GraphObserver:");
        int count = generator.getNumber();
        for(int i=0; i<count; i++){
            System.out.print("*");
        }
        System.out.println("");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
