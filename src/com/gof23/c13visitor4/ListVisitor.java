package src.com.gof23.c13visitor4;

import java.util.Iterator;

/**
 * @program: GoF23
 * @description: 访问数据结构并显示元素一览
 * @author: Cc.
 * @create: 2019-04-20 10:32
 **/
public class ListVisitor extends Visitor {
    private String currentdir = "";

    @Override
    public void visit(File file) {
        System.out.println(currentdir + "/" + file);
    }

    @Override
    public void visit(Directory directory) {
        System.out.println(currentdir + "/" +directory);
        String savedir = currentdir;
        currentdir = currentdir + "/" + directory.getName();
        Iterator iterator = directory.iterator();
        while(iterator.hasNext()){
            Entry entry = (Entry) iterator.next();
            entry.accept(this);
        }
        currentdir = savedir;
    }
}
