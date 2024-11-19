package com.works.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long cid;

    private String name;
    private String surname;

    @ManyToMany
    List<Address> addresses;

}
