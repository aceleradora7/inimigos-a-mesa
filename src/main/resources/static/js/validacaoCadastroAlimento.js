//<![CDATA[
function desabilitarInputNutrientes() {
    $(".NA").click(function() {
        var inputNutriente = $(this).val();
        $('#'+inputNutriente).val("");
        if( $('#'+inputNutriente).prop( "disabled")==false){
            $('#'+inputNutriente).prop( "disabled", true );
        }else{
            $('#'+inputNutriente).prop( "disabled", false );
        }
    });
}

function validarCadastro(){
    if (validarNome() && validarCategoria() && validarPorcaoBase() &&
    validarPorcaoExibicao() && validarMedidaCaseira() && validarPorcaoCalorias() &&
    validarPorcaoAcucar() && validarPorcaoSodio() && validarPorcaoGordura()) {
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
        $("#espacoErroCategoria").show();
        categoriaSelecionada.focus();
        return false;
    }
}

function validarPorcaoBase(){
    var porcaoBase = $('#porcaoBase');
        if(!isNaN(porcaoBase.val()) && validarUnidadePorcaoBase()){
            $("#espacoErroPorcaoBase").hide();
            return true;
        }else{
             $("#espacoErroPorcaoBase").show();
             porcaoBase.focus();
            return false;
        }
}

function validarUnidadePorcaoBase(){
    var ml = $('#mlCalculo');
    var g = $('#gCalculo');
    if((ml.is(":checked")) || (g.is(":checked"))){
        return true;
    }else{
        return false;
    }
}

function validarPorcaoExibicao(){
    var porcaoExibicao = $('#porcaoExibicao');
        if(!isNaN(porcaoExibicao.val()) && validarUnidadePorcaoExibicao()){
            $("#espacoErroPorcaoExibicao").hide();
            return true;
        }else{
           $("#espacoErroPorcaoExibicao").show();
           porcaoExibicao.focus();
           return false;
        }
}

function validarMedidaCaseira(){
    var medidaCaseira = $('#medidaCaseira');
    if(medidaCaseira.val()){
       $("#espacoErroMedidaCaseira").hide();
       return true;
    }else{
        $("#espacoErroMedidaCaseira").show();
        medidaCaseira.focus();
        return false;
    }
}

function validarUnidadePorcaoExibicao(){
    var ml = $('#mlExibicao');
    var g = $('#gExibicao');
    if((ml.is(":checked")) || (g.is(":checked"))){
        return true;
    }else{
        return false;
    }
}


function validarPorcaoCalorias(){
    var porcaoCalorias = $('#porcaoCalorias');
    if(!isNaN(porcaoCalorias.val())){
       $("#espacoErroCalorias").hide();
       return true;
    }else{
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
        $("#espacoErroGordura").show();
        porcaoGordura.focus();
        return false;
    }
}

function escondeCampos(){
    $("#espacoErroMedidaCaseira").hide();
    $("#espacoErroNome").hide();
    $("#espacoErroCategoria").hide();
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