package com.ejder.bid.mate.bidmate.constants;

public enum Status {

    ERROR("0"),
    PENDING("1"),
    SCHEDULED("2"),
    RUNNING("3"),
    SHIPPED("4"),
    RETURNED("5"),
    CLOSED("6"),
    CANCELLED("7");

    public final String status;

    Status(String status){
        this.status = status;
    }
}
