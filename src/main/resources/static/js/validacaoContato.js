 //  <![CDATA[

function validarRecuperacao(){
    if(validarNome()){
        if(validarEmail()){
           return validarMensagem();
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
         $("#email").val().indexOf('\.')==-1 )
     {
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

  if($("#mensagem").val()=="")
      {
          esconderCamposErro();
          $("#erro-mensagem").show();
          $("#mensagem").focus();
          return false;

      }

   return true;
}

 //]]>
