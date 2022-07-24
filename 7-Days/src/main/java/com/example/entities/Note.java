package com.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nid;

    @Length(message = "Başlık min 3 max 30 ", min = 3, max = 30)
    @NotBlank(message = "Başlık boş olamaz")
    private String title;

    @NotBlank(message = "Detay boş olamaz")
    private String detail;

}
