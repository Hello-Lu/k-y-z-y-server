package com.server.model;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/**
客户端用户信息表
 */
@Data
@ToString
@Entity
@Table(name="client_user")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Client_user implements Serializable {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private String name;
    private String userpic;
    private String utype;
    private Date birthday;
    private char sex;
    private String email;
    private String phone;
    private String qq;
    private String status;
    private Date create_time;
    private Date update_time;
}
