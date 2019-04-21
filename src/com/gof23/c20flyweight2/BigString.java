package src.com.gof23.c20flyweight2;

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
    public BigString(String string, boolean shared){
        if(shared){
            initShared(string);
        }else {
            initUnshard(string);
        }
    }

    //共享方式初始化
    private void initShared(String string){
        bigChars = new BigChar[string.length()];
        BigCharFactory factory = BigCharFactory.getInstance();
        for(int i=0; i<bigChars.length; i++){
            bigChars[i] = factory.getBigChar(string.charAt(i));
        }
    }
    //非共享的方式初始化
    private void initUnshard(String string){
        bigChars = new BigChar[string.length()];
        for(int i=0; i<bigChars.length; i++){
            bigChars[i] = new BigChar(string.charAt(i));
        }
    }
    //显示
    public void print(){
        for(int i=0; i<bigChars.length; i++){
            bigChars[i].print();
        }
    }
}
