//<![CDATA[

    function recuperarSenha(){
        if(novaSenha() && novaSenhaRepetida() && verificarSeSenhaSaoIguais()){

            return true;
        }
        else{

            return false;
        }
    }

    function verificarSeSenhaSaoIguais(){
        var senha1 = $('#novaSenha').val();
        var senha2 = $('#novaSenhaRepetida').val();
        if(senha1 == senha2){
            $("#erroNovaSenhaIgual").hide();
            return true;
        }else{
            $("#erroNovaSenhaIgual").show();
            return false;
        }
    }

    function novaSenha(){
        var senha = $('#novaSenha');
        if(senha.val()){
            $("#erroNovaSenha").hide();
            return true;
        }else{
            $("#erroNovaSenhaIgual").hide();
            $("#erroNovaSenha").show();
            return false;
        }
    }

    function novaSenhaRepetida(){
        var senha = $('#novaSenhaRepetida');
        if(senha.val()){
            $("#erroNovaSenhaRepetida").hide();
            return true;
        }else{
            $("#erroNovaSenhaIgual").hide();
            $("#erroNovaSenhaRepetida").show();
            return false;
        }
    }


    function escondeCampos(){
        $("#erroNovaSenha").hide();
        $("#erroNovaSenhaRepetida").hide();
        $("#erroNovaSenhaIgual").hide();
    }

    $(document).ready(function() {
        escondeCampos();

    });


    //]]>