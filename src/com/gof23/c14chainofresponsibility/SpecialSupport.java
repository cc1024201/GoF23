package src.com.gof23.c14chainofresponsibility;

/**
 * @program: GoF23
 * @description: 只解决指定编号的问题
 * @author: Cc.
 * @create: 2019-04-20 11:53
 **/
public class SpecialSupport extends Support {
    private int number;

    public SpecialSupport(String name, int number) {    //只解决指定编号的问题
        super(name);
        this.number = number;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if(trouble.getNumber() == number){
            return true;
        }else{
            return false;
        }
    }
}
