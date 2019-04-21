package src.com.gof23.c23interpreter2;

import src.com.gof23.c23interpreter2.language.InterpreterFacade;
import src.com.gof23.c23interpreter2.turtle.TurtleCanvas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @program: GoF23
 * @description: 测试
 * @author: Cc.
 * @create: 2019-04-21 14:46
 **/
public class Main extends Frame implements ActionListener {
    private TurtleCanvas canvas = new TurtleCanvas(400, 400);
    private InterpreterFacade facade = new InterpreterFacade(canvas);
    private TextField programTextField = new TextField("program repeat 3 go right go left end end");
    public Main(String title){
        super(title);
        canvas.setExecutor(facade);
        setLayout(new BorderLayout());
        programTextField.addActionListener(this);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        add(programTextField, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        pack();
        parseAndExecute();
        show();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == programTextField){
            parseAndExecute();
        }
    }
    private void parseAndExecute(){
        String programText = programTextField.getText();
        System.out.println("programText = " + programText);
        facade.parse(programText);
        canvas.repaint();;
    }

    public static void main(String[] args) {
        new Main("Interperter Pattern Sample");
    }
}
