package src.com.gof23.c13visitor4;

/**
 * @program: GoF23
 * @description: 测试
 * @author: Cc.
 * @create: 2019-04-20 10:37
 **/
public class Main {
    public static void main(String[] args) {
        try {
            Directory root = new Directory("root");
            root.add(new File("diary.html", 10));
            root.add(new File("index.html", 20));

            Directory root2 = new Directory("root2");
            root2.add(new File("diary.html", 1000));
            root2.add(new File("index.html", 2000));
            ElementArrayList list = new ElementArrayList();
            list.add(root);
            list.add(root2);
            list.add(new File("etc.html", 1234));
            list.accept(new ListVisitor());
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }
    }
}
