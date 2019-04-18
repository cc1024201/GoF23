package src.com.gof23.c5singleton3;

/**
 * @program: GoF23
 * @description: 只生成三个实例
 * @author: Cc.
 * @create: 2019-04-18 13:46
 **/
public class Triple {
    private static Triple[] triples = new Triple[]{
      new Triple(0),
      new Triple(1),
      new Triple(2),
    };
    private int id;
    private Triple(int id){
        System.out.println("The instance" + id + " is created!");
        this.id = id;
    }
    public static Triple getInstance(int id){
        return triples[id];
    }
    @Override
    public String toString(){
        return "[Triple id+" +id + "]";
    }
}
