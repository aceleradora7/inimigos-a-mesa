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

function splitValorTabela(){
    caloriaSplit = $("#valor-caloria").text().split(" ");
    valorCaloria = parseFloat(caloriaSplit[0]);
    tipoCaloria = caloriaSplit[2];

    acucarSplit = $("#valor-acucar").text().split(" ");
    valorAcucar = parseFloat(acucarSplit[0]);
    tipoAcucar = acucarSplit[2];

    gorduraSplit = $("#valor-gordura").text().split(" ");
    valorGordura = parseFloat(gorduraSplit[0]);
    tipoGordura = gorduraSplit[2];

    sodioSplit = $("#valor-sodio").text().split(" ");
    valorSodio = parseFloat(sodioSplit[0]);
    tipoSodio = sodioSplit[2];
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
    var caloria = ((porcao*valorCaloria)/porcaoAlimento).toFixed(2)
    $("#valor-caloria").text(caloria+" "+tipoCaloria);
    $("#valor-caloria").attr('value', caloria);
}

function calculaAcucar(porcao){
    var acucar = ((porcao*valorAcucar)/porcaoAlimento).toFixed(2)
    $("#valor-acucar").text(acucar+" "+tipoAcucar);
    $("#valor-acucar").attr('value', acucar);
}

function calculaGordura(porcao){
    var gordura = ((porcao*valorGordura)/porcaoAlimento).toFixed(2)
    $("#valor-gordura").text(gordura+" "+tipoGordura);
    $("#valor-gordura").attr('value', gordura);
}

function calculaSodio(porcao){
    var sodio = ((porcao*valorSodio)/porcaoAlimento).toFixed(2)
    $("#valor-sodio").text(sodio+" "+tipoSodio);
    $("#valor-sodio").attr('value', sodio);

}

$(document).ready(function() {
    splitValorTabela();
});

//]]>