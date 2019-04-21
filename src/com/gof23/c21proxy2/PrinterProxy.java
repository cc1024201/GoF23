package src.com.gof23.c21proxy2;

/**
 * @program: GoF23
 * @description: 扮演代理人角色的类
 * @author: Cc.
 * @create: 2019-04-21 10:02
 **/
public class PrinterProxy implements Printable {
    private String name; //名字
    private Printable real; //本人
    private String className; //本人的类名
    public PrinterProxy(){

    }

    public PrinterProxy(String name, String className) {
        this.name = name;
        this.className = className;
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
            try {
                real = (Printable) Class.forName(className).newInstance();
                real.setPrinterName(name);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                System.out.println("没有找到" + className + "类。");
            }
        }
    }
}
