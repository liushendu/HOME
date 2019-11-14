package com.kyle.service;


import com.kyle.domain.Admin;

public interface AdminService {
    Admin findByName(String name);
}
