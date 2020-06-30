package com.server.model;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@ToString
@Entity
@Table(name="recipe")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Recipe implements Serializable {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String recipeid;
    private String category;
    private String message;
}
