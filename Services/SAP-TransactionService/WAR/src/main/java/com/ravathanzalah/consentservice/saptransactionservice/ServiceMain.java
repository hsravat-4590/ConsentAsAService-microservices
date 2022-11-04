package com.ravathanzalah.consentservice.saptransactionservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ravathanzalah.consentservice.saptransactionservice.*")
public class ServiceMain {

    public static void main(String[] args) {
        SpringApplication.run(ServiceMain.class, args);
    }

}
