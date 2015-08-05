//  <![CDATA[
var padraoEmail = new RegExp(/[a-zA-Z0-9\.\_\-]+[@]+(.)+(\.)+[a-zA-Z0-9]+/);

function validarCadastroUsuario(){

        if (validarNomeUsuario() && validarEmailUsuario() && validarSenhaUsuario()) {
            return true;
        }
        return false;

    }

function validarNomeUsuario(){
    var nomeUsuario = $('#nomeDoUsuario');

        if(nomeUsuario.val()){
            document.getElementById("espacoErroNome").style.display = "none";
            return true;
        }else
        {

            document.getElementById("espacoErroNome").style.display = "block";
            nomeUsuario.focus();
            document.getElementById("espacoErroEmail").style.display = "none";
            document.getElementById("espacoErroSenha").style.display = "none";
            document.getElementById("espacoErroRepetirSenha").style.display = "none";
            return false;
        }
}

function validarEmailUsuario(){
     var emailDoUsuario = $('#emailDoUsuario');
      if(padraoEmail.test(emailDoUsuario.val()))
        {
            document.getElementById("espacoErroEmail").style.display = "none";
            return true;
         }else
         {
            document.getElementById("espacoErroEmail").style.display = "block";
             espacoErroEmail.focus();
             document.getElementById("espacoErroNome").style.display = "none";
             document.getElementById("espacoErroSenha").style.display = "none";
             document.getElementById("espacoErroRepetirSenha").style.display = "none";
             return false;
         }

}
function validarSenhaUsuario(){
    var senhaDoUsuario = $('#senhaUsuario');
    var senhaRepetida = $('#senhaUsuarioRepetir')


     if (senhaDoUsuario.val().length >= 4) {
          document.getElementById("espacoErroSenha").style.display = "none";
        if (senhaDoUsuario.val() == senhaRepetida.val()){
            document.getElementById("espacoErroRepetirSenha").style.display = "none";

            return true;
        }else{
            document.getElementById("espacoErroRepetirSenha").style.display = "block";
            senhaDoUsuario.focus();
            senhaRepetida.focus();
            document.getElementById("espacoErroNome").style.display = "none";
            document.getElementById("espacoErroSenha").style.display = "none";
            document.getElementById("espacoErroEmail").style.display = "none";
            return false;
        }
     }
     else{
          document.getElementById("espacoErroSenha").style.display = "block";
          senhaDoUsuario.focus();
          document.getElementById("espacoErroNome").style.display = "none";
                      document.getElementById("espacoErroRepetirSenha").style.display = "none";
                      document.getElementById("espacoErroEmail").style.display = "none";
           return false;
     }
}

$(document).ready(function() {


});

//]]>