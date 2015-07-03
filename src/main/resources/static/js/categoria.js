function marcaBotaoCategoriaAtual(){
    var categorias = $(".categorias");

    var botoeCategorias = categorias.find("button").each(function(){
        if($(this).val() === getParametros()["categoria"]){
            $(this).toggleClass("categoria-atual");
            $(this).on("click", function(){return false;});
        }
    });
}

$(document).ready(function(){
    marcaBotaoCategoriaAtual();
});