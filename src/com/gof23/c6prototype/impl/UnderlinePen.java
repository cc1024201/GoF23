package src.com.gof23.c6prototype.impl;

import src.com.gof23.c6prototype.framework.Product;

/**
 * @program: GoF23
 * @description: 具体实现类
 * @author: Cc.
 * @create: 2019-04-18 14:21
 **/
public class UnderlinePen implements Product {
    private char ulchar;

    public UnderlinePen(char ulchar) {
        this.ulchar = ulchar;
    }

    @Override
    public void use(String s) {
        int length = s.getBytes().length;
        System.out.println("\"" + s + "\"");
        System.out.print(" ");
        for(int i=0; i<length; i++){
            System.out.print(ulchar);
        }
        System.out.println("");
    }

    @Override
    public Product createClone() {
        Product p = null;
        try {
            p = (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
