package com.kyle.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name="author")
public class Author  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aid;
    private String aname;
    private String aphone;
    private String aemail;
    private Integer astatus;
    private String apic;
    private String awallet;
    private String apassword;
}
