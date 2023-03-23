/**
 * 工厂方法模式
 * 定义：定义一个用于创建对象的接口，让子类决定将哪一个类实例化。工厂方法模式使得一个类的实例化延迟到其子类。
 * 类型：创建型
 *
 * 适用场景：
 * 1.创建对象需要大量重复的代码。
 * 2.客户端（应用层）不依赖于产品类实例如何被创建、实现等细节。
 * 3.一个类通过其子类来指定创建哪个对象。
 *
 * 优点：
 * 1.用户只需要关心所需产品对应的工厂，无需关心创建细节。
 * 2.加入新产品符合开闭原则，提高了系统的可扩展性。
 *
 * 缺点：
 * 1.类的个数容易过多，增加复杂度。
 * 2.增加了系统的抽象性和理解难度。
 *
 * 结构：
 * 1.Product：抽象产品
 * 2.ConcreteProduct：具体产品
 * 3.Factory：抽象工厂
 * 4.ConcreteFactory：具体工厂
 *
 * 案例：
 * 以生产不同类型的电视机为例，抽象出电视机工厂和电视机产品。
 * 代码实现：
 * 以生产不同类型的电视机为例，抽象出电视机工厂和电视机产品。
 */
//抽象产品
interface TV {
    void play();
}

//具体产品
class HaierTV implements TV {
    @Override
    public void play() {
        System.out.println("海尔电视机播放中......");
    }
}

class HisenseTV implements TV {
    @Override
    public void play() {
        System.out.println("海信电视机播放中......");
    }
}

//抽象工厂
interface TVFactory {
    TV produceTV();
}

//具体工厂
class HaierTVFactory implements TVFactory {
    @Override
    public TV produceTV() {
        System.out.println("海尔电视机工厂生产海尔电视机。");
        return new HaierTV();
    }
}

class HisenseTVFactory implements TVFactory {
    @Override
    public TV produceTV() {
        System.out.println("海信电视机工厂生产海信电视机。");
        return new HisenseTV();
    }
}

//客户端
public class Client {
    public static void main(String[] args) {
        TVFactory factory = new HaierTVFactory();
        TV tv = factory.produceTV();
        tv.play();
    }
}
