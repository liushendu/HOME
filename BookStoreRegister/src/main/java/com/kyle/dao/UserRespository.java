package com.kyle.dao;

import com.kyle.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<User,Integer> {
    User findByUname(String uname);
}
