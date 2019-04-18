package src.com.gof23.c4factorymethod.idcard;

import src.com.gof23.c4factorymethod.framework.Product;

/**
 * @program: GoF23
 * @description: 产品Product的子类
 * @author: Cc.
 * @create: 2019-04-18 11:48
 **/
public class IDCard extends Product {
    private String owner;
    IDCard(String owner) {
        System.out.println("制作" + owner + "的ID卡。");
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println("使用" + owner + "的ID卡。");
    }

    public String getOwner(){
        return owner;
    }
}
