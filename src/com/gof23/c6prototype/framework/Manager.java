package src.com.gof23.c6prototype.framework;

import java.util.HashMap;

/**
 * @program: GoF23
 * @description: 使用Product接口来复制实例
 * @author: Cc.
 * @create: 2019-04-18 14:08
 **/
public class Manager {
    private HashMap showcase = new HashMap();
    public void register(String name, Product proto){
        showcase.put(name, proto);
    }
    public Product create(String protoname){
        Product p = (Product) showcase.get(protoname);
        return p.createClone();
    }
}
