package com.bookit.bookit.service;

import com.bookit.bookit.dao.BookDao;
import com.bookit.bookit.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {

    private final BookDao bookDao;

    @Autowired
    public BookService(@Qualifier("postgres") BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public int addBook(Book book) {
        return bookDao.insertBook(book);
    }

    public List<Book> getAllBooks() {
        return bookDao.selectAllBooks();
    }


    public Optional<Book> getBookById(UUID id) {
        return bookDao.selectBookById(id);
    }

    public int deleteBook(UUID id) {
        return bookDao.deleteBookById(id);
    }

    public int updateBook(UUID id, Book newBook) {
        return bookDao.updateBookById(id, newBook);
    }

}
