package com.greatbit.springtest.model;

import java.util.HashSet;
import java.util.Set;

public class BookStorage {

    private static Set<Book> books = new HashSet<>();

    static {
        books.add(new Book("B1", "A1"));
        books.add(new Book("B2", "A2"));
    }

    public static Set<Book> getBooks() {
        return books;
    }
}
