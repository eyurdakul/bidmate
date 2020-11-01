package com.ejder.bid.mate.bidmate.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private String name;
    private String description;
}
