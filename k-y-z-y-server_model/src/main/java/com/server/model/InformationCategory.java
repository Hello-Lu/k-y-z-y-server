package com.server.model;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@ToString
@Entity
@Table(name="message_yangsheng")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class InformationCategory implements Serializable {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String ysid;
    private String category;
    private String message;
}
