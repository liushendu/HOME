package com.kyle.domain;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

@Data

public class Code implements Serializable {

    private Integer id;
    private String uemail;
    private String code;
    @Column(name = "createtime")
   // @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    private Integer status;  //状态码，1 有效，0 失效

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Code{" +
                "id=" + id +
                ", uemail='" + uemail + '\'' +
                ", code='" + code + '\'' +
                ", createTime=" + createTime +
                ", status=" + status +
                '}';
    }
}
