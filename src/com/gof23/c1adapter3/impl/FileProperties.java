package src.com.gof23.c1adapter3.impl;

import src.com.gof23.c1adapter3.FileIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @program: GoF23
 * @description: 适配器
 * @author: Cc.
 * @create: 2019-04-18 09:59
 **/
public class FileProperties extends Properties implements FileIO {
    @Override
    public void readFromFile(String filename) throws IOException {
       load(new FileInputStream(filename));
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        store(new FileOutputStream(filename), "written by FileProperties");
    }

    @Override
    public void setValue(String key, String value) {
        setProperty(key, value);
    }

    @Override
    public String getValue(String key) {
        return getProperty(key);
    }
}
