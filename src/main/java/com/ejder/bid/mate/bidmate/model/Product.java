package com.ejder.bid.mate.bidmate.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private String name;
    @NotNull
    private String description;
    @ColumnDefault("1")
    private Integer stock;
    @NotNull
    private BigDecimal price;
    @NotNull
    private Integer category;
}
