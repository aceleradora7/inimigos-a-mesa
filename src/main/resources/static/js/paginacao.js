function getCaminho(){
    return window.location.pathname.replace("/", "");
}

function onClickPrimeiraPagina(){
    var parametros = getParametros();
    parametros["pagina"] = 1;
    acessarPaginaComParametros(getCaminho());
}

function onClickUltimaPagina(){
    var ultimaPagina = $(".pagination .pagina").last().text();
    getParametros()["pagina"] = ultimaPagina;
    acessarPaginaComParametros(getCaminho());
}

function onClickPaginas(){
     var parametros = getParametros();
     parametros["pagina"] = $(this).text();
     acessarPaginaComParametros(getCaminho());
}

function onClickProximaPagina(){
     var parametros = getParametros();
     setParametro("pagina", parseInt(parametros["pagina"])+1);

     acessarPaginaComParametros(getCaminho());
}

function onClickPaginaAnterior(){
     var parametros = getParametros();
     setParametro("pagina", parametros["pagina"]-1);

     acessarPaginaComParametros(getCaminho());
}

function marcaBotaoPaginaAtual(){
    var paginas = $(".pagination");

    if(getParametros()["pagina"] === 1){
        $(".pagination .pagina").first().toggleClass("pagina-atual");
        $(".pagination .pagina").first().on("click", function(){return false;});
        return;
    }

    var botoesPaginas = paginas.find(".pagina").each(function(){

        if($(this).text() === getParametros()["pagina"]){
            $(this).toggleClass("pagina-atual");
            $(this).on("click", function(){return false;});
        }
    });
}



function associarEventosPaginacao(){
    var paginas = $(".pagination");
    paginas.on("click", ".pagina", onClickPaginas);
    paginas.on("click", "#proxima-pagina", onClickProximaPagina);
    paginas.on("click", "#pagina-anterior", onClickPaginaAnterior);

    paginas.on("click", "#primeira-pagina", onClickPrimeiraPagina);
    paginas.on("click", "#ultima-pagina", onClickUltimaPagina);
};

$(document).ready(function(){
    if(getParametros()["pagina"] === undefined){
        setParametro("pagina", 1);
    }
    associarEventosPaginacao();
    marcaBotaoPaginaAtual();
});