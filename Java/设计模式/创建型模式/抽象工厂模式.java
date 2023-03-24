/**
 * 抽象工厂模式
 * 定义：提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。
 * 类型：创建型
 *
 * 适用场景：
 * 1.客户端不依赖于产品类实例如何被创建、实现等细节
 * 2.强调一系列相关的产品对象（属于同一产品族）一起使用创建对象需要大量重复的代码
 * 3.提供一个产品类的库，所有产品以同样的接口出现，从而使客户端不依赖于具体实现
 *
 * 优点：
 * 1.具体产品在应用层代码隔离，无需关心创建细节
 * 2.将一个系列的产品族统一到一起创建
 *
 * 缺点：
 * 1.规定了所有可能被创建的产品集合，产品族扩展困难，需要修改抽象工厂的接口
 * 2.增加了系统的抽象性和理解难度
 *
 * 结构：
 * 1.AbstractFactory：抽象工厂
 * 2.ConcreteFactory：具体工厂
 * 3.AbstractProduct：抽象产品
 * 4.ConcreteProduct：具体产品
 *
 * 案例：
 * 以生产电视机和洗衣机为例，分别有海尔和TCL两个品牌，每个品牌都有对应的电视机和洗衣机产品。
 * 代码实现：
 * 以生产电视机为例，抽象工厂为TVFactory，具体工厂有HaierTVFactory和TCLTVFactory，
 * 抽象产品为TV，具体产品有HaierTV和TCLTV。
 */
public interface TV {
    void play();
}

public class HaierTV implements TV {
    @Override
    public void play() {
        System.out.println("海尔电视机播放中...");
    }
}

public class TCLTV implements TV {
    @Override
    public void play() {
        System.out.println("TCL电视机播放中...");
    }
}

public interface TVFactory {
    TV produceTV();
}

public class HaierTVFactory implements TVFactory {
    @Override
    public TV produceTV() {
        System.out.println("海尔电视机工厂生产海尔电视机。");
        return new HaierTV();
    }
}

public class TCLTVFactory implements TVFactory {
    @Override
    public TV produceTV() {
        System.out.println("TCL电视机工厂生产TCL电视机。");
        return new TCLTV();
    }
}

public class Client {
    public static void main(String[] args) {
        TVFactory factory = new HaierTVFactory();
        TV tv = factory.produceTV();
        tv.play();
    }
}
