//<![CDATA[

$(document).ready(function(){
    $("#botaoDeletar").click(function(e){
            if(deletarUsuario()){
            return true;
        }
        return false;
    });

    $("#valorUsuario").change(function(e){
             $('#nome-usuario').text($('#valorUsuario option:selected').text());
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