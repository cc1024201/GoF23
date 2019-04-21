package src.com.gof23.c22command.drawer;

import src.com.gof23.c22command.command.Command;

import java.awt.*;

/**
 * @program: GoF23
 * @description: 设置颜色的功能
 * @author: Cc.
 * @create: 2019-04-21 12:12
 **/
public class ColorCommand implements Command {
    //绘制对象
    protected Drawable drawable;
    //颜色
    private Color color;

    public ColorCommand(Drawable drawable, Color color) {
        this.drawable = drawable;
        this.color = color;
    }

    @Override
    public void execute() {
        drawable.setColor(color);
    }
}
