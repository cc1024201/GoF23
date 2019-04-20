package src.com.gof23.c14chainofresponsibility;

/**
 * @program: GoF23
 * @description: 解决编号小于limit值的问题
 * @author: Cc.
 * @create: 2019-04-20 11:50
 **/
public class LimitSupport extends Support {
    private int limit;

    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if(trouble.getNumber() < limit){
            return true;
        }else{
            return false;
        }
    }
}
