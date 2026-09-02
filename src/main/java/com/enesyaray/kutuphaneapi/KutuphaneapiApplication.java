package com.enesyaray.kutuphaneapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.enesyaray"})
public class KutuphaneapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(KutuphaneapiApplication.class, args);
    }

}
