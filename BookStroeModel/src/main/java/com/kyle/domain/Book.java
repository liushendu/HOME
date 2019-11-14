package com.kyle.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name="book")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bid;
    private Integer cid;
    private Integer aid;
    private String bname;
    private String introduce;
    private Integer nummoney;
    private Integer scount;
    private String bpic;
    private Integer bprice;
}
