package com.library.repo;

 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAvailable(boolean available);
    Book findByIsbn(String isbn);
	List<Book> findByTitleContainingOrAuthorContaining(String query, String query2);
}
