package src.com.gof23.c14chainofresponsibility2;

/**
 * @program: GoF23
 * @description: 解决奇数编号的问题
 * @author: Cc.
 * @create: 2019-04-20 11:51
 **/
public class OddSupport extends Support {
    public OddSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if(trouble.getNumber() % 2 == 1){
            return true;
        }else{
            return false;
        }
    }
}
