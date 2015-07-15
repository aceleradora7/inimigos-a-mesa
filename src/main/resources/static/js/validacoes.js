 //  <![CDATA[

        function validarRecuperacao(){
           if( document.dados.inputEmail.value=="" ||
                document.dados.inputEmail.value.indexOf('@')==-1 ||
                document.dados.inputEmail.value.indexOf('\.')==-1 )
           {
                document.getElementById('trocaEmail').style.display = "inline";
                document.dados.inputEmail.focus();

                return false;

           }

                return true;
        }

         function alterandoDisplay(){
               document.getElementById('trocaEmail').style.display = "none";
           }


         function validarLogin(){
                   if( document.dados.inputEmail.value=="" ||
                        document.dados.inputEmail.value.indexOf('@')==-1 ||
                        document.dados.inputEmail.value.indexOf('\.')==-1 )
                   {
                        document.getElementById('trocaEmail').style.display = "inline";
                        document.dados.inputEmail.focus();

                        return false;

                   }

                        return true;
                }




 //]]>
