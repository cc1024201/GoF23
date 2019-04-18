package src.com.gof23.c4factorymethod2.idcard;

import src.com.gof23.c4factorymethod2.framework.Factory;
import src.com.gof23.c4factorymethod2.framework.Product;

import java.util.HashMap;

/**
 * @program: GoF23
 * @description: Factory的子类
 * @author: Cc.
 * @create: 2019-04-18 11:51
 **/
public class IDCardFactory extends Factory {
    private HashMap database = new HashMap();
    private int serial = 100;
    @Override
    protected synchronized Product createProduct(String owner) {
        return new IDCard(owner, serial++);
    }

    @Override
    protected void registerProduct(Product product) {
        IDCard card = (IDCard) product;
        database.put(new Integer(card.getSerial()), card.getOwner());
    }
    public HashMap getDatabase(){
        return database;
    }
}
