/**
 * 单例模式
 * 定义：保证一个类仅有一个实例，并提供一个访问它的全局访问点
 * 类型：创建型
 *
 * 适用场景：
 * 需要频繁创建的一些类，使用单例可以降低系统的内存压力，减少 GC。
 * 某个类创建的对象需要消耗的资源过多，如 I/O 与数据库的连接等。
 * 需要频繁实例化然后销毁的对象。
 *
 * 优点：
 * 单例模式可以保证内存里只有一个实例，减少了内存的开销。
 * 可以避免对资源的多重占用。
 * 单例模式设置全局访问点，可以优化和共享资源的访问。
 *
 * 缺点：
 * 单例模式一般没有接口，扩展困难，若要扩展，除了修改代码基本上没有第二种途径。
 * 在并发测试中，单例模式不利于代码调试。在调试过程中，如果单例中的代码没有执行完，也不能模拟生成一个新的对象。
 * 单例模式的功能代码通常写在一个类中，如果功能设计不合理，则很容易违背单一职责原则。
 *
 * 结构：
 * 单例模式包含一个单例类，该类可以直接被实例化。该类中有一个私有静态变量，用于保存单例实例。
 * 私有构造方法保证外部无法直接实例化该类。
 * 通过公共静态方法获取单例类的实例，如果该实例不存在，则创建一个新实例并返回。
 *
 * 案例：
 * 懒汉式单例模式
 * 代码实现：
 * 以懒汉式单例模式为例，实现一个线程安全的单例模式
 */
public class Singleton {
    // 1.私有化构造器
    private Singleton() {}

    // 2.创建私有静态实例
    private static Singleton instance;

    // 3.提供公共静态方法获取实例
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        // 获取单例对象
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        // 判断是否为同一个对象
        System.out.println(instance1 == instance2);
    }
}
