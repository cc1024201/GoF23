package src.com.gof23.iterator2.impl;

import src.com.gof23.iterator2.Aggregate;
import src.com.gof23.iterator2.Iterator;

import java.util.ArrayList;

/**
 * @program: GoF23
 * @description: 表示书架的类（实现Aggregate）
 * @author: Cc.
 * @create: 2019-04-17 22:06
 **/
public class BookShelf implements Aggregate {
    private ArrayList books;

    public BookShelf(int initialsize) {
        this.books = new ArrayList(initialsize);
    }

    public Book getBookAt(int index) {
        return (Book) books.get(index);
    }

    public void appendBook(Book book) {
        books.add(book);
    }

    public int getLength() {
        return books.size();
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
