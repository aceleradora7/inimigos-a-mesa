//  <![CDATA[

var padraoEmail = new RegExp(/[a-zA-Z0-9\.\_\-]+[@]+(.)+(\.)+[a-zA-Z0-9]+/);
var padraoSenha = new RegExp(/[a-zA-Z0-9\.\_\-]/);

function sucesso(){

   var emailRecuperacao = $("#emailRecuperacao");


       $('#sucesso-email-recuperacao').addClass('alert');
       $('#sucesso-email-recuperacao').addClass('alert-success');
       $('#sucesso-email-recuperacao').append($("#msg-sucesso-email").find("label").clone());
       emailRecuperacao.focus();

       return true;

}



function validarRecuperacao(){

   var emailRecuperacao = $("#emailRecuperacao");

   if( padraoEmail.test(emailRecuperacao.val())){
       $('#sucesso-email-recuperacao').addClass('alert');
       $('#sucesso-email-recuperacao').addClass('alert-success');
       $('#sucesso-email-recuperacao').append($("#msg-sucesso-email").find("label").clone());
       emailRecuperacao.focus();

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

          var erroEmail = $('#msg-erro-email');
         erroEmail.css({"display" : "none"});

    }

function validarSenha(){
     var senhaLogin = $('#senhaLogin');
     if(padraoSenha.test(senhaLogin.val())){
        return true;

        }

    $('#erro-senha-login').empty();
    $('#erro-senha-login').addClass('alert');
    $('#erro-senha-login').addClass('alert-danger');
    $('#erro-senha-login').append($('#msg-erro-senha').find("label").clone());

    $("#espacoErroSenha").addClass('form-group');

    senhaLogin.focus();

    return false;
}

function validarLogin(){

    var emailLogin = $('#emailLogin');

    if(padraoEmail.test(emailLogin.val())){
    validarSenha();

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
      var link = window.location.href;
    if(link.indexOf("/emailRecuperar") > 0){
    $('#ModalSucesso').modal('show');
    }

     $("#btn-entrar").on("click", function(evento){
             evento.preventDefault();
             validarLogin()? $("#validarLogin").submit() : console.log("Erro");
     });
});

//]]>
