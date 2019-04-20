package src.com.gof23.c11composite2;

/**
 * @program: GoF23
 * @description: 对文件调用add方法时抛出的异常
 * @author: Cc.
 * @create: 2019-04-19 16:10
 **/
public class FileTreatmentException extends RuntimeException{
    public FileTreatmentException() {
    }
    public FileTreatmentException(String msg){
        super(msg);
    }
}
