package com.kyle.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name="bookstore")
public class BookStore  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bsid;
    private Integer uid;
    private Integer bid;
}
