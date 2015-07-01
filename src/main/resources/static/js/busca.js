function criaBusca(){

    function buscaDados(request, response){
        $.ajax({
            dataType: "json",
            url: "/autoCompletar",
            type: "GET",
            data : {
                "textoDigitado" : request.term
            },
            success: function(dados){
                console.log(dados);

                var sugestoes = [];

                for(var i = 0; i< dados.length; i++){

                    var sugestao = {
                        label : dados[i].nome,
                        value : dados[i].codigo
                    };

                    sugestoes.push(sugestao);
                }

                response(sugestoes);
            }
        })
    };

    $("#input-busca").autocomplete({
        minLength: 3,
        source:function (request, response){
             buscaDados(request, response);
        },
        select:function(event, ui){
            event.preventDefault();
            var id = ui.item.value
            var link = "/detalhe/" + id;
           window.location.replace(link);
        },
        focus: function(event, ui) {
                event.preventDefault();
                $(this).val(ui.item.label);
            }
    });
};

function eventoBotaoPesquisar() {
    $("#input-busca").keyup(function() {
        if ($(this).val().length >= 1) {
            criaBusca();
        }
    });
}

function onClickBotaoBusca(){
    setParametro("busca", $("#input-busca").val());
    removerParametro("categoria");
    acessarPaginaComParametros("lista");
}

function associarEventoBotaoBusca(){
    $("#btn-busca").on("click", onClickBotaoBusca);
}

function buscaEnter(){
 $("#input-busca").keypress(function(e)

{
	if (e.which == 13)
	{
		onClickBotaoBusca();
	}
})};

$(document).ready(function() {
    eventoBotaoPesquisar();
    associarEventoBotaoBusca();
    buscaEnter();
});
