package com.ejder.bid.mate.bidmate.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private Integer userid;
    @NotNull
    private String street;
    @NotNull
    private String number;
    @NotNull
    private String postcode;
    @NotNull
    private String city;
    @NotNull
    private String country;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;
}
