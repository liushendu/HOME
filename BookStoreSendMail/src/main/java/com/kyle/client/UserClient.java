package com.kyle.client;


import com.kyle.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "bookstoreuser",fallback = ErrorMessage.class)
public interface UserClient {

    @GetMapping("/selectOneU")
    public User selectOne(@RequestParam("uid") Integer uid);
}
