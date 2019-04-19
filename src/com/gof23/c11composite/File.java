package src.com.gof23.c11composite;

/**
 * @program: GoF23
 * @description: 表示文件的类
 * @author: Cc.
 * @create: 2019-04-19 16:13
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
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
    }
}
