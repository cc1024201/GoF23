package src.com.gof23.c6prototype.impl;

import src.com.gof23.c6prototype.framework.Product;

/**
 * @program: GoF23
 * @description: 具体实现类
 * @author: Cc.
 * @create: 2019-04-18 14:16
 **/
public class MessageBox implements Product {
    private char decochar;

    public MessageBox(char decochar) {
        this.decochar = decochar;
    }

    @Override
    public void use(String s) {
        int length = s.getBytes().length;
        for(int i=0; i<length+4; i++){
            System.out.print(decochar);
        }
        System.out.println("");
        System.out.println(decochar + " " + s + " " + decochar);
        for(int i=0; i<length+4; i++){
            System.out.print(decochar);
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
