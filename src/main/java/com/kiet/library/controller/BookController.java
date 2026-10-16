package com.kiet.library.controller;

import com.kiet.library.model.Book;
import com.kiet.library.service.BookService;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // GET: Get all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // GET: Get book by ID
    @GetMapping("/{bookId}")
    public ResponseEntity<?> getBookById(@PathVariable int bookId) {
        Book book = bookService.getBookById(bookId);

        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Book not found"));
        }

        return ResponseEntity.ok(book);
    }

    // POST: Add a new book
    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book addedBook = bookService.addBook(book);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(addedBook);
    }

    // PUT: Update an existing book
    @PutMapping("/{bookId}")
    public ResponseEntity<?> updateBook(
            @PathVariable int bookId,
            @RequestBody Book updatedBook) {

        Book book = bookService.updateBook(bookId, updatedBook);

        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Book not found"));
        }

        return ResponseEntity.ok(book);
    }

    // DELETE: Delete a book
    @DeleteMapping("/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable int bookId) {
        boolean deleted = bookService.deleteBook(bookId);

        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Book not found"));
        }

        return ResponseEntity.ok(
                Map.of("message", "Book deleted successfully"));
    }

    // GET: Search books by category
    @GetMapping("/search")
    public List<Book> searchByCategory(
            @RequestParam String category) {

        return bookService.searchByCategory(category);
    }

    // GET: Find books published from a given year
    @GetMapping("/published")
    public List<Book> findPublishedFromYear(
            @RequestParam int fromYear) {

        return bookService.findPublishedFromYear(fromYear);
    }
}