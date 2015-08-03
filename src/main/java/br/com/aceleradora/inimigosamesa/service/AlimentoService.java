package br.com.aceleradora.inimigosamesa.service;

import br.com.aceleradora.inimigosamesa.dao.AlimentoRepository;
import br.com.aceleradora.inimigosamesa.model.Alimento;
import br.com.aceleradora.inimigosamesa.model.Categoria;
import br.com.aceleradora.inimigosamesa.model.Legenda;
import br.com.aceleradora.inimigosamesa.model.MedidasVisuais;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AlimentoService {
    private static final String CORINGA_ALL = "%";
    private static final String CORINGA_REPLACE = "_";
    private static final int ITENS_POR_PAGINA = 12;

    @Autowired
    private AlimentoRepository repositorioAlimento;

    public Alimento buscaPorCodigo(int codigo) {
        return repositorioAlimento.findOne(codigo);
    }

    public Iterable<Alimento> buscaPorNome(String nome) {
        nome = nome.concat(CORINGA_ALL);
        return repositorioAlimento.findByNome(nome);
    }

    public Iterable<Alimento> buscaPorNome(String nome, int pagina) {
        nome = nome.concat(CORINGA_ALL);
        return repositorioAlimento.findByNome(nome, paginacao(pagina));
    }

    public Iterable<Alimento> buscaPorNomeNaCategoria(String nome, int categoria, int pagina) {
        nome = nome.concat(CORINGA_ALL);
        return repositorioAlimento.findByNomeNaCategoria(nome, categoria,paginacao(pagina));
    }

    public Iterable<Alimento> buscaPorCategoria(int pagina, int codigoCategoria) {
        return repositorioAlimento.findByCategoria(new Categoria(codigoCategoria), paginacao(pagina));
    }

    public Iterable<Alimento> buscaTodos(int pagina) {
        return repositorioAlimento.findAll(paginacao(pagina));
    }

    public void salvar(Alimento alimento) {
        if(alimento.getCodigo() != 0) {
            Alimento alimentoBuscado = repositorioAlimento.findOne(alimento.getCodigo());

            if (!alimento.getUrlImagemGrande().isEmpty()) {
                deletarCloudinaryAImagem(alimentoBuscado);
            }
        }
        repositorioAlimento.save(alimento);
    }

    private void deletarCloudinaryAImagem(Alimento alimentoBuscado) {
        Cloudinary cloudinary = new Cloudinary(Cloudinary.asMap("cloud_name", "dq5mndrjt",
                "api_key", "157778992886617",
                "api_secret", "6Vk3ZiE8qBH4K2j51agKhmH_DL8"));
        String idDaImagem = pegaIdDaImagem(alimentoBuscado);

        try {
            cloudinary.uploader().destroy(idDaImagem, ObjectUtils.emptyMap());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String pegaIdDaImagem (Alimento alimento) {
        String[] url = alimento.getUrlImagemGrande().split("/");
        String imagemComExtensao = url[url.length-1];
        String imagemSemExtensao = imagemComExtensao.split("\\.")[0];
        System.out.println(imagemSemExtensao);
        return imagemSemExtensao;
    }

    public void deletar(Alimento alimento) {
        repositorioAlimento.delete(alimento);
    }

    private PageRequest paginacao(int paginaAtual) {
        return new PageRequest(paginaAtual - 1, ITENS_POR_PAGINA, Sort.Direction.fromString("ASC"), "nome");
    }

    public MedidasVisuais getMedidasVisuais(Alimento alimento) {
        return new MedidasVisuais(alimento);
    }

    public Legenda getLegendas(Alimento alimento) {
        return new Legenda(alimento);
    }

}