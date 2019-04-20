package src.com.gof23.c17observer2;

/**
 * @program: GoF23
 * @description: 表示以数字形式显示数值的类
 * @author: Cc.
 * @create: 2019-04-20 15:08
 **/
public class DigitObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) {
        System.out.println("DigitObserver:" + generator.getNumber());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
