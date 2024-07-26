package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.BorrowedBook;
import com.library.repo.BorrowedBookRepository;

@Service
public class BorrowService {

    @Autowired
    private BorrowedBookRepository borrowedBookRepository;

    public List<BorrowedBook> getAllBorrowedBooks() {
        return borrowedBookRepository.findAll();
    }

    public BorrowedBook saveBorrowedBook(BorrowedBook borrowedBook) {
        return borrowedBookRepository.save(borrowedBook);
    }

    public List<BorrowedBook> getBorrowedBooksByUser(Long id) {
        return borrowedBookRepository.findByUser_Id(id);
    }
}
