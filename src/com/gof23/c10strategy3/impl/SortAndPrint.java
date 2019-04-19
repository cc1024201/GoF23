package src.com.gof23.c10strategy3.impl;

import src.com.gof23.c10strategy3.Sorter;

/**
 * @program: GoF23
 * @description: 排序和输出
 * @author: Cc.
 * @create: 2019-04-19 15:45
 **/
public class SortAndPrint {
    Comparable[] data;
    Sorter sorter;

    public SortAndPrint(Comparable[] data, Sorter sorter) {
        this.data = data;
        this.sorter = sorter;
    }
    public void execute(){
        print();
        sorter.sort(data);
        print();
    }
    public void print(){
        for(int i=0; i<data.length; i++){
            System.out.println(data[i] + ",");
        }
        System.out.println("");
    }
}
