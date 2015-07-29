//  <![CDATA[

var padraoEmail = new RegExp(/[a-zA-Z0-9\.\_\-]+[@]+(.)+(\.)+[a-zA-Z0-9]+/);

    function validarRecuperacao(){

        var emailRecuperacao = $('#emailRecuperacao');

        if(padraoEmail.test(emailRecuperacao.val())){
            escondeErroEmailRecuperacao();
            return true;
        }else
        {
            mostraErroEmailRecuperacao();
            emailLogin.focus();

            return false;
        }
    }

    function mostraErroEmailRecuperacao(){
        var div = $("#espacoErroEmailRecuperacao");
        div.show();
      }

    function escondeErroEmailRecuperacao(){
        var div = $("#espacoErroEmailRecuperacao");
        div.hide();
    }

     function mostraSucessoLogin(){
            var div = $("#sucesso-login");
            div.show();
        }

     function escondeSucessoLogin(){
                var div = $("#sucesso-login");
                div.hide();
            }

    function mostraErroEmail(){
        var div = $("#espacoErroEmail");
        div.show();
    }

    function mostraErroSenha(){
        var div = $("#espacoErroSenha");
        div.show();
    }

    function escondeErroEmail(){
        var div = $("#espacoErroEmail");
        div.hide();
    }

    function escondeErroSenha(){
        var div = $("#espacoErroSenha");
        div.hide();
    }

    function validarSenha(){

         var senhaLogin = $('#senhaLogin');

         if(senhaLogin.val()){
            escondeErroSenha();
            return true;
         }
         else
         {
            mostraErroSenha();
            senhaLogin.focus();
            return false;
         }
    }

    function validarEmail(){

        var emailLogin = $('#emailLogin');

        if(padraoEmail.test(emailLogin.val())){
            escondeErroEmail();
            return true;
        }else
        {
            $('#senhaLogin').val("");
            escondeErroSenha();
            mostraErroEmail();
            emailLogin.focus();

            return false;
        }
    }

    function validarLogin(){

    if (validarEmail() && validarSenha() )
    {
        return true;
    }

    return false;

    }

$(document).ready(function(){


    var link = window.location.href;
    if(link.indexOf("/emailRecuperar") > 0){
    $('#ModalSucesso').modal('show');
    }

    escondeErroEmailRecuperacao();
    escondeSucessoLogin();
    escondeErroEmail();
    escondeErroSenha();

    $("#validarLogin").submit(function(e){

        if(validarLogin())
        {
            return true;
        }
        else{

        }
        return false;
    });


});

//]]>
