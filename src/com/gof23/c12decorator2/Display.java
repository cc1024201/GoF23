package src.com.gof23.c12decorator2;

/**
 * @program: GoF23
 * @description: 用于显示字符串的抽象类
 * @author: Cc.
 * @create: 2019-04-19 19:27
 **/
public abstract class Display {
    public abstract int getColumns();   //获取横向字符数
    public abstract int getRows();  //获取纵向行数
    public abstract String getRowText(int row); //获取第row行的字符串
    public final void show(){   //全部显示
        for(int i=0; i<getRows(); i++){
            System.out.println(getRowText(i));
        }
    }
}
