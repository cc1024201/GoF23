/**
 * 桥接模式
 * 定义：将抽象部分与它的实现部分分离，使它们都可以独立地变化。
 * 类型：结构型
 *
 * 适用场景：
 * 1.如果一个系统需要在构件的抽象化角色和具体化角色之间增加更多的灵活性，避免在两个层次之间建立静态的继承关系，通过桥接模式可以使它们在抽象层建立一个关联关系。
 * 2.抽象部分和实现部分可以以继承的方式独立扩展而互不影响。
 * 3.一个类存在两个（或多个）独立变化的维度，且这两个（或多个）维度都需要进行扩展。
 *
 * 优点：
 * 1.分离抽象部分及其具体实现部分。
 * 2.提高了系统的可扩展性。
 * 3.符合开闭原则。
 * 4.符合合成复用原则。
 *
 * 缺点：
 * 1.增加了系统的理解与设计难度。
 * 2.需要正确地识别出系统中两个独立变化的维度。
 *
 * 结构：
 * 1.Abstraction：抽象类
 * 2.RefinedAbstraction：扩展抽象类
 * 3.Implementor：实现类接口
 * 4.ConcreteImplementor：具体实现类
 *
 * 案例：
 * 以手机软件和手机品牌为例，手机软件和手机品牌是两个独立变化的维度，通过桥接模式将它们分离开来，使得它们可以独立扩展。
 * 代码实现：
 * 以手机软件和手机品牌为例，手机软件和手机品牌是两个独立变化的维度，通过桥接模式将它们分离开来，使得它们可以独立扩展。
 */
public class BridgePatternDemo {
    public static void main(String[] args) {
        PhoneBrand phoneBrand = new ApplePhone();
        phoneBrand.setPhoneSoft(new GameSoft());
        phoneBrand.run();

        phoneBrand.setPhoneSoft(new AddressListSoft());
        phoneBrand.run();

        phoneBrand = new HuaweiPhone();
        phoneBrand.setPhoneSoft(new GameSoft());
        phoneBrand.run();

        phoneBrand.setPhoneSoft(new AddressListSoft());
        phoneBrand.run();
    }
}

/**
 * 手机品牌
 */
abstract class PhoneBrand {
    protected PhoneSoft phoneSoft;

    public void setPhoneSoft(PhoneSoft phoneSoft) {
        this.phoneSoft = phoneSoft;
    }

    public abstract void run();
}

/**
 * 手机软件
 */
interface PhoneSoft {
    void run();
}

/**
 * 游戏软件
 */
class GameSoft implements PhoneSoft {
    @Override
    public void run() {
        System.out.println("运行游戏软件");
    }
}

/**
 * 通讯录软件
 */
class AddressListSoft implements PhoneSoft {
    @Override
    public void run() {
        System.out.println("运行通讯录软件");
    }
}

/**
 * 苹果手机
 */
class ApplePhone extends PhoneBrand {
    @Override
    public void run() {
        System.out.print("苹果手机");
        phoneSoft.run();
    }
}

/**
 * 华为手机
 */
class HuaweiPhone extends PhoneBrand {
    @Override
    public void run() {
        System.out.print("华为手机");
        phoneSoft.run();
    }
}
