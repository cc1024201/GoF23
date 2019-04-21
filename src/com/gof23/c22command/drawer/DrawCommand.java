package src.com.gof23.c22command.drawer;

import src.com.gof23.c22command.command.Command;

import java.awt.*;

/**
 * @program: GoF23
 * @description: 表示绘制一个点的命令
 * @author: Cc.
 * @create: 2019-04-21 10:55
 **/
public class DrawCommand implements Command {
    //绘制对象
    protected Drawable drawable;
    //绘制位置
    private Point position;

    public DrawCommand(Drawable drawable, Point position) {
        this.drawable = drawable;
        this.position = position;
    }

    @Override
    public void execute() {
        drawable.draw(position.x, position.y);
    }
}
