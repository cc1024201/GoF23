/**
 * 命令模式
 * 定义：将一个请求封装成一个对象，从而使你可用不同的请求对客户进行参数化，对请求排队或记录请求日志，以及支持可撤销的操作。
 * 类型：行为型
 *
 * 适用场景：
 * 1. 请求调用者和请求接收者需要解耦，使得调用者和接收者不直接交互。
 * 2. 需要抽象出等待执行的行为。
 * 3. 需要支持撤销操作。
 * 4. 需要支持命令的排队执行、撤销和恢复。
 *
 * 优点：
 * 1. 降低系统的耦合度。
 * 2. 新的命令可以很容易地加入到系统中。
 * 3. 可以比较容易地设计一个命令队列或宏命令。
 * 4. 可以方便地实现对请求的撤销和恢复。
 *
 * 缺点：
 * 1. 使用命令模式可能会导致某些系统有过多的具体命令类。
 * 2. 系统的复杂性可能会增加。
 *
 * 结构：
 * 1. Command：抽象命令类，定义了命令的接口，声明了执行的方法。
 * 2. ConcreteCommand：具体命令类，实现了Command接口，定义了执行的方法。
 * 3. Invoker：调用者，负责调用命令对象执行请求。
 * 4. Receiver：接收者，负责接收命令对象并执行命令。
 * 5. Client：客户端，创建具体的命令对象并设置命令的接收者。
 *
 * 案例：
 * 以遥控器控制电视为例，遥控器上有多个按钮，每个按钮对应一个命令，电视机作为命令的接收者，遥控器通过命令来控制电视机的开关、音量等操作。
 * 代码实现：
 * 以遥控器控制电视为例，遥控器上有多个按钮，每个按钮对应一个命令，电视机作为命令的接收者，遥控器通过命令来控制电视机的开关、音量等操作。
 */
public class CommandPatternDemo {
    public static void main(String[] args) {
        // 创建电视机对象（接收者）
        Television television = new Television();

        // 创建具体命令对象并设置它的接收者
        Command turnOnCommand = new TurnOnCommand(television);
        Command turnOffCommand = new TurnOffCommand(television);
        Command changeChannelCommand = new ChangeChannelCommand(television);

        // 创建遥控器对象（调用者）并设置它的命令
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(0, turnOnCommand, turnOffCommand);
        remoteControl.setCommand(1, changeChannelCommand);

        // 开机
        remoteControl.turnOn(0);
        // 换频道
        remoteControl.changeChannel(1);
        // 关机
        remoteControl.turnOff(0);
    }
}

/**
 * 抽象命令类
 */
interface Command {
    /**
     * 执行命令
     */
    void execute();
}

/**
 * 具体命令类：开机命令
 */
class TurnOnCommand implements Command {
    private Television television;

    public TurnOnCommand(Television television) {
        this.television = television;
    }

    @Override
    public void execute() {
        television.turnOn();
    }
}

/**
 * 具体命令类：关机命令
 */
class TurnOffCommand implements Command {
    private Television television;

    public TurnOffCommand(Television television) {
        this.television = television;
    }

    @Override
    public void execute() {
        television.turnOff();
    }
}

/**
 * 具体命令类：换频道命令
 */
class ChangeChannelCommand implements Command {
    private Television television;

    public ChangeChannelCommand(Television television) {
        this.television = television;
    }

    @Override
    public void execute() {
        television.changeChannel();
    }
}

/**
 * 接收者：电视机
 */
class Television {
    public void turnOn() {
        System.out.println("电视机已开机");
    }

    public void turnOff() {
        System.out.println("电视机已关机");
    }

    public void changeChannel() {
        System.out.println("电视机换频道");
    }
}

/**
 * 调用者：遥控器
 */
class RemoteControl {
    private Command[] onCommands;
    private Command[] offCommands;

    public RemoteControl() {
        onCommands = new Command[2];
        offCommands = new Command[2];
    }

    /**
     * 设置命令
     *
     * @param slot          插槽位置
     * @param onCommand     开机命令
     * @param offCommand    关机命令
     */
    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    /**
     * 开机
     *
     * @param slot  插槽位置
     */
    public void turnOn(int slot) {
        onCommands[slot].execute();
    }

    /**
     * 关机
     *
     * @param slot  插槽位置
     */
    public void turnOff(int slot) {
        offCommands[slot].execute();
    }

    /**
     * 换频道
     *
     * @param slot  插槽位置
     */
    public void changeChannel(int slot) {
        onCommands[slot].execute();
    }
}
