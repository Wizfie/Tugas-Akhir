package com.example.tugas_akhir.tugas_akhir.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.tugas_akhir.tugas_akhir.model.User;
import com.example.tugas_akhir.tugas_akhir.repository.IUserRepository;

@Repository
public class UserRepository implements IUserRepository{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public User insertUser(User user) {
        // TODO Auto-generated method stub
        String query = "INSERT INTO tb_user(email,nama,password) VALUES(?,?,?)";
        jdbcTemplate.update(query, new Object[] {user.getEmail(),user.getNama(),user.getPassword()});
        return user;
    }

    @Override
    public User login(User user) {
        String query = "SELECT * FROM tb_user WHERE email = ? AND password = ?";
        var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(User.class),new Object[]{
            user.getEmail(),user.getPassword()
        });
        return result;

  

}
}