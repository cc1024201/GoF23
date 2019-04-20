package src.com.gof23.c19state;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @program: GoF23
 * @description: 使用GUI实现报警系统界面的类
 * @author: Cc.
 * @create: 2019-04-20 16:58
 **/
public class SafeFrame extends Frame implements ActionListener, Context {
    private TextField textClock = new TextField(60);    //显示当前时间
    private TextArea textScreen = new TextArea(10, 60); //显示警报记录
    private Button buttonUse = new Button("使用金库");
    private Button buttonAlarm = new Button("按下警铃");
    private Button buttonPhone = new Button("正常通话");
    private Button buttonExit = new Button("结束");
    private State state = DayState.getInstance();   //当前状态

    public SafeFrame(String title){
        super(title);
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());
        add(textClock, BorderLayout.NORTH);
        textClock.setEditable(false);
        add(textScreen, BorderLayout.CENTER);
        textScreen.setEditable(false);
        Panel panel = new Panel();
        panel.add(buttonUse);
        panel.add(buttonAlarm);
        panel.add(buttonPhone);
        panel.add(buttonExit);
        add(panel, BorderLayout.SOUTH);
        pack();
        show();
        buttonUse.addActionListener(this);
        buttonAlarm.addActionListener(this);
        buttonPhone.addActionListener(this);
        buttonExit.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        if(e.getSource() == buttonUse){
            state.doUse(this);
        }else if(e.getSource() == buttonAlarm){
            state.doAlarm(this);
        }
    }

    @Override
    public void setClock(int hour) {

    }

    @Override
    public void changeState(State state) {

    }

    @Override
    public void callSecurityCenter(String msg) {

    }

    @Override
    public void recordLog(String msg) {

    }
}
