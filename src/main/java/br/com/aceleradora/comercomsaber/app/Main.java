package br.com.aceleradora.comercomsaber.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.aceleradora.comercomsaber"})
@EnableJpaRepositories(basePackages = {"br.com.aceleradora.comercomsaber"})
@EntityScan(basePackages = {"br.com.aceleradora.comercomsaber"})

public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
