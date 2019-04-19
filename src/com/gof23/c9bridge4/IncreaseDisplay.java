package src.com.gof23.c9bridge4;

/**
 * @program: GoF23
 * @description: 表示逐渐增加显示次数的“功能上”的类
 * @author: Cc.
 * @create: 2019-04-19 13:51
 **/
public class IncreaseDisplay extends CountDisplay {
    private int step; //递增步长
    public IncreaseDisplay(DisplayImpl impl, int step) {
        super(impl);
        this.step = step;
    }
    public void increaseDisplay(int level){
        int count = 0;
        for(int i=0; i<level; i++){
            multiDisplay(count);
            count += step;
        }
    }
}
