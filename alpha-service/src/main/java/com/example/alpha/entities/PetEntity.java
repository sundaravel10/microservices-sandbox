package com.example.alpha.entities;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity(name = "pet")
@Data
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private PersonEntity person;
}
