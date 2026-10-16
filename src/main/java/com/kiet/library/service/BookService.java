package com.kiet.library.service;

import com.kiet.library.model.Book;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();

    // Initialize sample books
    public BookService() {
        books.add(new Book(201, "Effective Java",
                "Joshua Bloch", "Programming", 2018, true));
        
        books.add(new Book(202, "Clean Code",
                "Robert C. Martin", "Programming", 2008, true));

        books.add(new Book(203, "The Alchemist",
                "Paulo Coelho", "Fiction", 1988, false));

        books.add(new Book(204, "Introduction to Algorithms",
                "Thomas H. Cormen", "Computer Science", 2022, true));

        books.add(new Book(205, "Wings of Fire",
                "A. P. J. Abdul Kalam", "Biography", 1999, true));
}

    // Get all books
    public List<Book> getAllBooks() {
        return books;
    }

    // Get book by ID
    public Book getBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }

        return null;
    }

    // Add a new book
    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    // Update a book
    public Book updateBook(int bookId, Book updatedBook) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {

                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                book.setCategory(updatedBook.getCategory());
                book.setPublicationYear(
                        updatedBook.getPublicationYear());
                book.setAvailable(updatedBook.isAvailable());

                return book;
            }
        }

        return null;
    }

    // Delete a book
    public boolean deleteBook(int bookId) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookId() == bookId) {
                books.remove(i);
                return true;
            }
        }

        return false;
    }

    // Search books by category
    public List<Book> searchByCategory(String category) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getCategory().equalsIgnoreCase(category)) {
                result.add(book);
            }
        }

        return result;
    }

    // Find books published from a given year
    public List<Book> findPublishedFromYear(int fromYear) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getPublicationYear() >= fromYear) {
                result.add(book);
            }
        }

        return result;
    }
}