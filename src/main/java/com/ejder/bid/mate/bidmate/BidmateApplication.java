package com.ejder.bid.mate.bidmate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class BidmateApplication {

    public static void main(String[] args) {
        SpringApplication.run(BidmateApplication.class, args);
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "hello!";
    }
}
