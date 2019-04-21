package src.com.gof23.c23interpreter2.language;

/**
 * @program: GoF23
 * @description: 表示语法解析时可能发生的异常的类
 * @author: Cc.
 * @create: 2019-04-21 13:56
 **/
public class ParseException extends Exception {
    public ParseException(String msg){
        super(msg);
    }
}
