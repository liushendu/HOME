package com.kyle.controller;

import com.kyle.client.UserClient;
import com.kyle.domain.Author;
import com.kyle.domain.User;
import com.kyle.request.UserCode;
import com.kyle.service.AuthorService;
import com.kyle.service.CodeService;
import com.kyle.service.UserService;
import com.kyle.utils.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RegisterController {
    @Resource
    private UserService userService;
    @Resource
    private EmailUtils emailUtils;
    @Resource
    private CodeService codeService;
    @Resource
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private UserClient userClient;
    @Autowired
    private AuthorService authorService;

    //邮箱激活
    @RequestMapping(value = "/sendEmail/{id}")
    public String valditeuser(@PathVariable("id") Integer id){
        System.out.println(id);
        //通过id进行修改状态
        User user1 = userClient.selectOne(id);
        user1.setUstatus(1);
        userClient.saveAndFlush(user1);
        return "恭喜您激活成功，请快去登陆吧^-^!";
    }

    //用户注册
    @RequestMapping("/register")
    public String register(@RequestBody UserCode userCode){
        String msg="";
        User user=userCode.getUser();
        user.setUstatus(0);
        String uname=user.getUname();
        if (userService.findByUname(uname)!=null){
            msg="用户名已存在";
            return msg;
        }
        userService.save(user);
        emailUtils.sendEmail(user.getUid());
        return "success";
    }
    //作者注册
    @RequestMapping("/authorRegister")
    public String register(@RequestBody Author author){
        String msg="";
        String name=author.getAname();
        if (authorService.findByAname(name)!=null){
            msg="用户名已存在";
            return msg;
        } else {
            authorService.save(author);
            return "success";
        }
    }


}
