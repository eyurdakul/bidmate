package com.ejder.bid.mate.bidmate.data.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @OneToOne(mappedBy = "address")
    private User user;
    @NotBlank
    private String street;
    @NotBlank
    private String number;
    @NotBlank
    private String postcode;
    @NotBlank
    private String city;
    @NotBlank
    private String country;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;
}
