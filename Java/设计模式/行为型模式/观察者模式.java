/**
 * 观察者模式
 * 定义：定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。
 * 类型：行为型
 *
 * 适用场景：
 * 1. 关联行为场景，建立一套触发机制。
 * 2. 事件多级触发场景。
 *
 * 优点：
 * 1. 观察者和被观察者之间建立了一个抽象的耦合。
 * 2. 观察者模式支持广播通信。
 *
 * 缺点：
 * 1. 观察者之间有过多的细节依赖、时间消耗、程序复杂度增加。
 * 2. 使用要得当，要避免循环调用。
 *
 * 结构：
 * 1. 抽象主题（Subject）：被观察者抽象类或接口。
 * 2. 具体主题（ConcreteSubject）：具体被观察者对象。
 * 3. 抽象观察者（Observer）：观察者抽象类或接口。
 * 4. 具体观察者（ConcreteObserver）：具体观察者对象。
 *
 * 案例：
 * 以微信公众号为例，公众号为被观察者，用户为观察者，当公众号更新时，用户会收到通知。
 * 代码实现：
 * 以微信公众号为例，公众号为被观察者，用户为观察者，当公众号更新时，用户会收到通知。
 */
public class ObserverPatternDemo {
    public static void main(String[] args) {
        // 创建被观察者
        WeChatAccounts weChatAccounts = new WeChatAccounts("JavaGuide");
        // 创建观察者
        User user1 = new User("小明");
        User user2 = new User("小红");
        User user3 = new User("小刚");
        // 注册观察者
        weChatAccounts.registerObserver(user1);
        weChatAccounts.registerObserver(user2);
        weChatAccounts.registerObserver(user3);
        // 发布文章
        weChatAccounts.publishArticle("JavaGuide的Java学习笔记：Java中的观察者模式");
    }
}

/**
 * 抽象主题（Subject）：被观察者抽象类或接口。
 */
interface Subject {
    /**
     * 注册观察者
     *
     * @param observer 观察者
     */
    void registerObserver(Observer observer);

    /**
     * 移除观察者
     *
     * @param observer 观察者
     */
    void removeObserver(Observer observer);

    /**
     * 通知观察者
     *
     * @param message 消息
     */
    void notifyObservers(String message);
}

/**
 * 具体主题（ConcreteSubject）：具体被观察者对象。
 */
class WeChatAccounts implements Subject {
    /**
     * 订阅者列表
     */
    private List<Observer> observerList = new ArrayList<>();
    /**
     * 公众号名称
     */
    private String name;

    public WeChatAccounts(String name) {
        this.name = name;
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observerList) {
            observer.update(name, message);
        }
    }

    /**
     * 发布文章
     *
     * @param article 文章
     */
    public void publishArticle(String article) {
        System.out.println(name + "发布了一篇文章：" + article);
        notifyObservers(article);
    }
}

/**
 * 抽象观察者（Observer）：观察者抽象类或接口。
 */
interface Observer {
    /**
     * 更新
     *
     * @param name    公众号名称
     * @param message 消息
     */
    void update(String name, String message);
}

/**
 * 具体观察者（ConcreteObserver）：具体观察者对象。
 */
class User implements Observer {
    /**
     * 用户名
     */
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String name, String message) {
        System.out.println(this.name + "收到了" + name + "发布的文章，内容为：" + message);
    }
}
