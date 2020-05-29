package com.bookit.bookit.dao;

import com.bookit.bookit.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeBookDataAccessService implements BookDao {

    private static List<Book> DB = new ArrayList<>();

    @Override
    public int insertBook(UUID id, Book book) {
        DB.add(new Book(id, book.getTitle(), book.getAuthor(), book.getGenre()));
        return 1;
    }

    @Override
    public List<Book> selectAllBooks() {
        return DB;
    }

    @Override
    public Optional<Book> selectBookById(UUID id) {
        return DB.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    @Override
    public int deleteBookById(UUID id) {
        Optional<Book> bookMaybe = selectBookById(id);
        if (bookMaybe.isEmpty() ){
            return 0;
        }
        DB.remove(bookMaybe.get());
        return 1;
    }

    @Override
    public int updateBookById(UUID id, Book update) {
        return selectBookById(id).map(book -> {
            int indexOfBookToUpdate = DB.indexOf(book);
            if (indexOfBookToUpdate >= 0) {
                DB.set(indexOfBookToUpdate, new Book(id, update.getTitle(), update.getAuthor(), update.getGenre()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }
}
