package src.com.gof23.c11composite2;

/**
 * @program: GoF23
 * @description: 抽象类，用来实现File类和Dirctory类的一致性
 * @author: Cc.
 * @create: 2019-04-19 16:04
 **/
public abstract class Entry {
    protected Entry parent;
    public abstract String getName();   //获取名称
    public abstract int getSize();  //获取大小
    public Entry add(Entry entry) throws FileTreatmentException {    //加入目录条目
        throw new FileTreatmentException();
    }
    public void printList(){
        printList("");
    }
    protected abstract void printList(String prefix);

    public String getFullName(){
        StringBuffer fullname = new StringBuffer();
        Entry entry = this;
        do{
            fullname.insert(0, "/" + entry.getName());
            entry = entry.parent;
        }while(entry != null);
        return fullname.toString();
    }
    @Override
    public String toString(){
        return getName() + "(" + getSize() + ")";
    }
}
