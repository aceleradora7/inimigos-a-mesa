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
    validarMaximoDeMedidaCaseira() && validarPorcaoCalorias() && validarPorcaoAcucar() && validarPorcaoSodio() &&
    validarPorcaoGordura() && validarFonte()){
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

    var porcaoBase =  replaceVirgulaPonto($('#porcaoBase').val());
    $('#porcaoBase').attr('value',porcaoBase);
    if(!isNaN(porcaoBase) && porcaoBase!=''){
        $("#espacoErroPorcaoBase").hide();
        return true;
    }else{
         escondeCampos();
         $("#espacoErroPorcaoBase").show();
         $('#porcaoBase').focus();
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
    var porcaoExibicao =  replaceVirgulaPonto($('#porcaoExibicao').val());
    $('#porcaoExibicao').attr('value',porcaoExibicao);
    if(!isNaN(porcaoExibicao) && porcaoExibicao!=''){
        $("#espacoErroPorcaoExibicao").hide();
        return true;
    }else{
        escondeCampos();
        $("#espacoErroPorcaoExibicao").show();
        $('#porcaoExibicao').focus();
        return false;
    }
}



function validarValorMedidaCaseira(){
    var valorMedidaCaseira =  replaceVirgulaPonto($('#valorMedidaCaseira').val());
    $('#valorMedidaCaseira').attr('value',valorMedidaCaseira);
    if(!isNaN(valorMedidaCaseira) && valorMedidaCaseira != ""){
       $("#espacoErroValorMedidas").hide();
       $("#espacoErroValorMedidaCaseira").hide();

       return true;
    }else{
        escondeCampos();
        $("#espacoErroValorMedidaCaseiraEmBranco").hide();
        $("#espacoErroUnidadeMedidaCaseira").hide();
        $("#espacoErroValorMedidas").show();
        $("#espacoErroValorMedidaCaseira").show();
        $('#valorMedidaCaseira').focus();

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
    if(!isNaN(maximoMedidaCaseira.val()) && maximoMedidaCaseira.val().indexOf(",") < 0 && maximoMedidaCaseira.val().indexOf(".") < 0){
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

    var porcaoCalorias = replaceVirgulaPonto($('#porcaoCalorias').val());
    $('#porcaoCalorias').attr('value',porcaoCalorias);
    if(!isNaN(porcaoCalorias)){
       $("#espacoErroCalorias").hide();
       return true;
    }else{
        escondeCampos();
        $("#espacoErroCalorias").show();
       $('#porcaoCalorias').focus();

        return false;
    }
}

function validarPorcaoAcucar(){
    var porcaoAcucar =  replaceVirgulaPonto($('#porcaoAcucar').val());
    $('#porcaoAcucar').attr('value',porcaoAcucar);
    if(!isNaN(porcaoAcucar)){
        $("#espacoErroAcucar").hide();

        return true;
    }else{
        escondeCampos();
        $("#espacoErroAcucar").show();
        $('#porcaoAcucar').focus();

        return false;
    }
}

function validarPorcaoSodio(){
    var porcaoSodio =  replaceVirgulaPonto($('#porcaoSodio').val());
    $('#porcaoSodio').attr('value',porcaoSodio);
    if(!isNaN(porcaoSodio)){
        $("#espacoErroSodio").hide();

        return true;
    }else{

        escondeCampos();
        $("#espacoErroSodio").show();
        $('#porcaoSodio').focus();
        return false;
    }
}

function validarPorcaoGordura(){
    var porcaoGordura =  replaceVirgulaPonto($('#porcaoGordura').val());
    $('#porcaoGordura').attr('value',porcaoGordura);
    if(!isNaN(porcaoGordura)){
        $("#espacoErroGordura").hide();

        return true
    }else{

        escondeCampos();
        $("#espacoErroGordura").show();
         $('#porcaoGordura').focus();
        return false;
    }
}

function validarFonte(){

    var fonte = $('#fonte');
    if(fonte.val()){
        $("#espacoErroFonte").hide();
        return true;
    }else{
        escondeCampos();
        $("#espacoErroFonte").show();
        fonte.focus();
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
    $("#espacoErroFonte").hide();
}

function replaceVirgulaPonto(valor){
    return valor.replace(',','.');
}

$(document).ready(function() {
    escondeCampos();
    desabilitarInputNutrientes();
});

//]]>