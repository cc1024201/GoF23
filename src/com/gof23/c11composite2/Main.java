package src.com.gof23.c11composite2;

/**
 * @program: GoF23
 * @description: 测试
 * @author: Cc.
 * @create: 2019-04-19 16:22
 **/
public class Main {
    public static void main(String[] args) {
        try{
            System.out.println("Making root entries...");
            Directory rootdir = new Directory("root");

            Directory usrdir = new Directory("usr");
            rootdir.add(usrdir);

            Directory yuki = new Directory("yuki");
            usrdir.add(yuki);
            File file = new File("Composite.java", 100);
            yuki.add(file);
            rootdir.printList();
            System.out.println("");

            System.out.println("file = " + file.getFullName());
            System.out.println("yuki = " + yuki.getFullName());
        }catch (FileTreatmentException e){
            e.printStackTrace();
        }
    }
}
