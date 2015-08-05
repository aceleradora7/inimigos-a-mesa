//<![CDATA[

    $(document).ready(function(){

        $("#botaoDeletar").click(function(e){

            if(deletarUsuario())
            {
                return true;
            }
            else{

            }
            return false;
        });
    });

       function deletarUsuario(){
            var valor = $('#valorUsuario option:selected').val();

            if(valor){
               setParametro("codigo", valor);
               acessarPaginaComParametros("deletarUsuario");
                return true;
            }

        return false;
    }
//]]>