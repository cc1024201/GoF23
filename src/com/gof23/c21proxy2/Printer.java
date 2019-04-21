package src.com.gof23.c21proxy2;

/**
 * @program: GoF23
 * @description: 表示本人的类
 * @author: Cc.
 * @create: 2019-04-20 21:47
 **/
public class Printer implements Printable {
    private String name;
    public Printer(){
        heavyJob("正在生成printer实例");
    }
    public Printer(String name){
        this.name = name;
        heavyJob("正在生成printer的实例（" + name + ")");
    }
    @Override
    public void setPrinterName(String name) {
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String string) {
        System.out.println("===" + name + "===");
        System.out.println(string);
    }
    private void heavyJob(String msg){
        System.out.println(msg);
        for(int i=0; i<5; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(".");
        }
        System.out.println("结束");
    }
}
