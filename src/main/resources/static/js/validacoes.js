//  <![CDATA[

var padraoEmail = new RegExp(/[a-zA-Z0-9\.\_\-]+[@]+(.)+(\.)+[a-zA-Z0-9]+/);

function validarRecuperacao(){

    var emailRecuperacao = $("#emailRecuperacao");

   if( padraoEmail.test(emailRecuperacao.val())){
        return true;
   }

    $('#erro-email-recuperacao').empty();
    $('#erro-email-recuperacao').addClass('alert');
    $('#erro-email-recuperacao').addClass('alert-danger');
    $('#erro-email-recuperacao').append($("#msg-erro-email").find("label").clone());
    emailRecuperacao.focus();
    return false;
}

function alterandoDisplay(){
    var erroEmail = $('#erroEmail');
//    erroEmail.css({"display" : "none"});

}


function validarLogin(){

    var emailLogin = $('#emailLogin');


    if(padraoEmail.test(emailLogin.val())){
        return true;
    }
    $('#erro-email-login').empty();
    $('#erro-email-login').addClass('alert');
    $('#erro-email-login').addClass('alert-danger');
    $('#erro-email-login').append($('#msg-erro-email').find("label").clone());

    $("#espacoErro").addClass('form-group');

    emailLogin.focus();

    return false;
}




$(document).ready(function(){

     $("#btn-entrar").on("click", function(evento){
             evento.preventDefault();
             validarLogin()? $("#validarLogin").submit() : console.log("Erro");
     });

});

//]]>
