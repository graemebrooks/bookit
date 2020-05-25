package com.bookit.bookit.dao;

import com.bookit.bookit.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class FakeBookDataAccessService implements BookDao {

    private static List<Book> DB = new ArrayList<>();

    @Override
    public int insertBook(UUID id, Book book) {
        DB.add(new Book(id, book.getTitle()));
        return 1;
    }

    @Override
    public List<Book> selectAllBooks() {
        return DB;
    }
}
