package br.com.aceleradora.inimigosamesa.dao;

public class Consultas {

    public class Alimento{
        public static final String FIND_BY_NOME = "SELECT a FROM alimento a WHERE UPPER(UNACCENT(nome)) LIKE UPPER(UNACCENT(:nome))";
        public static final String FIND_BY_NOME_NA_CATEGORIA = "SELECT a FROM alimento a WHERE cod_categoria = :categoria AND UPPER(UNACCENT(nome)) LIKE UPPER(UNACCENT(:nome))";
    }
    public class Categoria{
        public static final String FIND_BY_NOME = "SELECT a FROM categoria a WHERE UPPER(UNACCENT(nome)) LIKE UPPER(UNACCENT(:nome))";
    }

    public class Usuario {
        public static final String FIND_BY_NOME = "SELECT a FROM usuario a WHERE UPPER(UNACCENT(nome)) LIKE UPPER(UNACCENT(:nome))";
    }
}
