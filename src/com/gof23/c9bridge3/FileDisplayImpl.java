package src.com.gof23.c9bridge3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @program: GoF23
 * @description: 新增“类的实现层次”
 * @author: Cc.
 * @create: 2019-04-19 12:26
 **/
public class FileDisplayImpl extends DisplayImpl {
    private String filename;
    private BufferedReader reader;
    private final int MAX_READAHEAD_LIMIT = 4096;   //循环显示的极限（缓存大小限制）

    public FileDisplayImpl(String filename) {
        this.filename = filename;
    }
    @Override
    public void rawOpen() {
        try {
            reader = new BufferedReader(new FileReader(filename));
            reader.mark(MAX_READAHEAD_LIMIT);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("=-=-=-=-=-=" + filename + "=-=-=-=-=-=");
    }

    @Override
    public void rawPrint() {
        String line;
        try {
            reader.reset();//回到mark的位置
            while((line = reader.readLine()) != null){
                System.out.println("> " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void rawClose() {
        System.out.println("=-=-=-=-=-=");
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
