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
@Table(name="ReadToday")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class ReadToday implements Serializable {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String id;
    private String WatchingFocus;
    private Date create_time;
    private Date update_time;
}
