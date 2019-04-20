package src.com.gof23.c16mediator;

/**
 * @program: GoF23
 * @description: 表示向仲裁者进行报告的组员的接口
 * @author: Cc.
 * @create: 2019-04-20 14:35
 **/
public interface Colleague {
    public abstract void setMediator(Mediator mediator);
    public abstract void setColleagueEnabled(boolean enabled);
}
