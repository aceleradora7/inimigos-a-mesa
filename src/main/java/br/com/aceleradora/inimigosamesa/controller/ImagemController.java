package br.com.aceleradora.inimigosamesa.controller;
import br.com.aceleradora.inimigosamesa.service.ImagensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by aluno06 on 07/07/15.
 */
@Controller

public class ImagemController {

    @RequestMapping(value = "/teste")
    public void testaCloud(){
        ImagensService imagensservice = new ImagensService();
        imagensservice.uploadImagem();
    }
}
