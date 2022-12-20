package com.example.tugas_akhir.tugas_akhir.service;

import com.example.tugas_akhir.tugas_akhir.model.User;

public interface IUserService {
    public User insertUser(User user);

    public User login(User user);
    
    
}
