package src.com.gof23.c10strategy3.impl;

import src.com.gof23.c10strategy3.Sorter;

/**
 * @program: GoF23
 * @description: 实现：选择排序
 * @author: Cc.
 * @create: 2019-04-19 15:35
 **/
public class SelectionSorter implements Sorter {
    @Override
    public void sort(Comparable[] data) {
        for(int i=0; i<data.length-1; i++){
            int min = i;
            for(int j=i+1; j<data.length; j++){
                if(data[min].compareTo(data[j]) > 0){
                    min = j;
                }
            }
            Comparable passingplace = data[min];
            data[min] = data[i];
            data[i] = passingplace;
        }
    }
}
