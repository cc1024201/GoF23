package src.com.gof23.iterator.impl;

import src.com.gof23.iterator.Aggregate;
import src.com.gof23.iterator.Iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: GoF23
 * @description: 表示书架的类（实现Aggregate）
 * @author: Cc.
 * @create: 2019-04-17 22:06
 **/
public class BookShelf implements Aggregate {
    private List<Book> books;
    private int last = 0;

    public BookShelf(int maxsize) {
        this.books = new ArrayList<>(maxsize);
    }

    public Book getBookAt(int index) {
        return books.get(index);
    }

    public void appendBook(Book book) {
        this.books.add(last, book);
        last++;
    }

    public int getLength() {
        return last;
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
