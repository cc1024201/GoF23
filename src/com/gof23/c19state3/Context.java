package src.com.gof23.c19state3;

/**
 * @program: GoF23
 * @description: 表示负责夫案例状态和联系警报中心的接口
 * @author: Cc.
 * @create: 2019-04-20 16:55
 **/
public interface Context {
    public abstract void setClock(int hour);    //设置时间
    public abstract void changeState(State state);  //改变状态
    public abstract void callSecurityCenter(String msg);    //联系警报中心
    public abstract void recordLog(String msg); //再报警中心留下记录
}
