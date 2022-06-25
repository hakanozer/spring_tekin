package com.works.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nid;

    @Column(unique = true)
    private String title;

    @Column(length = 500)
    private String detail;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

}


