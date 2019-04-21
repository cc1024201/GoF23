package src.com.gof23.c23interpreter2.language;

/**
 * @program: GoF23
 * @description: 表示运行时的异常类
 * @author: Cc.
 * @create: 2019-04-21 14:49
 **/
public class ExecuteException extends Exception {
    public ExecuteException(String msg){
        super(msg);
    }
}
