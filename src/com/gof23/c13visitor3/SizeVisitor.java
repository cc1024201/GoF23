package src.com.gof23.c13visitor3;

import java.util.Iterator;

/**
 * @program: GoF23
 * @description: 获取大小的类
 * @author: Cc.
 * @create: 2019-04-20 11:15
 **/
public class SizeVisitor extends Visitor{
    private int size = 0;

    public int getSize(){
        return size;
    }

    @Override
    public void visit(File file) {
        size += file.getSize();
    }

    @Override
    public void visit(Directory directory) {
        Iterator it = directory.iterator();
        while(it.hasNext()){
            Entry entry = (Entry) it.next();
            entry.accept(this);
        }
    }
}
