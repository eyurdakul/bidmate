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
public class Offer {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank
    private Integer auctionid;
    @NotBlank
    private Integer userid;
    @ColumnDefault("false")
    private Boolean automated;
    @ColumnDefault("0")
    private BigDecimal amount;
    @CreationTimestamp
    private LocalDateTime created;
}
