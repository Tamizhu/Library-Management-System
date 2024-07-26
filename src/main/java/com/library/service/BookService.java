package com.library.service;

 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Book;
import com.library.entity.BorrowedBook;
import com.library.entity.User;
import com.library.repo.BookRepository;
import com.library.repo.BorrowedBookRepository;
import com.library.repo.UserRepository;

 

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BorrowedBookRepository borrowedBookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getAvailableBooks() {
        return bookRepository.findByAvailable(true);
    }

    public List<Book> searchBooks(String query) {
        return bookRepository.findByTitleContainingOrAuthorContaining(query, query);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Book getBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    public void borrowBook(Long userId, Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        if (book.isAvailable()) {
            @SuppressWarnings("unused")
			User user = userRepository.findById(userId).orElseThrow();
            BorrowedBook borrowedBook = new BorrowedBook();
            borrowedBookRepository.save(borrowedBook);
            book.setAvailable(false);
            bookRepository.save(book);
        } else {
            throw new RuntimeException("Book is not available for borrowing");
        }
    }

    public void returnBook(Long userId, Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        BorrowedBook borrowedBook = borrowedBookRepository.findByUser_IdAndBook_Id(userId, bookId);
        if (borrowedBook != null) {
            borrowedBookRepository.delete(borrowedBook);
            book.setAvailable(true);
            bookRepository.save(book);
        } else {
            throw new RuntimeException("Book is not borrowed by this user");
        }
    }
}
