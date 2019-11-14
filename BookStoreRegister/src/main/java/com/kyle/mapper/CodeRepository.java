package com.kyle.mapper;


import com.kyle.domain.Code;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface CodeRepository {

    Code findByUemail(String uemail);
    int save(Code code);
    int update(Code co);
}
