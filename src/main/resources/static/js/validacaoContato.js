 //  <![CDATA[

function validarCampos(){

    if(validarNome()){
        if(validarEmail()){
           if(validarMensagem()){
             return true;
           }
        }else{
            return false;
        }
    }else{
        return false;
    }

}

function validarEmail(){

    if($("#email").val()=="" ||
    $("#email").val().indexOf('@')==-1 ||
    $("#email").val().indexOf('\.')==-1 ){
        esconderCamposErro();
        $("#erro-email").show();
        $("#email").focus();
        return false;
    }
   return true;
}


function validarNome(){

    var padrao = new RegExp(/(?:\d*\.)?\d+/);
    if($("#nome").val()=="" || padrao.test($("#nome").val())){
        esconderCamposErro();
        $("#erro-nome").show();
        $("#nome").focus();
        return false;
    }
    return true;
}

function esconderCamposErro(){

    $("#erro-nome").hide();
    $("#erro-email").hide();
    $("#erro-mensagem").hide();
}

function validarMensagem(){

    if($("#mensagem").val()==""){
        esconderCamposErro();
        $("#erro-mensagem").show();
        $("#mensagem").focus();
        return false;
    }
    return true;
}

function limparCampos(){

    var elementos = document.getElementsByClassName("form-control");
    for (var cont=0; cont < elementos.length; cont++) {
        if (elementos[cont].type == "text" || elementos[cont].type == "textarea") {
            elementos[cont].value = "";
        }
    }
}

//]]>
