package com.ejder.bid.mate.bidmate.common;

public enum Matchers {

    BASE_MATCHER("/**"),
    USER_MATCHER("/user/**"),
    ADMIN_MATCHER("/admin/**");

    public final String matcher;

    Matchers(String matcher){
        this.matcher = matcher;
    }
}
