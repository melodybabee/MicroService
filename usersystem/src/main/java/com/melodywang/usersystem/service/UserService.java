package com.melodywang.usersystem.service;

import com.melodywang.usersystem.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findById(Long id);
    User save(User input);
}

