package com.example.alpha.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.ZonedDateTime;

@Entity(name = "portfolio")
@Data
public class PortfolioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "company_code")
    private String companyCode;

    @Min(value = 0)
    @Column(name = "quantity")
    private Integer quantity;

    @Min(value = 0)
    @Column(name = "avg_buy_price")
    private Double averagePrice;

    @Column(name = "created_date")
    private ZonedDateTime createdDate;

    @Column(name = "updated_date")
    private ZonedDateTime updatedDate;

}
