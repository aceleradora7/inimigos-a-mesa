function onClickOpcaoDeOrdenacao(){
    setParametro("opcao-ordenar" , $(this).val());
    acessarPaginaComParametros("lista");
}

function onClickBotaoCategoria(){
    var categoria = $(this).val();
    setParametro("categoria", categoria);
    removerParametro("busca");
    acessarPaginaComParametros("lista");
};


function associarEventosMenuCategoria(){
    var menuCategorias = $("#menu-categoria");
    var botoesMenuCategoria = menuCategorias.find(".btn");

    botoesMenuCategoria.each(function(){
        $(this).on("click", onClickBotaoCategoria);
    });
};

function associarEventosOpcaoDeOrdenacao(){
    var selectDeOrdenacao = $("#select-ordenacao");
    selectDeOrdenacao.find("option").each(function(){
        $(this).on("click", onClickOpcaoDeOrdenacao);
    });
}

function associarEventos(){
    associarEventosMenuCategoria();
    associarEventosOpcaoDeOrdenacao();
};

$(document).ready(function(){

    var parametros = getParametros();

    if(parametros["opcao-ordenar"] != undefined){
        $("#select-ordenacao").val(parametros["opcao-ordenar"]);
    }

    associarEventos();
});
