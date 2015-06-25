function calculaMedidasVisuais(){
    var colher = 0;
    var calorias = document.getElementById('valor-caloria').innerHTML;

    if (calorias != 0){
       colher = calorias / 4;
       console.log("colheres" + colher);
       var teste = mostraColher(colher);

       return teste;
    }
}

function mostraColher(numeroDeColheres) {

    var img = document.createElement("IMG");
    img.src = "img/colher.png";

    for (i = 0; i <= numeroDeColheres; i++){
       var colherinha =  colherinha + '1';
    }
    return colherinha;
}

/*"<div id="imagem-colher" class="colher">
                 <img id="image" src="img/colher.png" class="img-rounded media-object colher-img"/>
             </div>" */