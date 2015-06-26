function getParametros(){
    var parametros = window.location.search;
    var params = {};

    function getParametro(parametro){
        var nome  = parametro.split("=")[0];
        var valor = parametro.split("=")[1];

        params[nome] = valor;
    }

    if(parametros.indexOf("?") === -1){
        return {};
    }

    parametros = parametros.replace("?", "");

    if(parametros.indexOf("&") === -1){
        getParametro(parametros);
        return params;
    }

    var listaDeParametro = parametros.split("&");

    listaDeParametro.forEach(function(parametro){
        getParametro(parametro);
    });

    return params;
}


function setParametro(nome, valor){

    var parametrosUrl = getParametros();

    parametrosUrl[nome] = valor;

    window.location.search = $.param(parametrosUrl);
}

function onClickOpcaoDeOrdenacao(){
    setParametro("opcao-ordenar" , $(this).val());
}

function onClickBotaoCategoria(){
    var categoria = $(this).val();
    setParametro("categoria", categoria);
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
        console.log("Sim");
        $("#select-ordenacao").val(parametros["opcao-ordenar"]);
    }

    associarEventos();
});
