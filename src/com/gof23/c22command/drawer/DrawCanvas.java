package src.com.gof23.c22command.drawer;

import src.com.gof23.c22command.command.MacroCommand;

import java.awt.*;

/**
 * @program: GoF23
 * @description: 表示绘制对象的类
 * @author: Cc.
 * @create: 2019-04-21 11:02
 **/
public class DrawCanvas extends Canvas implements Drawable {

    //颜色
    private Color color;
    //要绘制的原点的半径
    private int radius;
    //命令的历史记录
    private MacroCommand history;
    public DrawCanvas(int width, int height, MacroCommand history){
        setSize(width, height);
        setBackground(Color.white);
        this.history = history;
    }
    //重新绘制全部
    @Override
    public void paint(Graphics g){
        history.execute();
    }

    @Override
    public void init() {
        color = Color.red;
        radius = 6;
        history.append(new ColorCommand(this, color));
    }

    //绘制
    @Override
    public void draw(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillOval(x-radius, y-radius, radius*2, radius*2);
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }
}
