package src.com.gof23.c2iterator.impl;

import src.com.gof23.c2iterator.Aggregate;
import src.com.gof23.c2iterator.Iterator;

/**
 * @program: GoF23
 * @description: 表示书架的类（实现Aggregate）
 * @author: Cc.
 * @create: 2019-04-17 22:06
 **/
public class BookShelf implements Aggregate {
    private Book[] books;
    private int last = 0;

    public BookShelf(int maxsize) {
        this.books = new Book[maxsize];
    }

    public Book getBookAt(int index) {
        return books[index];
    }

    public void appendBook(Book book) {
        this.books[last] = book;
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
