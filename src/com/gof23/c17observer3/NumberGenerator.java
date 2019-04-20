package src.com.gof23.c17observer3;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @program: GoF23
 * @description: 表示生成数值的对象的抽象类
 * @author: Cc.
 * @create: 2019-04-20 14:58
 **/
public abstract class NumberGenerator {
    private ArrayList observers = new ArrayList();  //保存Observer们
    public void addObserver(Observer observer){
        observers.add(observer);
    }
    public void deleteObserver(Observer observer){  //删除Observer
        observers.remove(observer);
    }
    public void notifyObservers(){
        Iterator it = observers.iterator();
        while(it.hasNext()){
            Observer o = (Observer) it.next();
            o.update(this);
        }
    }
    public abstract int getNumber();
    public abstract void execute();
}
