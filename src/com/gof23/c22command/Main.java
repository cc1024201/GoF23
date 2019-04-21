package src.com.gof23.c22command;

import src.com.gof23.c22command.command.Command;
import src.com.gof23.c22command.command.MacroCommand;
import src.com.gof23.c22command.drawer.ColorCommand;
import src.com.gof23.c22command.drawer.DrawCanvas;
import src.com.gof23.c22command.drawer.DrawCommand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @program: GoF23
 * @description: 测试
 * @author: Cc.
 * @create: 2019-04-21 10:44
 **/
public class Main extends JFrame implements ActionListener, MouseMotionListener, WindowListener {
    //绘制的历史记录
    private MacroCommand history = new MacroCommand();
    //绘制区域
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    //删除按钮
    private JButton clearButton = new JButton("clear");
    //红色按钮
    private JButton redButton = new JButton("red");
    //绿色按钮
    private JButton greenButton = new JButton("green");
    //蓝色按钮
    private JButton blueButton = new JButton("blue");
    //撤销按钮
    private JButton undoButton = new JButton("undo");
    public Main(String title){
        super(title);
        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);
        clearButton.addActionListener(this);
        redButton.addActionListener(this);
        greenButton.addActionListener(this);
        blueButton.addActionListener(this);
        undoButton.addActionListener(this);

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        buttonBox.add(redButton);
        buttonBox.add(greenButton);
        buttonBox.add(blueButton);
        buttonBox.add(undoButton);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        show();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == clearButton){
            history.clear();
            canvas.init();
            canvas.repaint();
        }else if(e.getSource() == redButton){
            Command cmd = new ColorCommand(canvas, Color.red);
            history.append(cmd);
            cmd.execute();
        }else if(e.getSource() == greenButton){
            Command cmd = new ColorCommand(canvas, Color.green);
            history.append(cmd);
            cmd.execute();
        }else if(e.getSource() == blueButton){
            Command cmd = new ColorCommand(canvas, Color.blue);
            history.append(cmd);
            cmd.execute();
        }else if(e.getSource() == undoButton){
            history.undo();
            canvas.repaint();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Command cmd = new DrawCommand(canvas, e.getPoint());
        history.append(cmd);
        cmd.execute();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    public static void main(String[] args) {
        new Main("Command Pattern Sample");
    }
}
