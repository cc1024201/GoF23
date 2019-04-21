package src.com.gof23.c20flyweight;

/**
 * @program: GoF23
 * @description: 表示用BigChar组成的大型字符串类
 * @author: Cc.
 * @create: 2019-04-20 21:19
 **/
public class BigString {
    //大型字符的数组
    private BigChar[] bigChars;
    public BigString(String string){
        bigChars = new BigChar[string.length()];
        BigCharFactory factory = BigCharFactory.getInstance();
        for(int i=0; i<bigChars.length; i++){
            bigChars[i] = factory.getBigChar(string.charAt(i));
        }
    }
    //显示
    public void print(){
        for(int i=0; i<bigChars.length; i++){
            bigChars[i].print();
        }
    }
}
