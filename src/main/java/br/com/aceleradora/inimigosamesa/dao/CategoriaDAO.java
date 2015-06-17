package br.com.aceleradora.inimigosamesa.dao;


import br.com.aceleradora.inimigosamesa.model.Categoria;

import java.util.List;
import java.util.ArrayList;

public class CategoriaDAO {
    public List<Categoria> categorias = new ArrayList<Categoria>();


    public CategoriaDAO() {
        categorias.add(new Categoria(0, "Cereais"));
        categorias.add(new Categoria(1, "Frutas"));
        categorias.add(new Categoria(2, "Verduras"));
        categorias.add(new Categoria(3, "Legumes"));
        categorias.add(new Categoria(4, "Carnes"));
        categorias.add(new Categoria(5, "Laticínios"));
        categorias.add(new Categoria(6, "Doces/Gorduras"));
        categorias.add(new Categoria(7, "Bebidas"));

    }

    public List<Categoria> find(Categoria categoria) {
        List<Categoria> lista = new ArrayList<Categoria>();
        if (categoria.getNomeCategoria().equals("")) {
            return lista;
        } else {
            for (Categoria a : categorias) {
                if (a.getNomeCategoria().toLowerCase().equals(categoria.getNomeCategoria().toLowerCase())) {
                    lista.add(a);
                }
            }
        }
        return lista;
    }


}
