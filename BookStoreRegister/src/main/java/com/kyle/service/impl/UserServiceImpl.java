package com.kyle.service.impl;

import com.kyle.dao.UserRespository;
import com.kyle.domain.User;
import com.kyle.response.ResponseUser;
import com.kyle.service.UserService;
import com.kyle.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRespository userRespository;
    @Override
    public ResponseUser selectAllU(Integer page, Integer size) {
        Pageable pages = PageRequest.of(page - 1, size);
        Page<User> all = userRespository.findAll(pages);
        ResponseUser res = new ResponseUser();
        res.setList(all.getContent());
        res.setTotal(all.getTotalElements());
        return res;
    }
    public User save(User user) {
        String password=user.getUpassword();
        String password1 =Md5Utils.encryptPassword(password,"likun");
        user.setUpassword(password1);
        User save=userRespository.save(user);
        return save;
    }
    public User saveU(User user) {
        User save=userRespository.save(user);
        return save;
    }
    @Override
    public User findByUname(String uname) {
        return userRespository.findByUname(uname);
    }
    public List<User> selectAllU() {
        return userRespository.findAll();
    }


    @Override
    public void delete(Integer uid) {
        userRespository.deleteById(uid);
    }

    @Override
    public User selectOne(Integer uid) {
        Optional<User> byId = userRespository.findById(uid);
        User user=byId.get();
        return user;
    }
}
