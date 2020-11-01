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
public class Auction {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private Integer productid;
    @ColumnDefault("300")
    private Integer duration;
    @ColumnDefault("NOW()")
    private LocalDateTime scheduled;
    @ColumnDefault("SCHEDULED")
    private String status;
    @ColumnDefault("0")
    private BigDecimal lastoffer;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;
}
