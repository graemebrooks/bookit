package com.bookit.bookit.dao;

import com.bookit.bookit.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class BookDataAccessService implements BookDao {
    @Override
    public int insertBook(UUID id, Book book) {
        return 0;
    }

    @Override
    public List<Book> selectAllBooks() {
        return List.of(new Book(UUID.randomUUID(), "FROM POSTGRES DB", "JOHN SMITH", "FANTASY"));
    }

    @Override
    public Optional<Book> selectBookById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deleteBookById(UUID id) {
        return 0;
    }

    @Override
    public int updateBookById(UUID id, Book book) {
        return 0;
    }
}
