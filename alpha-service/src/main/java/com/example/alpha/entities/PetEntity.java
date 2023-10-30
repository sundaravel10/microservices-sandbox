package com.example.alpha.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = "pet")
@Data
@Builder
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    @ManyToOne
    private PersonEntity person;
}
