function associarEventosMenuCategoria(){
    var menuCategorias = $("#menu-categoria");
    var botoesMenuCategoria = menuCategorias.find(".btn");

    botoesMenuCategoria.each(function(){
        $(this).on("click", onClickBotaoCategoria);
    });
}

function associarEventosOpcaoDeOrdenacao(){
    var selectOrdenacao = $("opcao-ordenar");

    selectOrdenacao.on("click", onClickSelectDeOrdenacao);
}

var onClickSelectOrdenacao =  function onClickSelectDeOrdenacao(){
    var opcaoSelecionada = $(this).find(":selected");

    var link = "/listar?opcao-ordernar=" + opcaoSelecionada.val();

    console.log(link);

    window.location.replace(link);
};

var onClickBotaoCategoria = function onClickBotaoCategoria(){
    var categoria = $(this).text();

    var link = "/buscaCategoria?categoria=" + categoria;

    window.location.replace(link);
};

var associarEventos = function associarEventos(){
    associarEventosMenuCategoria();
    associarEventosOpcaoDeOrdenacao();
};

$(document).ready(function(){
    associarEventos();
});