package src.com.gof23.c13visitor2;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @program: GoF23
 * @description: 将带有指定后缀名的文件汇集起来
 * @author: Cc.
 * @create: 2019-04-20 11:00
 **/
public class FileFindVisitor extends Visitor{
    private String filetype;
    private ArrayList found = new ArrayList();

    public FileFindVisitor(String filetype) {
        this.filetype = filetype;
    }

    public Iterator getFoundFiles(){
        return found.iterator();
    }

    @Override
    public void visit(File file) {
        if(file.getName().endsWith(filetype)){
            found.add(file);
        }
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
