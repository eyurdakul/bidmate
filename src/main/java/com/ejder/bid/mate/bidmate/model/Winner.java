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
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Winner {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private Integer auctionid;
    @NotNull
    private Integer userid;
    private String trackingcode;
    @ColumnDefault("pending")
    private String status;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;
}
