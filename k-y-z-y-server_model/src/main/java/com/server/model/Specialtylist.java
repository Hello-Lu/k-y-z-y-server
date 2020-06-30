package com.server.model;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@ToString
@Entity
@Table(name="specialist")
public class Specialtylist implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Id;
    private String name;
    private String age;
    private String sex;
    private String phone;
    private String specialty;
}
