package com.example.alpha.entities;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity(name = "person")
@Data
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
    private List<PetEntity> pets;

}
