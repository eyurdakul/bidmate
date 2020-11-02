package com.ejder.bid.mate.bidmate.data.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @ColumnDefault("1")
    private Integer stock;
    @NotBlank
    private BigDecimal price;
    @NotBlank
    private Integer category;
    @CreationTimestamp
    private LocalDateTime created;
}
