package src.com.gof23.c10strategy;

/**
 * @program: GoF23
 * @description: 表示猜拳游戏中的“手势”的类
 * @author: Cc.
 * @create: 2019-04-19 14:09
 **/
public class Hand {
    public static final int HANDVALUE_GUU = 0; //表示石头的值
    public static final int HANDVALUE_CHO = 1; //表示剪刀的值
    public static final int HANDVALUE_PAA = 2; //表示布的值
    public static final Hand[] hand = {
            new Hand(HANDVALUE_GUU),
            new Hand(HANDVALUE_CHO),
            new Hand(HANDVALUE_PAA)
    };
    private static final String[] name = {
            "石头", "剪刀", "布"
    };
    private int handvalue;
    private Hand(int handvalue){
        this.handvalue = handvalue;
    }
    public static Hand getHand(int handvalue){
        return hand[handvalue];
    }
    public boolean isStrongerThan(Hand h){
        return fight(h) == 1;
    }
    public boolean isWeakerThan(Hand h){
        return fight(h) == -1;
    }
    private int fight(Hand h){
        if(this == h){
            return 0;
        }else if((this.handvalue +1)%3 == h.handvalue){
            return 1;
        }else{
            return -1;
        }
    }
    @Override
    public String toString(){
        return name[handvalue];
    }
}
