package src.com.gof23.c21proxy;

/**
 * @program: GoF23
 * @description: 测试
 * @author: Cc.
 * @create: 2019-04-21 10:08
 **/
public class Main {
    public static void main(String[] args) {
        Printable p = new PrinterProxy("Alice");
        System.out.println("现在的名字是" + p.getPrinterName() + ".");
        p.setPrinterName("Bob");
        System.out.println("现在的名字是" + p.getPrinterName() + ".");
        p.print("Hello, world.");
    }
}
