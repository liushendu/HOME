package com.kyle.client;

import com.kyle.domain.User;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by 54110 on 2019/10/17.
 */
@Component
public class ErrorMessage implements UserClient {

    @Override
    public void saveAndFlush(@RequestBody User user){
    }
    @Override
    public User selectOne (@RequestParam("uid") Integer uid){
        return null;
    }
}
