package src.com.gof23.c4factorymethod2.idcard;

import src.com.gof23.c4factorymethod2.framework.Product;

/**
 * @program: GoF23
 * @description: 产品Product的子类
 * @author: Cc.
 * @create: 2019-04-18 11:48
 **/
public class IDCard extends Product {
    private String owner;
    private int serial;
    IDCard(String owner, int serial) {
        System.out.println("制作" + owner + "(" + serial + ")" + "的ID卡。");
        this.owner = owner;
        this.serial = serial;
    }

    @Override
    public void use() {
        System.out.println("使用" + owner + "(" + serial + ")" + "的ID卡。");
    }

    public String getOwner(){
        return owner;
    }

    public int getSerial(){
        return serial;
    }
}
