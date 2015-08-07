//<![CDATA[

function associarEventosMenuCategoria(){
    var menuCategorias = $("#menu-categoria");
    menuCategorias.on("click", ".categoria", onClickBotaoCategoria);
};

function onClickBotaoCategoria(){
    var categoria = $(this).val();
    setParametro("categoria", categoria);
    removerParametro("busca");
    removerParametro("pagina");
    acessarPaginaComParametros("grid");
};

function marcaBotaoCategoriaAtual(){
    var categorias = $("#menu-categoria");
    var botoesCategorias = categorias.find(".categoria").each(function(){
        if($(this).val() === getParametros()["categoria"]){
            $(this).toggleClass("categoria-atual");
            $(this).on("click", function(){return false;});
        }
    });
}

function marcaBotaoLetraAtual(){
    var letras = $("#menu-busca-letra");
    var botoesLetras = letras.find(".buscaLetra").each(function(){
        if($(this).val() === getParametros()["busca"]){
            $(this).toggleClass("buscaLetra-atual");
            $(this).on("click", function(){return false;});
        }
    });
}

$(document).ready(function(){
    associarEventosMenuCategoria();
    marcaBotaoCategoriaAtual();
    marcaBotaoLetraAtual();
});

//]]>