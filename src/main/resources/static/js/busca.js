
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

                    console.log(sugestoes);

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
                var link = "/detalhe?alimento=" + ui.item.value;
                window.location.replace(link);
            }
        });
    };

function eventoDesbloquearBotaoPesquisar() {
    $("#input-busca").keyup(function() {
        if ($(this).val().length >= 1) {
            criaBusca();
        }
    });
}

$(document).ready(function() {
    eventoDesbloquearBotaoPesquisar();

});
