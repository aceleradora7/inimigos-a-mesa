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
    menuCategorias.on("click", ".btn", onClickBotaoCategoria);
};

function associarEventosOpcaoDeOrdenacao(){

    var selectDeOrdenacao = $("#select-ordenacao");
    selectDeOrdenacao.on("click", "option", onClickOpcaoDeOrdenacao);
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
