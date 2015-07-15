 //  <![CDATA[

function validarRecuperacao(){
    if(validarNome() == true){
        if(validarEmail() == true){
            if(validarMensagem() == true){
                  return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }else{
        return false;
    }

}



function validarEmail(){

  if(document.dados.email.value=="" ||
          document.dados.email.value.indexOf('@')==-1 ||
          document.dados.email.value.indexOf('\.')==-1 )
     {
          document.getElementById('erro-email').style.display = "inline";
          document.getElementById('erro-mensagem').style.display = "none";
          document.getElementById('erro-nome').style.display = "none";
          document.dados.email.focus();
          return false;

      }

   return true;
}


function validarNome(){

  if(document.dados.nome.value=="" ||
           document.dados.nome.value.indexOf('0')>-1 ||
           document.dados.nome.value.indexOf('1')>-1 ||
           document.dados.nome.value.indexOf('2')>-1 ||
           document.dados.nome.value.indexOf('3')>-1 ||
           document.dados.nome.value.indexOf('4')>-1 ||
           document.dados.nome.value.indexOf('5')>-1 ||
           document.dados.nome.value.indexOf('6')>-1 ||
           document.dados.nome.value.indexOf('7')>-1 ||
           document.dados.nome.value.indexOf('8')>-1 ||
           document.dados.nome.value.indexOf('9')>-1
           )
     {
          document.getElementById('erro-nome').style.display = "inline";
          document.getElementById('erro-mensagem').style.display = "none";
          document.getElementById('erro-email').style.display = "none";
          document.dados.nome.focus();
          return false;

      }

   return true;
}

function validarMensagem(){

  if(document.dados.mensagem.value=="")
      {
          document.getElementById('erro-mensagem').style.display = "inline";
          document.getElementById('erro-nome').style.display = "none";
          document.getElementById('erro-email').style.display = "none";
          document.dados.mensagem.focus();
          return false;

      }

   return true;
}

 //]]>
