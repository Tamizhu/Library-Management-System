package com.library.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.entity.BorrowedBook;

public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, Integer> {
    List<BorrowedBook> findByUser_Id(Long id);

	BorrowedBook findByUser_IdAndBook_Id(Long userId, Long bookId);

	 
 
	 
 
}
