/**
 * 代理模式
 * 定义：为其他对象提供一种代理以控制对这个对象的访问
 * 类型：结构型
 *
 * 适用场景：
 * 1.保护目标对象
 * 2.增强目标对象
 *
 * 优点：
 * 1.代理模式能够协调调用者和被调用者，在一定程度上降低了系统的耦合度
 * 2.客户端可以针对抽象主题角色进行编程，增加和更换代理类无须修改源代码，符合开闭原则
 * 3.代理模式能够在一定程度上提高系统的安全性
 * 4.代理模式能够在一定程度上提高系统的性能
 *
 * 缺点：
 * 1.代理模式会造成系统设计中类的数量增加
 * 2.在客户端和目标对象增加一个代理对象，会造成请求处理速度变慢
 * 3.增加了系统的复杂度
 *
 * 结构：
 * 1.抽象主题角色：通过接口或抽象类声明真实主题和代理对象实现的业务方法
 * 2.真实主题角色：实现抽象主题角色中所声明的方法，是被代理的对象
 * 3.代理主题角色：实现抽象主题角色中所声明的方法，是代理真实主题角色的代表，通过真实主题角色实现业务方法并附加额外操作
 *
 * 案例：
 * 以购买火车票为例，火车站售票员是真实主题角色，代理售票员是代理主题角色，购票者是客户端
 * 代码实现：
 * 以购买火车票为例，火车站售票员
 */
public class ProxyPattern {
    public static void main(String[] args) {
        // 创建真实主题对象
        RealSubject realSubject = new RealSubject();
        // 创建代理主题对象
        ProxySubject proxySubject = new ProxySubject(realSubject);
        // 调用代理主题对象的方法
        proxySubject.buyTicket();
    }
}

/**
 * 抽象主题角色
 */
interface Subject {
    void buyTicket();
}

/**
 * 真实主题角色
 */
class RealSubject implements Subject {
    @Override
    public void buyTicket() {
        System.out.println("火车站售票员卖票");
    }
}

/**
 * 代理主题角色
 */
class ProxySubject implements Subject {
    private Subject realSubject;

    public ProxySubject(Subject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void buyTicket() {
        System.out.println("代理售票员收取服务费");
        realSubject.buyTicket();
    }
}
