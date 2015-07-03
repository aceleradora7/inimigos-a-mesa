function onClickOpcaoDeOrdenacao(){
    setParametro("opcao-ordenar" , $(this).val());
    acessarPaginaComParametros("grid");
}

function associarEventosOpcaoDeOrdenacao(){
    var selectDeOrdenacao = $("#select-ordenacao");
    selectDeOrdenacao.on("click", "option", onClickOpcaoDeOrdenacao);
}

function associarEventos(){
    associarEventosOpcaoDeOrdenacao();
};

$(document).ready(function(){

    var parametros = getParametros();

    if(parametros["opcao-ordenar"] != undefined){
        $("#select-ordenacao").val(parametros["opcao-ordenar"]);
    }

    associarEventos();
});
