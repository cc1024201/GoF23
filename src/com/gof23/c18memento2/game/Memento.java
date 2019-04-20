package src.com.gof23.c18memento2.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: GoF23
 * @description: 表示Gamer状态的类
 * @author: Cc.
 * @create: 2019-04-20 15:49
 **/
public class Memento implements Serializable {
    int money;
    ArrayList fruits;
    public int getMoney(){
        return money;
    }
    Memento(int money){
        this.money = money;
        this.fruits = new ArrayList();
    }
    void addFruit(String fruit){
        fruits.add(fruit);
    }
    List getFruits(){
        return (List) fruits.clone();
    }
}
