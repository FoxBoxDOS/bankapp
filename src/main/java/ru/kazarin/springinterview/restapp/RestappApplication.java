package ru.kazarin.springinterview.restapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;



@EntityScan(basePackageClasses = {ru.kazarin.springinterview.restapp.model.BankAccount.class})
@SpringBootApplication
public class RestappApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestappApplication.class, args);
    }

}
