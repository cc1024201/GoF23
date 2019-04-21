package src.com.gof23.c20flyweight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @program: GoF23
 * @description: 表示大型字符的类
 * @author: Cc.
 * @create: 2019-04-20 21:08
 **/
public class BigChar {
    private char charname;  //字符名字
    private String fontdata;    //大型字符对应的字符串
    public BigChar(char charname){
        this.charname = charname;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("big" + charname + ".txt"));
            String line;
            StringBuffer buffer = new StringBuffer();
            while((line = reader.readLine()) != null){
                buffer.append(line);
                buffer.append("\n");
            }
            reader.close();
            this.fontdata = buffer.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //显示大型字符
    public void print(){
        System.out.println(fontdata);
    }
}
