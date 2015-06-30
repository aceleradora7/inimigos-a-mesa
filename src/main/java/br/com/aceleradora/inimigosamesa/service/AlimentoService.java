package br.com.aceleradora.inimigosamesa.service;

import br.com.aceleradora.inimigosamesa.dao.AlimentoRepository;
import br.com.aceleradora.inimigosamesa.model.Alimento;
import br.com.aceleradora.inimigosamesa.model.Categoria;
import br.com.aceleradora.inimigosamesa.model.Legenda;
import br.com.aceleradora.inimigosamesa.model.MedidasVisuais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlimentoService{

    private static final String CORINGA = "%";

    @Autowired
    private AlimentoRepository repositorioAlimento;

    public Alimento buscaPorCodigo(int codigo){
        return repositorioAlimento.findOne(codigo);
    }

    public List<Alimento> buscaPorNome(String nome, String tipoDeOrdenacao){
        nome = nome.replaceAll("[ãáâêéíóú]", "_").concat(CORINGA);

        return repositorioAlimento.findByNomeLikeIgnoreCase(nome, ordenacao(tipoDeOrdenacao, "nome"));
    }

    public List<Alimento> buscaPorCategoria(int codigoCategoria, String tipoDeOrdenacao){
        return repositorioAlimento.findByCategoria(new Categoria(codigoCategoria), ordenacao(tipoDeOrdenacao, "nome"));
    }

    public List<Alimento> buscaTodos(String tipoDeOrdenacao){
        return repositorioAlimento.findAll(ordenacao(tipoDeOrdenacao, "nome"));
    }

    private Sort ordenacao(String tipoOrdenacao, String campo){
        return new Sort(Sort.Direction.fromStringOrNull(tipoOrdenacao), campo);
    }

    public MedidasVisuais getMedidasVisuais(Alimento alimento) {
        return new MedidasVisuais(alimento);
    }

    public Legenda getLegendas(Alimento alimento){
        return new Legenda(alimento);
    }
}