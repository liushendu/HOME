package com.kyle.service.impl;

import com.kyle.dao.AdminRespository;
import com.kyle.domain.Admin;
import com.kyle.service.AdminService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    AdminRespository adminRespository;
    @Override
    public Admin findByName(String name) {
        return adminRespository.findByName(name);
    }
}
