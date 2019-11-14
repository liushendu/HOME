package com.kyle.service.impl;


import com.kyle.domain.Code;
import com.kyle.domain.User;
import com.kyle.mapper.CodeRepository;
import com.kyle.service.CodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class CodeServiceImpl implements CodeService {

    @Resource
    private CodeRepository codeRepository;

    @Override
    public int sendTo(User user, String code) {
        String uemail = user.getUemail();
        Code co = codeRepository.findByUemail(uemail);
        Date createTime = co.getCreateTime();
        Date nowTime = new Date();
        int i = nowTime.compareTo(createTime);
        System.out.println(i);
        if (i >= 600) {
            //失效
            co.setStatus(0);
            codeRepository.save(co);
            return 2;
        } else {
            if (co.getCode().equals(code)) {
                co.setStatus(0);
                codeRepository.update(co);
                return 1;
            } else {

                return 3;
            }
        }
        // return 1;
    }
    }



