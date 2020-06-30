package com.server.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 案例！！！！
 * 平时放使用的实体类的位置
 */
@Data
@ToString
@Entity
@Table(name="user")
public class User implements Serializable {

    @Id
    private String account;
    private String password;
    private Integer start;
    private Integer limits;


}
