package com.server.model;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@Entity
@Table(name="comments")
public class Comments implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(length = 11)
    private Integer id;
    private Integer parentid;
    private Integer type;
    @Column(name = "fromuser")
    private Integer fromUser;
    @Column(name = "touser")
    private Integer toUser;
    private String comment;
    private String create_time;

}
