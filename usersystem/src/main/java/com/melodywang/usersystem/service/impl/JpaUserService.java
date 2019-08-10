package com.melodywang.usersystem.service.impl;

import com.melodywang.usersystem.domain.User;
import com.melodywang.usersystem.repository.UserRepository;
import com.melodywang.usersystem.service.UserService;
import com.melodywang.usersystem.util.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("JpaUserService")
public class JpaUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User save(User input) {
        input.setPassword(HashUtil.encypt(input.getPassword()));
        input.setRole("general");
        input.setStatus("success");
        User res = userRepository.save(input);
        sendEmailNotification(res);
        return res;
    }

    // User will receive email notification when he/she has registered
    public void sendEmailNotification(User user) {
        if (user.getUserName().equals("trigger")) {
            throw new RuntimeException();
        } else {
            // Call the third party APIs to send email
        }
    }

}
