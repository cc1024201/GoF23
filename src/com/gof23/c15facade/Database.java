package src.com.gof23.c15facade;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @program: GoF23
 * @description: 从邮件地址中获取用户名的类
 * @author: Cc.
 * @create: 2019-04-20 13:13
 **/
public class Database {
    private Database(){

    }
    public static Properties getProperties(String dbname){  //根据数据库名获取Properties
        String filename = dbname + ".txt";
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(filename));
        } catch (IOException e) {
            System.out.println("Warning:" + filename + "is not found.");
        }
        return prop;
    }
}
