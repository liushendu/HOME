package com.kyle.controller;

import com.kyle.domain.Admin;
import com.kyle.domain.Author;
import com.kyle.domain.User;
import com.kyle.enums.LoginType;
import com.kyle.service.AdminService;
import com.kyle.service.AuthorService;
import com.kyle.service.UserService;
import com.kyle.shiro.CustomizedToken;
import org.apache.shiro.SecurityUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    private static final String USER_LOGIN_TYPE = LoginType.USER.toString();
    private static final String AUTHOR_LOGIN_TYPE = LoginType.AUTHOR.toString();
    private static final String ADMIN_LOGIN_TYPE = LoginType.ADMINS.toString();
    @Resource
    private UserService userService;
    @Resource
    private AuthorService authorService;
    @Resource
    private AdminService adminService;
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    /*
     * 登录
     */
    @RequestMapping("/login")
    public String login(@RequestBody User user, HttpSession session){
        String name= user.getUname();
        String password=user.getUpassword();
        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();

        CustomizedToken token = new CustomizedToken(name, password,USER_LOGIN_TYPE);
        try{
            subject.login(token);
            if (subject.isAuthenticated()){
                User checkuser = userService.findByUname(name);
                session.setAttribute("user",checkuser);
                redisTemplate.opsForValue().set("user",checkuser);
                return "success";
            }else {
                return "fail";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "null";
    }
    @RequestMapping("/findSession")
    public User findSession(HttpSession session){
        Object user = redisTemplate.opsForValue().get("user");
        User user1=(User)user;

        return user1;
    }
    @RequestMapping("/findAuthor")
    public Author findAuthor(HttpSession session){
        Object author=redisTemplate.opsForValue().get("author");
        Author author1=(Author)author;
        return author1;
    }
    @RequestMapping("/findAdmin")
    public Admin findAdmin(HttpSession session){
        Object admin=redisTemplate.opsForValue().get("admin");
        Admin admin1=(Admin)admin;
        return admin1;
    }
    @RequestMapping("/logout")
    public String logout(){

        redisTemplate.delete("user");
        return "1";
    }
    @RequestMapping("/adminlogout")
    public String adminlogout(){

        redisTemplate.delete("admin");
        return "1";
    }
    @RequestMapping("/authorlogout")
    public String shoperlogout(){

        redisTemplate.delete("author");
        return "1";
    }
    //作者登录
    @RequestMapping("/authorlogin")
    public String shoperlogin(@RequestBody Author author, HttpSession session){
        String name= author.getAname();
        String password=author.getApassword();
        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();

        CustomizedToken token = new CustomizedToken(name, password,AUTHOR_LOGIN_TYPE);
        try{
            subject.login(token);
            if (subject.isAuthenticated()){
                Author checkuser = author;

                session.setAttribute("author",checkuser);
                redisTemplate.opsForValue().set("author",checkuser);
                return "success";
            }else {
                return "fail";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "null";

    }
    //管理员登陆
    @RequestMapping("/adminlogin")
    public String adminlogin(@RequestBody Admin admin, HttpSession session){
        String name= admin.getName();
        String password=admin.getPassword();
        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();

        CustomizedToken token = new CustomizedToken(name, password,ADMIN_LOGIN_TYPE);
        try{
            subject.login(token);
            if (subject.isAuthenticated()){
                Admin checkuser = adminService.findByName(name);
                session.setAttribute("admin",checkuser);
                redisTemplate.opsForValue().set("admin",checkuser);


                return "success";
            }else {
                return "fail";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "null";
    }

}
