package src.com.gof23.c23interpreter2.turtle;

import src.com.gof23.c23interpreter2.language.ExecuteException;
import src.com.gof23.c23interpreter2.language.Executor;
import src.com.gof23.c23interpreter2.language.ExecutorFactory;

import java.awt.*;

/**
 * @program: GoF23
 * @description: 实现海龟绘图的类
 * @author: Cc.
 * @create: 2019-04-21 14:50
 **/
public class TurtleCanvas extends Canvas implements ExecutorFactory {
    final static int UNIT_LENGTH = 30;  //前进时的长度单位
    final static int DIRECTION_UP = 0;  //上方
    final static int DIRECTION_RIGHT = 3;   //右方
    final static int DIRECTION_DOWN = 6;    //下方
    final static int DIRECTION_LEFT = 9;    //左方
    final static int RELATIVE_DIRECTION_RIGHT = 3;  //右转
    final static int RELATIVE_DIRECTION_LEFT = -3;  //左转
    final static int RADIUS = 3; //半径
    private int direction = 0;
    private Point positon;
    private Executor executor;
    public TurtleCanvas(int width, int height){
        setSize(width, height);
        initialize();
    }
    public void setExecutor(Executor executor){
        this.executor = executor;
    }
    void setRelativeDirection(int relativeDirection){
        setDiection(direction + relativeDirection);
    }
    void setDiection(int diection){
        if(diection <0){
            diection = 12-(-diection)%12;
        }else{
            diection = direction%12;
        }
        this.direction = diection%12;
    }
    void go(int length){
        int newx = positon.x;
        int newy = positon.y;
        switch (direction){
            case DIRECTION_UP:
                newy -= length;
                break;
            case DIRECTION_RIGHT:
                newx += length;
                break;
            case DIRECTION_DOWN:
                newy += length;
                break;
            case DIRECTION_LEFT:
                newx -= length;
                break;
            default:
                break;
        }
        Graphics g = getGraphics();
        if(g != null){
            g.drawLine(positon.x, positon.y, newx, newy);
            g.fillOval(newx-RADIUS, newy-RADIUS, RADIUS*2+1,RADIUS*2+1);
        }
        positon.x = newx;
        positon.y = newy;
    }
    @Override
    public Executor createExecutor(String name) {
        if(name.equals("go")){
            return new GoExecutor(this);
        }else if(name.equals("right")){
            return new DirectionExecutor(this, RELATIVE_DIRECTION_RIGHT);
        }else if(name.equals("left")){
            return new DirectionExecutor(this, RELATIVE_DIRECTION_LEFT);
        }else {
            return null;
        }
    }
    public void initialize(){
        Dimension size = getSize();
        positon = new Point(size.width/2, size.height/2);
        direction = 0;
        setForeground(Color.red);
        setBackground(Color.white);
        Graphics g = getGraphics();
        if(g != null){
            g.clearRect(0, 0, size.width, size.height);
        }
    }
    @Override
    public void paint(Graphics g){
        initialize();
        if(executor != null){
            try {
                executor.execute();
            } catch (ExecuteException e) {
                e.printStackTrace();
            }
        }
    }
}
abstract class TurtleExecutor implements Executor{
    protected TurtleCanvas canvas;
    public TurtleExecutor(TurtleCanvas canvas){
        this.canvas = canvas;
    }
    @Override
    public abstract void execute();
}
class GoExecutor extends TurtleExecutor{
    public GoExecutor(TurtleCanvas canvas) {
        super(canvas);
    }
    @Override
    public void execute(){
        canvas.go(TurtleCanvas.UNIT_LENGTH);
    }
}
class DirectionExecutor extends TurtleExecutor{
    private int relativeDirection;

    public DirectionExecutor(TurtleCanvas canvas, int relativeDirection) {
        super(canvas);
        this.relativeDirection = relativeDirection;
    }
    @Override
    public void execute(){
        canvas.setRelativeDirection(relativeDirection);
    }
}