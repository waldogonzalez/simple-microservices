package com.krah.spik.serviceone;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Service One", version = "1.0", description = "Documentation Service One v1.0"))
public class ServiceOneApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceOneApplication.class, args);
    }
}
