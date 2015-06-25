

function associarEventosMenuCategoria(){
    var menuCategorias = $("#menu-categoria");
    var botoesMenuCategoria = menuCategorias.find(".btn");

    botoesMenuCategoria.each(function(){
        $(this).on("click", onClickBotaoCategoria);
    });
}

function associarEventosOpcaoDeOrdenacao(){

    var url = window.location.href;
    var selectdeordenar = $("#selectdeordenar").val();
    if(url.indexOf("lista")>-1){
        var link = "/lista?opcao-ordenar=" + selectdeordenar;
    }else if(url.indexOf("buscaCategoria")>-1){
             var link = url.split('-')[0] + "-" +selectdeordenar;
         }
    window.location.replace(link);
}

var onClickBotaoCategoria = function onClickBotaoCategoria(){
    var categoria = $(this).val();

    var link = "/buscaCategoria?categoria=" + categoria;

    window.location.replace(link);
};

var associarEventos = function associarEventos(){
    associarEventosMenuCategoria();
};

$(document).ready(function(){
    associarEventos();
});