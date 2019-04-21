package src.com.gof23.c21proxy;

/**
 * @program: GoF23
 * @description: 扮演代理人角色的类
 * @author: Cc.
 * @create: 2019-04-21 10:02
 **/
public class PrinterProxy implements Printable{
    private String name; //名字
    private Printer real; //本人
    public PrinterProxy(){

    }
    public PrinterProxy(String name){
        this.name = name;
    }
    @Override
    public synchronized void setPrinterName(String name) {
        if(real != null){
            real.setPrinterName(name);
        }
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String string) {
        realize();
        real.print(string);
    }
    private synchronized void realize(){
        if(real == null){
            real = new Printer(name);
        }
    }
}
