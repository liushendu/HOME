package com.kyle.controller;

import com.alibaba.fastjson.JSON;
import com.kyle.domain.User;
import com.kyle.response.ResponseUser;
import com.kyle.service.UserService;
import com.kyle.utils.UploadUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Objects;

@RestController
public class UserController {
    @Resource
    private UploadUtils uploadUtils;
    @Autowired
    private UserService userService;

    @RequestMapping("/selectAllU/{page}/{size}")
    public ResponseUser selectAll(@PathVariable Integer page, @PathVariable Integer size){
        return userService.selectAllU(page,size);
    }
    @RequestMapping("/saveU")
    public void saveU(@RequestBody User user){
        userService.saveU(user);
    }
    @RequestMapping("/saveUMd5")
    public void saveUMd5(@RequestBody User user){
        userService.save(user);
    }
    @RequestMapping("/deleteU/{uid}")
    public String delete(@PathVariable Integer uid) {
        userService.delete(uid);
        return "删除成功";
    }
    @RequestMapping("/selectOneU")
    public User selectOne (@RequestParam("uid") Integer uid){

        return userService.selectOne(uid);
    }
    @RequestMapping("/updateU")
    public String update(@RequestBody User user){
        userService.saveU(user);
        return "修改成功";
    }


    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/uploadUser")
    public String test(MultipartFile file){

        logger.debug("传入的文件参数：{}", JSON.toJSONString(file, true));
        if (Objects.isNull(file) || file.isEmpty()) {
            logger.error("文件为空");
            return "文件为空，请重新上传";
        }else {
            String path = uploadUtils.upload(file);
            System.out.println(path);
            return path;
        }
    }

}
