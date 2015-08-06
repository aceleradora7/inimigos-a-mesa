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
console.log(colherAcucar);
    $("#gordura").attr('value', valor*colherGordura);
    $("#acucar").attr('value', valor*colherAcucar);

    console.log(valor*colherAcucar);

    $("#sal").attr('value', valor*colherSal);
}

function valorTabela(){
    valorCaloria = $("#valor-caloria").attr('value');
    valorAcucar = $("#valor-acucar").attr('value');
    valorGordura = $("#valor-gordura").attr('value');
    valorSodio = $("#valor-sodio").attr('value');
}

function calculaMedidas(valor){
    valor = calculaPorcao(valor);
    calculaCaloria(valor);
    calculaAcucar(valor);
    calculaGordura(valor);
    calculaSodio(valor);
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
    if(valorCaloria!=null)
        var caloria = ((porcao*valorCaloria)/porcaoAlimento).toFixed(2)
        $("#valor-caloria").text(caloria+" kcal");
        $("#valor-caloria").attr('value', caloria);
}

function calculaAcucar(porcao){
    if(valorAcucar!=null)
        var acucar = ((porcao*valorAcucar)/porcaoAlimento).toFixed(2)
        $("#valor-acucar").text(acucar+" g");
        $("#valor-acucar").attr('value', acucar);
}

function calculaGordura(porcao){
    if(valorGordura!=null)
        var gordura = ((porcao*valorGordura)/porcaoAlimento).toFixed(2)
        $("#valor-gordura").text(gordura+" g");
        $("#valor-gordura").attr('value', gordura);
}

function calculaSodio(porcao){
    if(valorSodio!=null)
        var sodio = ((porcao*valorSodio)/porcaoAlimento).toFixed(2)
        $("#valor-sodio").text(sodio+" mg");
        $("#valor-sodio").attr('value', sodio);

}

$(document).ready(function() {
    valorTabela();
});

//]]>