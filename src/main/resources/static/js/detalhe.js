
function mostraColherGordura(){
   var colher = 0;
   // var calorias = document.getElementById('valor-caloria').innerHTML;
   var calorias =   $("#valor-caloria").attr("value");
      console.log(calorias);
      console.log("teste");

   if (calorias != 0){
       colher = calorias / 3;
       $("#imagem-colher-gordura").empty()
       for(i=0; i<= colher; i++){
            $("#imagem-colher-gordura").append($("#template-colher").find("img").clone())
       }
   }
}
$(document).ready(function(){
    mostraColherGordura();
});



//function calculaMedidasVisuaisGordura(){
//    var colher = 0;
//   // var calorias = document.getElementById('valor-caloria').innerHTML;
//    var calorias =   $("#valor-caloria").attr("value");
//    console.log(calorias);
//    console.log("teste");
//
//    if (calorias != 0){
//       colher = calorias / 3;
//       console.log("colheres" + colher);
//       var teste = mostraColherGordura(colher);
//
//       return teste;
//    }
//}


//$("#imagem-colher-gordura").empty()
//for(i=0;i<3;i++){
// $("#imagem-colher-gordura").append($("#template-colher").find("img").clone())
//}


//function mostraColher(numeroDeColheres) {
//
//    var img = document.createElement("img");
//    img.src = "img/colher.png";
//
//    for (i = 0; i <= numeroDeColheres; i++){
//       var colherinha =  colherinha + '1';
//    }
//    return colherinha;
//}



/*"<div id="imagem-colher" class="colher">
                 <img id="image" src="img/colher.png" class="img-rounded media-object colher-img"/>
             </div>" */