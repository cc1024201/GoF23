package src.com.gof23.c23interpreter2.language;

/**
 * @program: GoF23
 * @description: 生成基本命令的接口
 * @author: Cc.
 * @create: 2019-04-21 14:48
 **/
public interface ExecutorFactory {
    public abstract Executor createExecutor(String name);
}
