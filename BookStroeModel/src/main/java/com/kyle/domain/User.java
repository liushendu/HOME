package com.kyle.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DecimalFormat;

@Data
@Entity
@Table(name="users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    private Integer bsid;
    private String uname;
    private String uphone;
    private String uemail;
    private Integer ustatus;
    private Integer uvip;
    private Integer ugender;
    private String upassword;
    private String upic;
    private String uface;
    private Integer uticket;


}
