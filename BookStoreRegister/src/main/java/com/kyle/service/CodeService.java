package com.kyle.service;


import com.kyle.domain.User;

public interface CodeService {

    int sendTo(User user, String code); //生成验证码
}
