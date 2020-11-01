package com.ejder.bid.mate.bidmate.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Offer {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private Integer auctionid;
    @NotNull
    private Integer userid;
    @ColumnDefault("false")
    private Boolean automated;
    @ColumnDefault("0")
    private BigDecimal amount;
    @CreationTimestamp
    private LocalDateTime created;
}
