package src.com.gof23.c10strategy2;

import java.util.Random;

/**
 * @program: GoF23
 * @description: 表示“根据上一局的手势从概率上计算下一局的手势从之前的猜拳结果计算下一局出各种拳的概率”这一策略类
 * @author: Cc.
 * @create: 2019-04-19 14:28
 **/
public class ProbStrategy implements Strategy {
    private Random random;
    private int prevHandValue = 0;
    private int currentHandValue = 0;
    private int[][] history = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
    };
    public ProbStrategy(int seed){
        random = new Random(seed);
    }
    @Override
    public Hand nextHand() {
        int bet = random.nextInt(getSum(currentHandValue));
        int handvalue = 0;
        if(bet < history[currentHandValue][0]){
            handvalue = 0;
        }else if(bet < history[currentHandValue][0] + history[currentHandValue][1]){
            handvalue = 1;
        }else{
            handvalue = 2;
        }
        prevHandValue = currentHandValue;
        currentHandValue = handvalue;
        return Hand.getHand(handvalue);
    }

    private int getSum(int hv){
        int sum = 0;
        for(int i=0; i<3; i++){
            sum += history[hv][i];
        }
        return sum;
    }
    @Override
    public void study(boolean win) {
        if(win){
            history[prevHandValue][currentHandValue]++;
        }else{
            history[prevHandValue][(currentHandValue + 1) % 3]++;
            history[prevHandValue][(currentHandValue + 2) % 3]++;
        }
    }
}
