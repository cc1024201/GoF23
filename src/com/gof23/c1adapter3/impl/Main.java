package src.com.gof23.c1adapter3.impl;

import src.com.gof23.c1adapter3.FileIO;

import java.io.IOException;

/**
 * @program: GoF23
 * @description: 测试
 * @author: Cc.
 * @create: 2019-04-18 10:22
 **/
public class Main {
    public static void main(String[] args) {
        FileIO f = new FileProperties();
        try{
            f.readFromFile("file.txt");
            f.setValue("year", "2019");
            f.setValue("month", "4");
            f.setValue("day", "18");
            f.writeToFile("newfile.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
