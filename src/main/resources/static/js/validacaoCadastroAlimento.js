//<![CDATA[

function desabilitarInputNutrientes(){

    $(".NA").click(function(){
        var inputNutriente = $(this).val();
        $('#'+inputNutriente).val("");
        if( $('#'+inputNutriente).prop("disabled")==false){
            $('#'+inputNutriente).prop("disabled", true );
        }else{
            $('#'+inputNutriente).prop("disabled", false );
        }
    });
}

function validarCadastro(){

    if (validarNome() && validarCategoria() && validarPorcaoBase() &&
    validarPorcaoExibicao() && validarUnidade() && validarValorMedidaCaseira() && validarUnidadeMedidaCaseira() &&
     validarMaximoDeMedidaCaseira() && validarPorcaoCalorias() && validarPorcaoAcucar() && validarPorcaoSodio() && validarPorcaoGordura()){

        return true;
    }
    return false;
}

function validarNome(){

    var nomeAlimento = $('#nomeAlimento');
    if(nomeAlimento.val()){
        $("#espacoErroNome").hide();
        return true;
    }else{
        escondeCampos();
        $("#espacoErroNome").show();
        nomeAlimento.focus();
        return false;
    }
}

function validarCategoria(){

    var categoriaSelecionada = $('#categoriaSelecionada');
    if(categoriaSelecionada.val() != 0){
        $("#espacoErroCategoria").hide();
        return true;
    }else{
        escondeCampos();
        $("#espacoErroCategoria").show();
        categoriaSelecionada.focus();
        return false;
    }
}

function validarPorcaoBase(){

    var porcaoBase = $('#porcaoBase');
    if(!isNaN(porcaoBase.val()) && porcaoBase.val()!=''){
        $("#espacoErroPorcaoBase").hide();
        return true;
    }else{
         escondeCampos();
         $("#espacoErroPorcaoBase").show();
         porcaoBase.focus();
        return false;
    }
}

function validarUnidade(){

    var ml = $('#mlCalculo');
    var g = $('#gCalculo');
    if((ml.is(":checked")) || (g.is(":checked"))){
         $("#espacoErroUnidade").hide();
        return true;
    }else{
    escondeCampos();
    $("#espacoErroUnidade").show();
    $("#mlCalculo").focus();
    return false;
    }
}

function validarPorcaoExibicao(){

    var porcaoExibicao = $('#porcaoExibicao');
    if(!isNaN(porcaoExibicao.val()) && porcaoExibicao.val()!=''){
        $("#espacoErroPorcaoExibicao").hide();
        return true;
    }else{
        escondeCampos();
        $("#espacoErroPorcaoExibicao").show();
        porcaoExibicao.focus();
        return false;
    }
}



function validarValorMedidaCaseira(){

    var valorMedidaCaseira = $('#valorMedidaCaseira');
    if(!isNaN(valorMedidaCaseira.val()) && valorMedidaCaseira.val() != ""){
       $("#espacoErroValorMedidas").hide();
       $("#espacoErroValorMedidaCaseira").hide();

       return true;
    }else{
        escondeCampos();
        $("#espacoErroValorMedidaCaseiraEmBranco").hide();
        $("#espacoErroUnidadeMedidaCaseira").hide();
        $("#espacoErroValorMedidas").show();
        $("#espacoErroValorMedidaCaseira").show();
        valorMedidaCaseira.focus();

        return false;
    }
}

function validarUnidadeMedidaCaseira(){

    var unidadeMedidaCaseira = $('#unidadeMedidaCaseira');
    if(isNaN(unidadeMedidaCaseira.val()) && unidadeMedidaCaseira.val() != ""){
        $("#espacoErroValorMedidas").hide();
        $("#espacoErroUnidadeMedidaCaseira").hide();

        return true;
    }else{
        escondeCampos();
        $("#espacoErroValorMedidaCaseiraEmBranco").show();
        $("#espacoErroValorMedidas").show();
        $("#espacoErroUnidadeMedidaCaseira").show();
        unidadeMedidaCaseira.focus();

        return false;
    }
}

function validarMaximoDeMedidaCaseira(){

    var maximoMedidaCaseira = $('#valorMaximoMedida');
    if(!isNaN(maximoMedidaCaseira.val())){
        $("#espacoErroMaximoUnidadeCaseira").hide();

        return true;
    }else{
        escondeCampos();
        $("#espacoErroMaximoUnidadeCaseira").show();
        maximoMedidaCaseira.focus();

        return false;
    }
}

function validarPorcaoCalorias(){

    var porcaoCalorias = $('#porcaoCalorias');
    if(!isNaN(porcaoCalorias.val())){
       $("#espacoErroCalorias").hide();

       return true;
    }else{
        escondeCampos();
        $("#espacoErroCalorias").show();
        porcaoCalorias.focus();

        return false;
    }
}

function validarPorcaoAcucar(){

    var porcaoAcucar = $('#porcaoAcucar');
    if(!isNaN(porcaoAcucar.val())){
        $("#espacoErroAcucar").hide();

        return true;
    }else{
        escondeCampos();
        $("#espacoErroAcucar").show();
        porcaoAcucar.focus();

        return false;
    }
}

function validarPorcaoSodio(){

    var porcaoSodio = $('#porcaoSodio');
    if(!isNaN(porcaoSodio.val())){
        $("#espacoErroSodio").hide();

        return true;
    }else{

        escondeCampos();
        $("#espacoErroSodio").show();
        porcaoSodio.focus();
        return false;
    }
}

function validarPorcaoGordura(){

    var porcaoGordura = $('#porcaoGordura');
    if(!isNaN(porcaoGordura.val())){
        $("#espacoErroGordura").hide();

        return true
    }else{

        escondeCampos();
        $("#espacoErroGordura").show();
        porcaoGordura.focus();
        return false;
    }
}

function escondeCampos(){

    $("#espacoErroMaximoUnidadeCaseira").hide();
    $("#espacoErroValorMedidas").hide();
    $("#espacoErroValorMedidaCaseira").hide();
    $("#espacoErroNome").hide();
    $("#espacoErroCategoria").hide();
    $("#espacoErroUnidade").hide();
    $("#espacoErroPorcaoBase").hide();
    $("#espacoErroPorcaoExibicao").hide();
    $("#espacoErroCalorias").hide();
    $("#espacoErroAcucar").hide();
    $("#espacoErroSodio").hide();
    $("#espacoErroGordura").hide();
}

$(document).ready(function() {
    escondeCampos();
    desabilitarInputNutrientes();
});

//]]>