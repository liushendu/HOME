package com.kyle.service.impl;

import com.kyle.dao.AuthorRespository;
import com.kyle.domain.Author;
import com.kyle.response.ResponseAuthor;
import com.kyle.service.AuthorService;
import com.kyle.utils.Md5Utils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Resource
    private AuthorRespository authorRespository;

    @Override
    public ResponseAuthor selectAllS(Integer page, Integer size) {
        Pageable pages = PageRequest.of(page - 1, size);
        Page<Author> all = authorRespository.findAll(pages);
        ResponseAuthor res = new ResponseAuthor();
        res.setList(all.getContent());
        res.setTotal(all.getTotalElements());
        return res;
    }

    @Override
    public Author saveS(Author author) {
        return authorRespository.save(author);
    }
    @Override
    public Author save(Author author) {
        String password=author.getApassword();
        String password1 =Md5Utils.encryptPassword(password,"likun");
       author.setApassword(password1);
       Author save=authorRespository.save(author);
        return save;
    }

    @Override
    public void deleteS(Integer aid) {
        authorRespository.deleteById(aid);
    }

    @Override
    public Author selectOneS(Integer aid) {
        Optional<Author> byId =authorRespository.findById(aid);
        Author author=byId.get();
        return author;
    }

    @Override
    public Author findByUname(String uname) {
        return authorRespository.findByAname(uname);
    }


    @Override
    public Author findByAname(String aname) {
        return authorRespository.findByAname(aname);
    }
}