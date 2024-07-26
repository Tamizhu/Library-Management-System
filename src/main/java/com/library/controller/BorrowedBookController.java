package com.library.controller;

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.entity.BorrowedBook;
import com.library.service.BorrowService;

@RestController
@RequestMapping("/api/borrowed-books")
public class BorrowedBookController {

    @Autowired
    private BorrowService borrowService;

    @GetMapping
    public List<BorrowedBook> getAllBorrowedBooks() {
        return borrowService.getAllBorrowedBooks();
    }

    @PostMapping
    public BorrowedBook saveBorrowedBook(@RequestBody BorrowedBook borrowedBook) {
        return borrowService.saveBorrowedBook(borrowedBook);
    }

    @GetMapping("/{id}")
    public List<BorrowedBook> getBorrowedBooksByUser(@PathVariable Long id) {
        return borrowService.getBorrowedBooksByUser(id);
    }
}
