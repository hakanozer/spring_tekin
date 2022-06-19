package com.works.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class Product {

    private Integer pid;

    @NotBlank(message = "Title Null or Empty")
    @Length(min = 3, max = 30, message = "Title min = 3, max = 30")
    private String title;

    @Min(value = 10, message = "Price min 10")
    @Max(value = 10000, message = "Price Max 10000")
    private Integer price;

    @NotBlank(message = "Email Null or Empty")
    @Email(message = "Email Format Fail")
    private String email;

    private Boolean status;


}
