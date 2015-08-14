package br.com.aceleradora.inimigosamesa.controller;
import br.com.aceleradora.inimigosamesa.service.ImagensService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ImagemController {

    @RequestMapping(value = "/teste")
    public void testaCloud(){
        ImagensService imagensservice = new ImagensService();
        imagensservice.uploadImagem();
    }
}
