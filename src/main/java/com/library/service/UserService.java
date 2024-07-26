package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.BorrowedBook;
import com.library.entity.User;
import com.library.repo.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<BorrowedBook> getBorrowedBooksByUser(Long id) {
        User user = getUserById(id);
        return user.getBorrowedBooks();
    }
}
