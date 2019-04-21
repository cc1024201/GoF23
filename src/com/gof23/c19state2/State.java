package src.com.gof23.c19state2;

/**
 * @program: GoF23
 * @description: 表示金库状态的接口
 * @author: Cc.
 * @create: 2019-04-20 16:40
 **/
public interface State {
    public abstract void doClock(Context context, int hour);    //设置时间

    public abstract void doUse(Context context);    //使用金库

    public abstract void doAlarm(Context context);  //按下警铃

    public abstract void doPhone(Context context);  //正常通话
}
