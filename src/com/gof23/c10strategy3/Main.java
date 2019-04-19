package src.com.gof23.c10strategy3;

import src.com.gof23.c10strategy3.impl.QuickSorter;
import src.com.gof23.c10strategy3.impl.SelectionSorter;
import src.com.gof23.c10strategy3.impl.SortAndPrint;

/**
 * @program: GoF23
 * @description: 测试
 * @author: Cc.
 * @create: 2019-04-19 15:48
 **/
public class Main {
    public static void main(String[] args) {
        String[] data1 = {"Dumpty", "Bowman", "Carroll", "Elfland", "Alice"};
        String[] data2 = {"Dumpty", "Bowman", "Carroll", "Elfland", "Alice"};
        SortAndPrint sap1 = new SortAndPrint(data1, new SelectionSorter());
        sap1.execute();
        SortAndPrint sap2 = new SortAndPrint(data2, new QuickSorter());
        sap2.execute();
    }
}
