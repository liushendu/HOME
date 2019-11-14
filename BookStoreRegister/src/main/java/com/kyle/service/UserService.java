package com.kyle.service;


import com.kyle.domain.User;
import com.kyle.response.ResponseUser;

public interface UserService {
    ResponseUser selectAllU(Integer page, Integer size);
    User save(User user);
    User saveU(User user);
    void delete(Integer uid);
    User selectOne(Integer uid);
    User findByUname(String uname);
}
