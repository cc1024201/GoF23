package src.com.gof23.c7builder3;

/**
 * @program: GoF23
 * @description: 使用纯文本编写文档
 * @author: Cc.
 * @create: 2019-04-18 15:59
 **/
public class TextBuilder extends Builder {
    private StringBuffer buffer = new StringBuffer();
    @Override
    public void buildTitle(String title) {
        buffer.append("============================\n");
        buffer.append("[" + title + "]");
        buffer.append("\n");
    }

    @Override
    public void buildString(String str) {
        buffer.append('-' + str + "\n");
        buffer.append("\n");
    }

    @Override
    public void buildItems(String[] items) {
        for(int i=0; i<items.length; i++){
            buffer.append(" ." + items[i] + "\n");
        }
        buffer.append("\n");
    }

    @Override
    public void buildDone() {
        buffer.append("============================\n");
    }

    public String getResult(){
        return buffer.toString();
    }
}
