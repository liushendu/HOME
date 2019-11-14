package com.kyle.client;


import com.kyle.domain.User;
import org.springframework.stereotype.Component;

/**
 * Created by 54110 on 2019/10/17.
 */
@Component
public class ErrorMessage implements UserClient {
    @Override
    public User selectOne(Integer uid) {
        return null;
    }
}
