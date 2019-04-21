package src.com.gof23.c22command.drawer;

import java.awt.*;

/**
 * @program: GoF23
 * @description: 表示绘制对象的接口
 * @author: Cc.
 * @create: 2019-04-21 10:56
 **/
public interface Drawable {
    public abstract void init();
    public abstract void draw(int x, int y);

    public abstract void setColor(Color color);
}
