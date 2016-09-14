package com.xmc.nju.software.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xmc1993 on 16/9/14.
 */
@Data
public class User implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private Date createTime;
    private Date updateTime;
}
