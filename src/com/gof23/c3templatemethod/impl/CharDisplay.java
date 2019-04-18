package src.com.gof23.c3templatemethod.impl;

import src.com.gof23.c3templatemethod.AbstractDisplay;

/**
 * @program: GoF23
 * @description: 继承AbstractDisplay
 * @author: Cc.
 * @create: 2019-04-18 10:50
 **/
public class CharDisplay extends AbstractDisplay {
    private char ch;

    public CharDisplay(char ch) {
        this.ch = ch;
    }

    @Override
    public void open() {
        System.out.print("<<");
    }

    @Override
    public void print() {
        System.out.print(ch);
    }

    @Override
    public void close() {
        System.out.println(">>");
    }
}
