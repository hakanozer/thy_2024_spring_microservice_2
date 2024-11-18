package com.works.entities;

import com.works.customValid.ThyCity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    @Size(min = 2, max = 100)
    @NotEmpty
    @NotNull
    private String title;

    @Size(min = 2, max = 500)
    @NotEmpty
    @NotNull
    private String description;

    @Max(1000000)
    @Min(1)
    @NotNull
    private Integer price;

    @NotNull
    @NotEmpty
    @ThyCity
    private String city;

}
