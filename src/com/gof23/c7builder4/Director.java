package src.com.gof23.c7builder4;

/**
 * @program: GoF23
 * @description: 编写一个文档的类
 * @author: Cc.
 * @create: 2019-04-18 15:55
 **/
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct(){
        builder.makeTitle("Greeting");
        builder.makeString("从早上至下午");
        builder.makeItems(new String[]{
                "早上好。",
                "下午好。"
        });
        builder.makeString("晚上");
        builder.makeItems(new String[]{
                "晚上好。",
                "晚安。",
                "再见。"
        });
        builder.close();
    }
}
