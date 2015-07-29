package br.com.aceleradora.inimigosamesa.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addViewControllers(ViewControllerRegistry registro) {
        registro.addViewController("/grid").setViewName("grid");
        registro.addViewController("/index").setViewName("index");
        registro.addViewController("/").setViewName("index");
        registro.addViewController("/login").setViewName("login");
    }

}
