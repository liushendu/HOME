package com.kyle.client;

import com.kyle.domain.User;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "bookstoreuser",fallback = ErrorMessage.class)
public interface UserClient {
    @RequestMapping("/saveU")
    public void saveAndFlush(@RequestBody User user);

    @RequestMapping("/selectOneU")
    public User selectOne(@RequestParam("uid") Integer uid);
}
