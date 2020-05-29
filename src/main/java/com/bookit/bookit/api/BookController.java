package com.bookit.bookit.api;

import com.bookit.bookit.model.Book;
import com.bookit.bookit.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/book")
@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public void addBook(@Valid @NotNull @RequestBody Book book) {
        bookService.addBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping(path = "{id}")
    public Book getBookById(@PathVariable("id") UUID id) {
        return bookService.getBookById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteBookByID(@PathVariable("id") UUID id) {
        bookService.deleteBook(id);
    }

    @PutMapping(path = "{id}")
    public void updateBookById(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Book bookToUpdate) {
        bookService.updateBook(id, bookToUpdate);
    }
}
