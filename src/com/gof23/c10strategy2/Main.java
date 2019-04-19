package src.com.gof23.c10strategy2;

/**
 * @program: GoF23
 * @description: 测试
 * @author: Cc.
 * @create: 2019-04-19 15:08
 **/
public class Main {
    public static void main(String[] args) {
        if(args.length != 2){
            System.out.println("Usage: java Main randomseed1 randomseed2");
            System.out.println("Example: java Main 314 15");
            System.exit(0);
        }
        int seed1 = Integer.parseInt(args[0]);
        int seed2 = Integer.parseInt(args[1]);
        Player player1 = new Player("Taro", new ProbStrategy(seed1));
        Player player2 = new Player("Hana", new RandomStrategy(seed2));
        for(int i=0; i<10000; i++){
            Hand nextHand1 = player1.nextHand();
            Hand nextHand2 = player2.nextHand();
            if(nextHand1.isStrongerThan(nextHand2)){
                System.out.println("Winner:" + player1);
                player1.win();
                player2.lose();
            }else if(nextHand2.isStrongerThan(nextHand1)){
                System.out.println("Winner:" + nextHand2);
                player1.lose();
                player2.win();
            }else{
                System.out.println("EVEN...");
                player1.even();
                player2.even();
            }
        }
        System.out.println("Total result:");
        System.out.println(player1.toString());
        System.out.println(player2.toString());
    }
}
