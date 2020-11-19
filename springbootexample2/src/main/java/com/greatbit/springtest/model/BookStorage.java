package com.greatbit.springtest.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class BookStorage {

    private static Set<Book> books = new HashSet<>();

    static {
        books.add(new Book(UUID.randomUUID().toString(), 416, "Учение Дона Хуана", "Карлос Кастанеда"));
        books.add(new Book(UUID.randomUUID().toString(), 352, "Богатый папа, бедный папа", "Роберт Киосаки"));
    }

    public static Set<Book> getBooks() {
        return books;
    }
}
