package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.entity.Book;
import com.library.service.BookService;


@RestController
@RequestMapping("/api/books")
public class BookController {
 @Autowired
 private BookService bookService;
 
 @GetMapping
 public List<Book> getAllBooks() {
     return bookService.getAllBooks();
 }
 
 @GetMapping("/available")
 public List<Book> getAvailableBooks() {
     return bookService.getAvailableBooks();
 }
 
 @GetMapping("/{isbn}")
 public Book getBookByIsbn(@PathVariable String isbn) {
     return bookService.getBookByIsbn(isbn);
 }
 
 @PostMapping("/borrow")
 public void borrowBook(@RequestParam Long userId, @RequestParam Long bookId) {
     bookService.borrowBook(userId, bookId);
 }
 
 @PostMapping("/return")
 public void returnBook(@RequestParam Long userId, @RequestParam Long bookId) {
     bookService.returnBook(userId, bookId);
 }
}