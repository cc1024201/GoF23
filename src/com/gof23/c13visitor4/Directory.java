package src.com.gof23.c13visitor4;

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
        int size = 0;
        Iterator iterator = dir.iterator();
        while(iterator.hasNext()){
            Entry entry = (Entry) iterator.next();
            size += entry.getSize();
        }
        return size;
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
