package com.kyle.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserList implements Serializable {
    Double score;
    String group_id;
    String user_id;
    String user_info;
}
