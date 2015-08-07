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
    container.empty();
    if(quantidade >= 1){
        for(i = 0; i < quantidade; i++){
            container.append(colher.clone());
        }
    }else{
        container.append(mensagemSemColher().clone());
    }
}

function efeitoDaAncora(){
    $(function() {
        $('a').bind('click',function(event){
            var $anchor = $(this);
            $('html, body').stop().animate({scrollTop: $($anchor.attr('href')).offset().top}, 750,'swing');
        });
    });
}



function adicionarAlimento(){
    setParametro("codigo", $("#codigo").val());
    setParametro("porcao", $("#porcaoAlimento").text());
    acessarPaginaComParametros("adicionaAlimento");
}

$(document).ready(function(){
    efeitoDaAncora();
    renderizarColher("gordura");
    renderizarColher("sal");
    renderizarColher("acucar");
    $("#adicionaAlimento").on("click", adicionarAlimento);

})

//]]>