package src.com.gof23.c7builder4;

import javax.swing.*;

/**
 * @program: GoF23
 * @description: 测试
 * @author: Cc.
 * @create: 2019-04-18 16:14
 **/
public class Main {
    public static void main(String[] args) {
        FrameBuilder frameBuilder = new FrameBuilder();
        Director director = new Director(frameBuilder);
        director.construct();
        JFrame frame = frameBuilder.getResult();
        frame.setVisible(true);
    }
}
