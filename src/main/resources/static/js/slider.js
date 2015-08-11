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
    renderizarColher("gordura");
    renderizarColher("sal");
    renderizarColher("acucar");

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
    calculaCaloria(valor);
    calculaAcucar(valor);
    calculaGordura(valor);
    calculaSodio(valor);
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

function calculaCaloria(porcao){
    if(valorCaloria!=null){
        var caloria = ((porcao*valorCaloria)/porcaoAlimento).toFixed(2);
    }
    if(caloria<=0.5 && caloria>0){
        $("#valor-caloria").text("TR");
        $("#valor-caloria").attr('value', caloria);
    }else if(caloria==0){
        $("#valor-caloria").text("NA");
    }else{
        $("#valor-caloria").text(caloria+" kcal");
        $("#valor-caloria").attr('value', caloria);
    }
}

function calculaAcucar(porcao){
    if(valorAcucar!=null){
        var acucar = ((porcao*valorAcucar)/porcaoAlimento).toFixed(2);
    }
    if(acucar<=0.5 && acucar>0){
        $("#valor-acucar").text("TR");
        $("#valor-acucar").attr('value', acucar);
    }else if(acucar==0){
        $("#valor-acucar").text("NA");
    }else{
        $("#valor-acucar").text(acucar+" g");
        $("#valor-acucar").attr('value', acucar);
    }
}

function calculaGordura(porcao){
    if(valorGordura!=null){
        var gordura = ((porcao*valorGordura)/porcaoAlimento).toFixed(2);
    }
    if(gordura<=0.5 && gordura>0){
        $("#valor-gordura").text("TR");
        $("#valor-gordura").attr('value', gordura);

    }else if(gordura==0){
        $("valor-gordura").text("NA");
    }else{
        $("#valor-gordura").text(gordura+" g");
        $("#valor-gordura").attr('value', gordura);
    }
}

function calculaSodio(porcao){
    if(valorSodio!=null){
        var sodio = ((porcao*valorSodio)/porcaoAlimento).toFixed(2);
    }
    if(sodio<=0.5 && sodio>0){
        $("#valor-sodio").text("TR");
        $("#valor-sodio").attr('value', sodio);
    }else if(sodio==0){
        $("#valor-sodio").text("NA");
    }else{
        $("#valor-sodio").text(sodio+" mg");
        $("#valor-sodio").attr('value', sodio);
    }
}

$(document).ready(function() {
    valorTabela();
});

//]]>