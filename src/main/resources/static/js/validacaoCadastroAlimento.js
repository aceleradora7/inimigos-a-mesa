
//<![CDATA[

     var padraoValores = new RegExp(/[0-9\.\,]/);



    function validarCadastro(){

        if (validarNome() && validarCategoria() && porcaoCalorias() && porcaoAcucar()){
            alert ("foii");
            return true;
        }
        alert("Errou");
        return false;

    }


    function validarNome(){
        var nomeAlimento = $('#nomeAlimento');

                if(nomeAlimento.val()){
                    alert ("111111111");
                    return true;
                }else
                {
                    alert ("2222222222222");
                    return false;
                }
    }

    function validarCategoria(){
        var categoriaSelecionada = $('#categoriaSelecionada');

            if(categoriaSelecionada.val() != 0){
                alert("validarCategoria() True");
                return true;
            }else
            {
                alert("validarCategoria() False");
                return false;
            }
    }

   function porcaoCalorias(){
        var porcaoCalorias = $('#porcaoCalorias');

            if(padraoValores.test(porcaoCalorias.val())){
                alert ("validarPorcaoCaloria() true");
                return true;
            }else
            {
                alert ("validarPorcaoCaloria() False");
                return false;
            }
    }

    function porcaoAcucar(){
            var porcaoAcucar = $('#porcaoAcucar');

                if(padraoValores.test(porcaoAcucar.val())){
                    alert ("validarPorcaoAcucar() true");
                    return true;
                }else
                {
                    alert ("validarPorcaoAcucar() False");
                    return false;
                }
        }


//]]>

