package com.bookit.bookit.dao;

import com.bookit.bookit.model.Book;

import java.util.List;
import java.util.UUID;

public interface BookDao {

    // Inserts book if ID is available
    int insertBook(UUID id, Book book);

    // Generates random UUID for new book if ID is not available
    default int insertBook(Book book) {
        UUID id = UUID.randomUUID();
        return insertBook(id, book);
    }

    List<Book> selectAllBooks();

}
