package src.com.gof23.iterator.impl;

import src.com.gof23.iterator.Iterator;

/**
 * @program: GoF23
 * @description: 遍历书架的类
 * @author: Cc.
 * @create: 2019-04-17 22:17
 **/
public class BookShelfIterator implements Iterator {
    private BookShelf bookShelf;
    private int index;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
    }

    @Override
    public boolean hasNext() {
        if (index < bookShelf.getLength()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object next() {
        Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }
}