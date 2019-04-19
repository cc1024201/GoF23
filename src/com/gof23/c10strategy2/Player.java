package src.com.gof23.c10strategy2;

/**
 * @program: GoF23
 * @description: 表示进程猜拳游戏的选手
 * @author: Cc.
 * @create: 2019-04-19 15:03
 **/
public class Player {
    private String name;
    private Strategy strategy;
    private int wincount;
    private int losecount;
    private int gamecount;

    public Player(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public Hand nextHand(){
        return strategy.nextHand();
    }
    public void win(){
        strategy.study(true);
        wincount++;
        gamecount++;
    }
    public void lose(){
        strategy.study(false);
        losecount++;
        gamecount++;
    }
    public void even(){
        gamecount++;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", strategy=" + strategy +
                ", wincount=" + wincount +
                ", losecount=" + losecount +
                ", gamecount=" + gamecount +
                '}';
    }
}
