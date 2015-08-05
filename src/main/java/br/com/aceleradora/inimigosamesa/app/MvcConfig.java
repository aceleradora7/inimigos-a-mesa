package br.com.aceleradora.inimigosamesa.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addViewControllers(ViewControllerRegistry registro) {
        registro.addViewController("/grid").setViewName("grid");
        registro.addViewController("/home").setViewName("home");
        registro.addViewController("/").setViewName("home");
        registro.addViewController("/login").setViewName("login");
    }

}
