/**
 * 中介者模式
 * 定义：用一个中介对象来封装一系列的对象交互，中介者使各对象不需要显式地相互作用，从而使其耦合松散，而且可以独立地改变它们之间的交互。
 * 类型：行为型
 *
 * 适用场景：
 * 1. 系统中对象之间存在复杂的引用关系，系统结构混乱且难以理解。
 * 2. 一个对象由于引用了其他很多对象并且直接和这些对象通信，导致难以复用该对象。
 * 3. 想定制一个分布在多个类中的行为，但又不想生成太多子类的情况。
 *
 * 优点：
 * 1. 降低了类的复杂度，将一对多转化成了一对一。
 * 2. 各个类之间的解耦，增加了类的复用性。
 * 3. 中介者可以控制对象之间的交互，起到了协调作用。
 *
 * 缺点：
 * 1. 中介者会庞大，变得复杂难以维护。
 * 2. 中介者需要知道所有的细节，过多的了解会导致风险增加。
 *
 * 结构：
 * 1. 抽象中介者（Mediator）：定义了同事对象到中介者对象的接口。
 * 2. 具体中介者（ConcreteMediator）：实现抽象中介者的方法，它需要知道所有的具体同事类，同时需要从具体的同事类那里接收信息，并且向具体的同事类发送信息。
 * 3. 抽象同事类（Colleague）：定义了中介者对象的接口，它只知道中介者而不知道其他同事对象。
 * 4. 具体同事类（ConcreteColleague）：所有的具体同事类都从抽象同事类继承而来，每个具体同事类都知道自己在小范围内的行为，而不知道它在大范围内的目的。
 *
 * 案例：
 * 以聊天室为例，聊天室中有多个用户，用户之间需要相互发送消息，但是用户之间不应该直接相互通信，而是通过聊天室这个中介者来进行消息的发送和接收。
 *
 * 代码实现：
 * 以聊天室为例，聊天室中有多个用户，用户之间需要相互发送消息，但是用户之间不应该直接相互通信，而是通过聊天室这个中介者来进行消息的发送和接收。
 */
public class MediatorPatternDemo {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();

        User user1 = new User("Tom");
        User user2 = new User("Jerry");

        user1.sendMessage("Hi, Jerry!");
        user2.sendMessage("Hello, Tom!");
    }
}

/**
 * 抽象中介者
 */
abstract class Mediator {
    public abstract void sendMessage(String message, User user);
}

/**
 * 具体中介者
 */
class ChatRoom extends Mediator {
    @Override
    public void sendMessage(String message, User user) {
        System.out.println(user.getName() + " sends message: " + message);
    }
}

/**
 * 抽象同事类
 */
abstract class User {
    private String name;
    private Mediator mediator;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void sendMessage(String message) {
        mediator.sendMessage(message, this);
    }

    public abstract void receiveMessage(String message);
}

/**
 * 具体同事类
 */
class ConcreteUser extends User {
    public ConcreteUser(String name) {
        super(name);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(getName() + " receives message: " + message);
    }
}
