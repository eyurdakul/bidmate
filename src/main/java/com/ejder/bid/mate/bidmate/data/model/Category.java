package com.ejder.bid.mate.bidmate.data.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank
    private String name;
    private String description;
    @CreationTimestamp
    private LocalDateTime created;
}
