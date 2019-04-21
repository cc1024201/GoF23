package src.com.gof23.c19state3;

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
        }else if(e.getSource() == buttonPhone){
            state.doPhone(this);
        }else if(e.getSource() == buttonExit){
            System.exit(0);
        }else{
            System.out.println("?");
        }
    }

    @Override
    public void setClock(int hour) {
        String clockstring = "现在的时间是";
        if(hour < 10){
            clockstring += "0" + hour + ":00";
        }else{
            clockstring += hour + ":00";
        }
        System.out.println(clockstring);
        textClock.setText(clockstring);
        state.doClock(this, hour);
    }

    @Override
    public void changeState(State state) {
        System.out.println("从" + this.state + "状态变为了" + state + "状态。");
        this.state = state;
    }

    @Override
    public void callSecurityCenter(String msg) {
        textScreen.append("call !" + msg + "\n");
    }

    @Override
    public void recordLog(String msg) {
        textScreen.append("record ..."  + msg + "\n");
    }
}
