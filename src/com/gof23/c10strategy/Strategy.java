package src.com.gof23.c10strategy;

/**
 * @program: GoF23
 * @description: 表示猜拳游戏中的策略的类
 * @author: Cc.
 * @create: 2019-04-19 14:19
 **/
public interface Strategy {
    public abstract Hand nextHand();

    public abstract void study(boolean win);
}
