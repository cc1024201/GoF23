package src.com.gof23.c14chainofresponsibility2;

/**
 * @program: GoF23
 * @description: 永远“不解决问题的”类
 * @author: Cc.
 * @create: 2019-04-20 11:49
 **/
public class NoSupport extends Support {
    public NoSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return false;
    }
}
