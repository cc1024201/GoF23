/**
 * 享元模式
 * 定义：运用共享技术有效地支持大量细粒度的对象，避免对象间拥有相同内容造成多余的开销。
 * 类型：结构型
 *
 * 适用场景：
 * 1. 系统中存在大量的相似对象。
 * 2. 细粒度的对象都具备较接近的外部状态，而且内部状态与环境无关，也就是说对象没有特定身份。
 * 3. 需要缓冲池的场景。
 *
 * 优点：
 * 1. 大大减少对象的创建，降低系统的内存，提高效率。
 * 2. 减少内存之外的其他资源占用。
 *
 * 缺点：
 * 1. 关注内部/外部状态，关注线程安全问题。
 * 2. 使系统、程序的逻辑复杂化。
 *
 * 结构：
 * 1. 抽象享元角色（Flyweight）：所有具体享元类的超类或接口，通过这个接口，Flyweight可以接受并作用于外部状态。
 * 2. 具体享元角色（ConcreteFlyweight）：实现抽象享元角色中所规定的接口。
 * 3. 享元工厂角色（FlyweightFactory）：负责创建和管理享元角色，确保享元对象可以被系统适当地共享。
 * 4. 客户端角色（Client）：维护一个对所有享元对象的引用，而且还需要存储所有享元对象的外部状态。
 *
 * 案例：
 * 以围棋为例，棋盘上有很多棋子，每个棋子都有颜色、大小等属性，但是棋子的形状都是一样的，所以可以使用享元模式来共享
 */

/**
 * 抽象享元角色
 */
public interface Chessman {
    void display(Coordinate coordinate);
}

/**
 * 具体享元角色
 */
public class ConcreteChessman implements Chessman {
    private String color;

    public ConcreteChessman(String color) {
        this.color = color;
    }

    @Override
    public void display(Coordinate coordinate) {
        System.out.println("棋子颜色：" + color);
        System.out.println("棋子位置：" + coordinate.getX() + "，" + coordinate.getY());
    }
}

/**
 * 享元工厂角色
 */
public class ChessmanFactory {
    private static Map<String, Chessman> map = new HashMap<>();

    public static Chessman getChessman(String color) {
        Chessman chessman = map.get(color);
        if (chessman == null) {
            chessman = new ConcreteChessman(color);
            map.put(color, chessman);
        }
        return chessman;
    }
}

/**
 * 客户端角色
 */
public class Client {
    public static void main(String[] args) {
        Chessman chessman1 = ChessmanFactory.getChessman("黑色");
        Chessman chessman2 = ChessmanFactory.getChessman("黑色");
        Chessman chessman3 = ChessmanFactory.getChessman("白色");
        Chessman chessman4 = ChessmanFactory.getChessman("白色");

        System.out.println(chessman1 == chessman2);
        System.out.println(chessman3 == chessman4);

        chessman1.display(new Coordinate(1, 2));
        chessman2.display(new Coordinate(3, 4));
        chessman3.display(new Coordinate(5, 6));
        chessman4.display(new Coordinate(7, 8));
    }
}

/**
 * 外部状态类
 */
class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
