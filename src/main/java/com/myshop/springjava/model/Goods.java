package com.myshop.springjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    @NotBlank
    private String article;
    @Column(nullable = false)
    @NotBlank
    private String title;
    @Column(nullable = false)
    @NotNull
    private int quantity;
    @Column(length = 500)
    private String description;
    @Column(nullable = false)
    @Positive
    private float price;
    @Column(nullable = false)
    @NotBlank
    private String category;
    @Column(nullable = false)
    @NotBlank
    private String subcategory;
    @Column(length = 500)
    private String image;

}
