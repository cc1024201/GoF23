package src.com.gof23.c20flyweight2;

import java.util.HashMap;

/**
 * @program: GoF23
 * @description: 生成BigChar类实例的工厂
 * @author: Cc.
 * @create: 2019-04-20 21:13
 **/
public class BigCharFactory {
    //管理已经生成的BigChar的实例
    private HashMap pool = new HashMap();
    //Singleton模式
    private static BigCharFactory singleton = new BigCharFactory();
    //构造函数
    private BigCharFactory(){

    }
    //获取唯一的实例
    public static BigCharFactory getInstance(){
        return singleton;
    }
    //生成共享的BigChar类的实例
    public synchronized BigChar getBigChar(char charname){
        BigChar bc = (BigChar) pool.get("" + charname);
        if(bc == null){
            bc = new BigChar(charname); //生成BigChar的实例
            pool.put("" + charname, bc);
        }
        return bc;
    }
}
