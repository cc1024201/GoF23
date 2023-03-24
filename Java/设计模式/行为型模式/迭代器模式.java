/**
 * 迭代器模式
 * 定义：提供一种方法顺序访问一个聚合对象中各个元素，而又不暴露该对象的内部表示。
 * 类型：行为型
 *
 * 适用场景：
 * 1.访问一个聚合对象的内容而无需暴露它的内部表示。
 * 2.支持对聚合对象的多种遍历。
 * 3.为遍历不同的聚合结构提供一个统一的接口。
 *
 * 优点：
 * 1.分离了集合对象的遍历行为。
 * 2.简化了集合对象。
 * 3.在同一个聚合上可以有多个遍历。
 * 4.在迭代器模式中增加新的聚合类和迭代器类都很方便，无需修改原有代码。
 *
 * 缺点：
 * 1.增加了类的个数，这在一定程度上增加了系统的复杂性。
 * 2.抽象迭代器的设计难度较大，需要充分考虑到系统将来的扩展。
 *
 * 结构：
 * 1.抽象迭代器（Iterator）：定义了访问和遍历元素的接口，通常包含 hasNext()、next()、remove() 等方法。
 * 2.具体迭代器（ConcreteIterator）：实现迭代器接口中定义的方法，完成集合元素的遍历。
 * 3.抽象聚合类（Aggregate）：定义创建迭代器对象的接口。
 * 4.具体聚合类（ConcreteAggregate）：实现了创建迭代器对象的接口，返回一个合适的具体迭代器实例。
 *
 * 案例：
 * 以电影院售票系统为例，实现对电影院中电影票的遍历。
 * 
 * 代码实现：
 * 以电影院售票系统为例，实现对电影院中电影票的遍历。
 * 
 * 1.定义电影票类，包含电影名称和价格两个属性。
 * 2.定义电影院类，包含电影票列表和添加电影票、删除电影票、获取电影票列表等方法。
 * 3.定义迭代器接口，包含 hasNext()、next()、remove() 等方法。
 * 4.定义电影票迭代器类，实现迭代器接口中定义的方法，完成电影票列表的遍历。
 * 5.在电影院类中实现创建迭代器对象的接口，返回一个合适的具体迭代器实例。
 * 6.编写测试用例，测试电影院中电影票的遍历功能。
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 电影票类
 */
class MovieTicket {
    private String movieName;
    private double price;

    public MovieTicket(String movieName, double price) {
        this.movieName = movieName;
        this.price = price;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

/**
 * 电影院类
 */
class Cinema {
    private List<MovieTicket> movieTicketList;

    public Cinema() {
        movieTicketList = new ArrayList<>();
    }

    /**
     * 添加电影票
     *
     * @param movieTicket 电影票
     */
    public void addMovieTicket(MovieTicket movieTicket) {
        movieTicketList.add(movieTicket);
    }

    /**
     * 删除电影票
     *
     * @param movieTicket 电影票
     */
    public void removeMovieTicket(MovieTicket movieTicket) {
        movieTicketList.remove(movieTicket);
    }

    /**
     * 获取电影票列表
     *
     * @return 电影票列表
     */
    public List<MovieTicket> getMovieTicketList() {
        return movieTicketList;
    }

    /**
     * 创建电影票迭代器
     *
     * @return 电影票迭代器
     */
    public Iterator createIterator() {
        return new MovieTicketIterator(movieTicketList);
    }
}

/**
 * 迭代器接口
 */
interface Iterator {
    /**
     * 是否还有下一个元素
     *
     * @return 是否还有下一个元素
     */
    boolean hasNext();

    /**
     * 获取下一个元素
     *
     * @return 下一个元素
     */
    Object next();

    /**
     * 删除当前元素
     */
    void remove();
}

/**
 * 电影票迭代器类
 */
class MovieTicketIterator implements Iterator {
    private List<MovieTicket> movieTicketList;
    private int index;

    public MovieTicketIterator(List<MovieTicket> movieTicketList) {
        this.movieTicketList = movieTicketList;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < movieTicketList.size();
    }

    @Override
    public Object next() {
        if (hasNext()) {
            return movieTicketList.get(index++);
        }
        return null;
    }

    @Override
    public void remove() {
        if (index < movieTicketList.size()) {
            movieTicketList.remove(index);
        }
    }
}

/**
 * 测试类
 */
public class IteratorPatternDemo {
    public static void main(String[] args) {
        // 创建电影院对象
        Cinema cinema = new Cinema();

        // 添加电影票
        cinema.addMovieTicket(new MovieTicket("电影1", 30));
        cinema.addMovieTicket(new MovieTicket("电影2", 40));
        cinema.addMovieTicket(new MovieTicket("电影3", 50));

        // 获取电影票列表
        List<MovieTicket> movieTicketList = cinema.getMovieTicketList();

        // 遍历电影票列表
        Iterator iterator = cinema.createIterator();
        while (iterator.hasNext()) {
            MovieTicket movieTicket = (MovieTicket) iterator.next();
            System.out.println("电影名称：" + movieTicket.getMovieName() + "，价格：" + movieTicket.getPrice());
        }
    }
}
