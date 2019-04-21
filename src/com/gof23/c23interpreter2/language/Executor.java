package src.com.gof23.c23interpreter2.language;

/**
 * @program: GoF23
 * @description: 表示运行的接口
 * @author: Cc.
 * @create: 2019-04-21 14:49
 **/
public interface Executor {
    public abstract void execute() throws ExecuteException;
}
