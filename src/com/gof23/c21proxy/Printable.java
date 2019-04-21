package src.com.gof23.c21proxy;

/**
 * @program: GoF23
 * @description: printer和printerproxy共同的接口
 * @author: Cc.
 * @create: 2019-04-20 21:47
 **/
public interface Printable {
    public abstract void setPrinterName(String name);
    public abstract String getPrinterName();
    public abstract void print(String string);
}
