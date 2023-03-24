/**
 * 状态模式
 * 定义：当一个对象的内部状态改变时，会导致其行为的改变，这看起来像是改变了对象。
 * 类型：行为型
 *
 * 适用场景：
 * 1. 对象的行为依赖于它的状态（属性）并且可以根据它的状态改变而改变它的相关行为。
 * 2. 代码中包含大量与对象状态有关的条件语句。
 *
 * 优点：
 * 1. 将与特定状态相关的行为局部化，并且将不同状态的行为分割开来。
 * 2. 使得状态转换显示化，简化了代码。
 * 3. 用对象代替字符串来记录当前状态，使得状态的切换更加一目了然。
 *
 * 缺点：
 * 1. 状态模式会增加系统中类和对象的个数。
 * 2. 状态模式的结构与实现都较为复杂，如果使用不当会导致程序结构和代码的混乱。
 *
 * 结构：
 * 1. Context：环境类，维护一个State对象，定义了当前状态。
 * 2. State：抽象状态类，定义一个接口以封装与Context的一个特定状态相关的行为。
 * 3. ConcreteState：具体状态类，每一个子类实现一个与Context的一个状态相关的行为。
 *
 * 案例：
 * 以电梯为例，电梯有四种状态：开门状态、关门状态、运行状态、停止状态。不同状态下电梯的行为不同。
 * 代码实现：
 * 以电梯为例，实现电梯的四种状态及其相应的行为。
 */
public class StatePatternDemo {
    public static void main(String[] args) {
        // 创建电梯对象
        Elevator elevator = new Elevator();
        // 电梯初始状态为停止状态
        elevator.setState(new StopState());
        // 电梯开始运行
        elevator.run();
        // 电梯停止运行
        elevator.stop();
        // 电梯开门
        elevator.open();
        // 电梯关门
        elevator.close();
        // 电梯开始运行
        elevator.run();
        // 电梯停止运行
        elevator.stop();
        // 电梯开门
        elevator.open();
        // 电梯关门
        elevator.close();
    }
}

/**
 * 电梯类
 */
class Elevator {
    // 电梯状态
    private State state;

    /**
     * 设置电梯状态
     * @param state 电梯状态
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * 电梯开始运行
     */
    public void run() {
        state.run();
    }

    /**
     * 电梯停止运行
     */
    public void stop() {
        state.stop();
    }

    /**
     * 电梯开门
     */
    public void open() {
        state.open();
    }

    /**
     * 电梯关门
     */
    public void close() {
        state.close();
    }
}

/**
 * 电梯状态接口
 */
interface State {
    /**
     * 电梯开始运行
     */
    void run();

    /**
     * 电梯停止运行
     */
    void stop();

    /**
     * 电梯开门
     */
    void open();

    /**
     * 电梯关门
     */
    void close();
}

/**
 * 停止状态
 */
class StopState implements State {
    @Override
    public void run() {
        System.out.println("电梯开始运行");
    }

    @Override
    public void stop() {
        System.out.println("电梯已经停止运行");
    }

    @Override
    public void open() {
        System.out.println("电梯门已经打开");
    }

    @Override
    public void close() {
        System.out.println("电梯门已经关闭");
    }
}

/**
 * 运行状态
 */
class RunState implements State {
    @Override
    public void run() {
        System.out.println("电梯正在运行");
    }

    @Override
    public void stop() {
        System.out.println("电梯停止运行");
    }

    @Override
    public void open() {
        System.out.println("电梯门已经打开");
    }

    @Override
    public void close() {
        System.out.println("电梯门已经关闭");
    }
}

/**
 * 开门状态
 */
class OpenState implements State {
    @Override
    public void run() {
        System.out.println("电梯门已经打开，请先关闭电梯门");
    }

    @Override
    public void stop() {
        System.out.println("电梯门已经打开，请先关闭电梯门");
    }

    @Override
    public void open() {
        System.out.println("电梯门已经打开");
    }

    @Override
    public void close() {
        System.out.println("电梯门已经关闭");
    }
}

/**
 * 关门状态
 */
class CloseState implements State {
    @Override
    public void run() {
        System.out.println("电梯门已经关闭，电梯开始运行");
    }

    @Override
    public void stop() {
        System.out.println("电梯门已经关闭，电梯停止运行");
    }

    @Override
    public void open() {
        System.out.println("电梯门已经打开");
    }

    @Override
    public void close() {
        System.out.println("电梯门已经关闭");
    }
}
