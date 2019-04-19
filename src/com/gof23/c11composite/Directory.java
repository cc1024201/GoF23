package src.com.gof23.c11composite;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @program: GoF23
 * @description: 表示文件夹的类
 * @author: Cc.
 * @create: 2019-04-19 16:17
 **/
public class Directory extends Entry {
    private String name;
    private ArrayList directory = new ArrayList();

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
        Iterator it = directory.iterator();
        while(it.hasNext()){
            Entry entry = (Entry) it.next();
            size += entry.getSize();
        }
        return size;
    }

    @Override
    public Entry add(Entry entry){
        directory.add(entry);
        return this;
    }
    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        Iterator it = directory.iterator();
        while(it.hasNext()){
            Entry entry = (Entry) it.next();
            entry.printList(prefix + "/" + name);
        }
    }
}
