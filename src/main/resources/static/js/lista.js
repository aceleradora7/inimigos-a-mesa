function associarEventosMenuCategoria(){
    var menuCategorias = $("#menu-categoria");
    var botoesMenuCategoria = menuCategorias.find(".btn");

    botoesMenuCategoria.each(function(){
        $(this).on("click", onClickBotaoCategoria);
    });
}

function associarEventosOpcaoDeOrdenacao(){

    var teste = $("#selectdeordenar").val();
    var link = "/lista?opcao-ordenar=" + teste;


    window.location.replace(link);
   }



var onClickBotaoCategoria = function onClickBotaoCategoria(){
    var categoria = $(this).val();

    var link = "/buscaCategoria?categoria=" + categoria;

    window.location.replace(link);
};

var associarEventos = function associarEventos(){
    associarEventosMenuCategoria();
   // associarEventosOpcaoDeOrdenacao();
};

$(document).ready(function(){
    associarEventos();
});