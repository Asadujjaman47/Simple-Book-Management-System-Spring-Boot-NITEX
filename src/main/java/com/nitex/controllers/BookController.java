package com.nitex.controllers;

import com.nitex.exception.ResourceNotFoundException;
import com.nitex.models.Book;
import com.nitex.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;


    @GetMapping("/test")
    public String test() {
        return "From Book Controller";
    }

    // GET ALL BOOKS
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // GET A BOOK BY ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            throw new ResourceNotFoundException("Book", "id", id);
        }
        return book;
    }

    // SAVE BOOK
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    // EDIT BOOK
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book existingBook = bookService.getBookById(id);
        if (existingBook == null) {
            throw new ResourceNotFoundException("Book", "id", id);
        }
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        Book existingBook = bookService.getBookById(id);
        if (existingBook == null) {
            throw new ResourceNotFoundException("Book", "id", id);
        }
        bookService.deleteBook(id);
    }

}
