package com.example.coding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class CodingApplication {

    public static void main(String[] args) {

        System.out.println((int)(Math.random() * 5));
        //SpringApplication.run(CodingApplication.class, args);
    }

}
