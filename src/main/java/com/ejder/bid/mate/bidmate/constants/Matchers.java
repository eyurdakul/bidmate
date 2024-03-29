package com.ejder.bid.mate.bidmate.constants;

public enum Matchers {

    BASE_MATCHER("/**"),
    USER_MATCHER("/user/**"),
    ADMIN_MATCHER("/admin/**"),

    BASE_API_MATCHER("/public/api/**");

    public final String matcher;

    Matchers(String matcher){
        this.matcher = matcher;
    }
}
