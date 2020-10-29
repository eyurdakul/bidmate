package com.ejder.bid.mate.bidmate.common;

public enum Paths {

    //admin paths
    ADMIN_LOGIN("/authenticate", "public/authenticate"),
    ADMIN_PROCESS("/admin/authenticate/process", null),
    ADMIN_DASHBOARD("/admin/dashboard", "admin/dashboard"),

    //user paths
    USER_LOGIN("/login", "public/login"),
    USER_PROCESS("/user/login/process", null),
    USER_MY("/user/my", "user/my"),
    USER_BUY("/user/buy", "user/buy"),

    //public paths
    HOME("/", "public/home"),
    LOGOUT("/logout", null),
    REGISTER("/register", "public/register"),
    TERMS("/terms", "public/terms"),
    PRODUCT("/product", "public/product"),
    CONTACT("/contact", "public/contact"),
    NO_ACCESS("/access/denied", "403");

    public final String path;
    public final String view;

    Paths(String path, String view){
        this.path = path;
        this.view = view;
    }
}
