package br.com.aceleradora.inimigosamesa.service;

import br.com.aceleradora.inimigosamesa.dao.AlimentoRepository;
import br.com.aceleradora.inimigosamesa.model.Alimento;
import br.com.aceleradora.inimigosamesa.model.Categoria;
import br.com.aceleradora.inimigosamesa.model.Legenda;
import br.com.aceleradora.inimigosamesa.model.MedidasVisuais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AlimentoService{
    private static final String CORINGA_ALL = "%";
    private static final String CORINGA_REPLACE = "_";
    private static final int ITENS_POR_PAGINA = 12;

    @Autowired
    private AlimentoRepository repositorioAlimento;

    public Alimento buscaPorCodigo(int codigo){
        return repositorioAlimento.findOne(codigo);
    }

    public Iterable<Alimento> buscaPorNome(String nome){
        nome = nome.concat(CORINGA_ALL);
        return repositorioAlimento.findByNome(nome);
    }

    public Iterable<Alimento> buscaPorNome(String nome, int pagina, String tipoDeOrdenacao) {
        nome = nome.concat(CORINGA_ALL);
        return repositorioAlimento.findByNome(nome, paginacao(pagina, tipoDeOrdenacao));
    }

    public Iterable<Alimento> buscaPorCategoria(int pagina, int codigoCategoria, String tipoDeOrdenacao){
        return repositorioAlimento.findByCategoria(new Categoria(codigoCategoria), paginacao(pagina, tipoDeOrdenacao));
    }

    public Iterable<Alimento> buscaTodos(int pagina, String tipoDeOrdenacao){
        return repositorioAlimento.findAll(paginacao(pagina, tipoDeOrdenacao));
    }

    public void salvar(Alimento alimento){
        repositorioAlimento.save(alimento);
    }

    public void deletar(Alimento alimento){
        repositorioAlimento.delete(alimento);
    }

    private PageRequest paginacao(int paginaAtual, String tipoDeOrdenacao){
        return new PageRequest(paginaAtual - 1, ITENS_POR_PAGINA, Sort.Direction.fromString(tipoDeOrdenacao), "nome");
    }

    public MedidasVisuais getMedidasVisuais(Alimento alimento) {
        return new MedidasVisuais(alimento);
    }

    public Legenda getLegendas(Alimento alimento){
        return new Legenda(alimento);
    }

}