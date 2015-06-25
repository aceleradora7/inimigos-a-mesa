function associarEventosMenuCategoria(){
    var menuCategorias = $("#menu-categoria");
    var botoesMenuCategoria = menuCategorias.find(".btn");

    botoesMenuCategoria.each(function(){
        $(this).on("click", onClickBotaoCategoria);
    });
};

function associarEventosOpcaoDeOrdenacao(){

    var url= window.location.href;
    console.log(url);

    var selectdeordenar = $("#selectdeordenar").val();
}

var onClickBotaoCategoria = function onClickBotaoCategoria(){
    var categoria = $(this).val();
    console.log("onClickBotaoCategoria -- : "+categoria);

    var link = "/lista?categoria=" + categoria;
    console.log("onClickBotaoCategoria -- : "+link);

//    window.location.replace(link);
};

var associarEventos = function associarEventos(){
    associarEventosMenuCategoria();
};

$(document).ready(function(){
    associarEventos();
});