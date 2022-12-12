package com.example.tugas_akhir.tugas_akhir.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tugas_akhir.tugas_akhir.model.User;
import com.example.tugas_akhir.tugas_akhir.repository.IUserRepository;
import com.example.tugas_akhir.tugas_akhir.service.IUserService;
@Service

public class UserService implements IUserService{
    @Autowired
    IUserRepository userRepository;

    @Override
    public User insertUser(User user) {
        
         return userRepository.insertUser(user);

    
    
    }   
}