function adicionarParametroNaUrl(nome, valor){
    var parametrosUrl = window.location.search;

    if(parametrosUrl.indexOf(nome) != -1){
        console.log(parametrosUrl);
        return;
    }

    (parametrosUrl.indexOf("?") === -1)? parametrosUrl += "?" : parametrosUrl += "&";

    parametrosUrl += (nome + "=" + valor);
    return parametrosUrl;
}

function onClickOpcaoDeOrdenacao(){
     window.location.search = adicionarParametroNaUrl("opcao-ordenar" , $(this).val());
}

function onClickBotaoCategoria(){
    var categoria = $(this).val();

    window.location.search = adicionarParametroNaUrl("categoria", categoria);
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
    associarEventos();
});
