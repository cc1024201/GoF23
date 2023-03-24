/**
 * 适配器模式
 * 定义：将一个类的接口转换成客户希望的另一个接口。适配器模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
 * 类型：结构型
 *
 * 适用场景：
 * 1.已经存在的类，它的方法和需求不匹配时（方法结果相同或相似）
 * 2.不是软件设计阶段考虑的设计模式，是随着软件维护，由于不同产品、不同厂家造成功能类似而接口不相同情况下的解决方案。
 *
 * 优点：
 * 1.能提高类的透明性和复用，现有的类复用但不需要改变
 * 2.目标类和适配器类解耦，提高程序扩展性
 * 3.在很多业务场景中符合开闭原则
 *
 * 缺点：
 * 1.适配器编写过程需要全面考虑，可能会增加系统的复杂性
 * 2.增加系统代码可读的难度
 *
 * 结构：
 * 1.目标(Target)接口：当前系统业务所期待的接口，它可以是抽象类或接口
 * 2.适配器(Adapter)类：它是一个转换器，通过继承或实现目标接口，把源接口转换成目标接口，同时它也是一个源接口，把自己的方法转换成目标接口中期待的方法
 * 3.源(Adaptee)接口：已经存在的接口，但是和目标接口不一致，需要被适配
 *
 * 案例：
 * 以充电器为例，手机充电器的电压是5V，而家用电源的电压是220V，这时需要一个电源适配器将220V的电压转换成5V的电压，以便手机充电。
 *
 * 代码实现：
 * 以手机充电为例，定义目标接口为充电器，定义源接口为家用电源，定义适配器为电源适配器，实现适配器将家用电源的220V电压转换成5V电压，以便手机充电。
 */

public interface Charger {
    void charge();
}

public class Phone {
    public void charging(Charger charger) {
        System.out.println("手机开始充电");
        charger.charge();
        System.out.println("手机充电结束");
    }
}

public interface PowerSource {
    void output220V();
}

public class HomePowerSource implements PowerSource {
    @Override
    public void output220V() {
        System.out.println("家用电源输出220V电压");
    }
}

public class PowerAdapter implements Charger {
    private PowerSource powerSource;

    public PowerAdapter(PowerSource powerSource) {
        this.powerSource = powerSource;
    }

    @Override
    public void charge() {
        System.out.println("电源适配器开始工作");
        powerSource.output220V();
        System.out.println("电源适配器将220V电压转换成5V电压");
    }
}

public class AdapterPatternDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        PowerSource powerSource = new HomePowerSource();
        Charger charger = new PowerAdapter(powerSource);
        phone.charging(charger);
    }
}
