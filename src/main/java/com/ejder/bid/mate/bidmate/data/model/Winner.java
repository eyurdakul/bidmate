package com.ejder.bid.mate.bidmate.data.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Winner {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank
    private Integer auctionid;
    @NotBlank
    private Integer userid;
    private String trackingcode;
    @ColumnDefault(value = "1")
    private String status;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;
}
