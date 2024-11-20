package com.works.models;

import lombok.Data;

@Data
public class Product {
    private Long pid;
    private String title;
    private String description;
    private Integer price;
    private String city;
}