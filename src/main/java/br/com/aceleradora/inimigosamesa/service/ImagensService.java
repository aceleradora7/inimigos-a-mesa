package br.com.aceleradora.inimigosamesa.service;

/**
 * Created by aluno06 on 07/07/15.
 */
import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class ImagensService {

    public ImagensService() {
    }

@Autowired
    public void uploadImagem(){
        String file = "//home//aluno06//IdeaProjects//inimigos-a-mesa//src//main//java//br//com//aceleradora//inimigosamesa//model//teste.png";
        Cloudinary cloudinary = new Cloudinary("cloudinary://157778992886617:6Vk3ZiE8qBH4K2j51agKhmH_DL8@dq5mndrjt");
        try {
            cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}






