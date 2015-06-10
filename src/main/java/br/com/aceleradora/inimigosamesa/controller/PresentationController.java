package br.com.aceleradora.inimigosamesa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PresentationController {

    @RequestMapping("/home")
    public String index(){
        System.out.println("Index");
        return "index";
    }

    public String info(){
        System.out.println("Info");
        return "info";
    }

    @RequestMapping("/error")
    public String error(){
        System.out.println("Error");
        return "error";
    }
}
