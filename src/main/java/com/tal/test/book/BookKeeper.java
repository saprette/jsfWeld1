package com.tal.test.book;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * User: sam
 * Date: 9/25/12
 * Time: 7:29 AM
 */
@ApplicationScoped
public class BookKeeper {

    List<Book> books = new ArrayList<Book>();

    public BookKeeper() {
    }

    public void addBook(Book newBook) {
        books.add(newBook);
    }

    public List<Book> getBooks() {
        return books;
    }
}
