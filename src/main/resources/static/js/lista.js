function associarEventosMenuCategoria(){
    var menuCategorias = $("#menu-categoria");
    var botoesMenuCategoria = menuCategorias.find(".btn");

    botoesMenuCategoria.each(function(){
        $(this).on("click", onClickBotaoCategoria);
    });
}


var onClickBotaoCategoria = function onClickBotaoCategoria(){
    var categoria = $(this).text();
    window.location.replace("/buscaCategoria?categoria=" + categoria);
}

$(document).ready(function(){
    associarEventosMenuCategoria();
});