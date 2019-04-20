package src.com.gof23.c13visitor;

import java.util.Iterator;

/**
 * @program: GoF23
 * @description: File和Directory类的父类，它是抽象类（实现了Element接口）
 * @author: Cc.
 * @create: 2019-04-20 10:19
 **/
public abstract class Entry implements Element{
    public abstract String getName();
    public abstract int getSize();
    public Entry add(Entry entry) throws FileTreatmentException{
        throw new FileTreatmentException();
    }
    public Iterator iteator() throws FileTreatmentException{
        throw new FileTreatmentException();
    }
    @Override
    public String toString(){
        return getName() + "(" + getSize() + ")";
    }
}
