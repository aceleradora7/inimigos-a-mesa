package br.com.aceleradora.inimigosamesa.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.aceleradora.inimigosamesa"})
@EnableJpaRepositories(basePackages = {"br.com.aceleradora.inimigosamesa"})
@EntityScan(basePackages = {"br.com.aceleradora.inimigosamesa"})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
