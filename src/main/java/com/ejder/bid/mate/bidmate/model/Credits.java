package com.ejder.bid.mate.bidmate.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Credits {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private String txid;
    @NotNull
    private Integer userid;
    @ColumnDefault("0")
    private BigDecimal amount;
    @CreationTimestamp
    private LocalDateTime created;
}
