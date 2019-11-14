package com.kyle.dao;

import com.kyle.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRespository extends JpaRepository<Admin,Integer> {
    Admin findByName(String name);
}
