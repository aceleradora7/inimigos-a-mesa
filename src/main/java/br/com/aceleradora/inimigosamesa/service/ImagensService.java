package br.com.aceleradora.inimigosamesa.service;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class ImagensService {

    public ImagensService() {}

    public void uploadImagem(){

    String file = "//home//aluno05//IdeaProjects//inimigos-a-mesa//src//main//resources//static//img//frutas//abacaxi.png";
        String nomeArquivo = file.trim();
        String nomeArquivoCloud = "";
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dq5mndrjt",
                "api_key", "157778992886617",
                "api_secret", "6Vk3ZiE8qBH4K2j51agKhmH_DL8"));

        try {
        cloudinary.uploader().upload(file, ObjectUtils.emptyMap());

    } catch (IOException e) {
        e.printStackTrace();
        }
    }
}






