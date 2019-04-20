package src.com.gof23.c13visitor3;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @program: GoF23
 * @description: 表示文件夹的类
 * @author: Cc.
 * @create: 2019-04-20 10:29
 **/
public class Directory extends Entry {
    private String name;
    private ArrayList dir = new ArrayList();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        SizeVisitor v = new SizeVisitor();
        accept(v);
        return v.getSize();
    }

    @Override
    public Entry add(Entry entry){
        dir.add(entry);
        return this;
    }
    public Iterator iterator(){
        return dir.iterator();
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
