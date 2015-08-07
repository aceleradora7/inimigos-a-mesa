var params = {};

function getParametros(){
    var parametros = window.location.search;

    function getParametro(parametro){
        var nome  = parametro.split("=")[0];
        var valor = parametro.split("=")[1];
        params[nome] = valor;
    }

    if(parametros.indexOf("?") === -1){
        return params;
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
    params[nome] = valor;
}

function removerParametro(nome){
    delete params[nome];
}

function acessarPaginaComParametros(pagina){
    window.location.href = "/" + pagina + "?" + $.param(params);
}