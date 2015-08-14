 //  <![CDATA[

var porcaoAlimento = $("#porcaoAlimento").text();
var colherGordura = $("#gordura").attr('value');
var colherAcucar = $("#acucar").attr('value');
var colherSal = $("#sal").attr('value');
var valorCaloria;
var tipoCaloria;
var valorAcucar;
var tipoAcucar;
var valorGordura;
var tipoGordura;
var valorSodio;
var tipoSodio;


$('#slider').slider().on('slide', function(ev) {
    calculaMedidas(ev.value);
    calculaColheres(ev.value);
});

function calculaColheres(valor){
    $.ajax({
        dataType: "json",
        url: '/calculaColheres',
        type: "GET",
        data : {
            "acucar" : $("#valor-acucar").attr('value'),
            "sodio" : $("#valor-sodio").attr('value'),
            "gordura" : $("#valor-gordura").attr('value'),
            "porcaoExibicao" : porcaoAlimento
        },
        success: function(dados){
            $("#acucar").attr('value', dados.acucar);
            $("#valor-colher-acucar").attr('value', dados.acucar);
            $("#valor-colher-acucar").text($("#valor-colher-acucar").attr('value'));

            $("#gordura").attr('value', dados.gordura);
            $("#valor-colher-gordura").attr('value', dados.gordura);
            $("#valor-colher-gordura").text($("#valor-colher-gordura").attr('value'));

            $("#sal").attr('value', dados.sal);
            $("#valor-colher-sal").attr('value', dados.sal);
            $("#valor-colher-sal").text($("#valor-colher-sal").attr('value'));

            renderizarColher("gordura");
            renderizarColher("sal");
            renderizarColher("acucar");

        }
    });
}

function valorTabela(){

    valorCaloria = $("#valor-caloria").attr('value');
    valorAcucar = $("#valor-acucar").attr('value');
    valorGordura = $("#valor-gordura").attr('value');
    valorSodio = $("#valor-sodio").attr('value');
    valorUnidade = $("#valorMedidaCaseira").text();
}

function calculaMedidas(valor){

    calculaValorUnidade(valor);
    valor = calculaPorcao(valor);
    calculaValoresTabela(valor, valorCaloria, "kcal", "valor-caloria");
    calculaValoresTabela(valor, valorAcucar, "g", "valor-acucar");
    calculaValoresTabela(valor, valorGordura, "g", "valor-gordura");
    calculaValoresTabela(valor, valorSodio, "mg", "valor-sodio");
}

function calculaValorUnidade(valor){

    valorUnidadeCalculado = valorUnidade * valor;
    $("#valorMedidaCaseira").text(valorUnidadeCalculado);
    $("#valorMedidaCaseira").attr('value', valorUnidadeCalculado);
    $("#valorMedidaCaseiraSlider").text(valorUnidadeCalculado);
    $("#valorMedidaCaseiraSlider").attr('value', valorUnidadeCalculado);

}
function calculaPorcao(valor){

    valor = valor*porcaoAlimento;
    $("#porcaoAlimento").text(valor);
    $("#porcaoAlimento").attr('value', valor);
    $("#porcaoAlimentoCima").text(valor);
    $("#porcaoAlimentoCima").attr('value', valor);

    return valor;
}

function calculaValoresTabela(porcao, valor, unidade, id){

    if(valor!=null){
        var resultado = ((porcao*valor)/porcaoAlimento).toFixed(2);
    }
    if(resultado<=0.5 && resultado>0){
        $("#"+id).text("TR");
        $("#"+id).attr('value', resultado);
    }else if(resultado==0){
        $("#"+id).text("NA");
    }else{
         $("#"+id).text(resultado+' '+unidade);
         $("#"+id).attr('value', resultado);
    }
}

$(document).ready(function() {
    $('.tooltip').hide();
    valorTabela();
});

//]]>