package com.kyle.service;


import com.kyle.domain.Author;
import com.kyle.response.ResponseAuthor;

public interface AuthorService {
    ResponseAuthor selectAllS(Integer page, Integer size);
    Author saveS(Author author);
    void deleteS(Integer aid);
    Author selectOneS(Integer aid);
    Author save(Author author);
    Author findByUname(String uname);
    Author findByAname(String aname);
}
