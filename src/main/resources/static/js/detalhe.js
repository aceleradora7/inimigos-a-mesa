//  <![CDATA[


function renderizarColher(tipo){

    function getQuantidade(){
        return $("#" + tipo).attr("value");
    }
    function getContainer(){
        return $("#imagem-colher-" + tipo);
    }
    function getImagem(){
        return "/img/colher-" + tipo + ".svg";
    }

    function montaColher(imagem){
        return colher = $("#template-colher").find("#image").attr("src", imagem);
    }

    function mensagemSemColher(){
        return $("#template-sem-colher").find("span");
    }

    var colher = montaColher(getImagem());
    var container = getContainer();
    var quantidade = getQuantidade();


    if(quantidade >= 1){
        container.empty();
        for(i = 0; i < quantidade; i++){
            container.append(colher.clone());
        }

    }else{
        container.empty();
        container.append(mensagemSemColher().clone());
    }
}

$(document).ready(function(){

    renderizarColher("gordura");
    renderizarColher("sal");
    renderizarColher("acucar");

})


//]]>