package src.com.gof23.c1adapter3;

import java.io.IOException;

/**
 * @program: GoF23
 * @description: Target角色（将属性集合保存至文件的方法）
 * @author: Cc.
 * @create: 2019-04-18 09:55
 **/
public interface FileIO {
    public void readFromFile(String filename) throws IOException;

    public void writeToFile(String filename) throws IOException;

    public void setValue(String key, String value);

    public String getValue(String key);
}
