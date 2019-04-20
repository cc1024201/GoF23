package src.com.gof23.c13visitor4;

/**
 * @program: GoF23
 * @description: 表示文件的类
 * @author: Cc.
 * @create: 2019-04-20 10:24
 **/
public class File extends Entry {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
