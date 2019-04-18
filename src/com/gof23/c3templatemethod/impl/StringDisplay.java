package src.com.gof23.c3templatemethod.impl;

import src.com.gof23.c3templatemethod.AbstractDisplay;

/**
 * @program: GoF23
 * @description: 继承AbstructDisplay
 * @author: Cc.
 * @create: 2019-04-18 10:52
 **/
public class StringDisplay extends AbstractDisplay {
    private String string;
    private int width;

    public StringDisplay(String string) {
        this.string = string;
        this.width = string.getBytes().length;
    }

    @Override
    public void open() {
        printLine();
    }

    @Override
    public void print() {
        System.out.println("|" + string + "|");
    }

    @Override
    public void close() {
        printLine();
    }

    private void printLine(){
        System.out.print("+");
        for(int i=0; i<width; i++){
            System.out.print("-");
        }
        System.out.println("+");
    }
}
