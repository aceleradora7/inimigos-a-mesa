//  <![CDATA[
function mostraColherGordura(){
   var colher = 0;
   var gordura =   $("#valor-gordura").attr("value");

   if (gordura != 0){
        colher = gordura / 2;
        colher = parseInt(colher);
       $("#imagem-colher-gordura").empty();
       for(i=0; i <= colher; i++){
            $("#imagem-colher-gordura").append($("#template-colher").find("img").clone());
       }
   }else {
        $("#imagem-colher-gordura").empty();
        $("#imagem-colher-gordura").append($("#template-sem-colher").find("p").clone());
   }
}

function mostraColherAcucar(){
   var colher = 0;
   var acucar =   $("#valor-acucar").attr("value");

   if (acucar != 0){
        colher = acucar / 1.76;
        colher = parseInt(colher);
       $("#imagem-colher-acucar").empty();
       for(i=0; i <= colher; i++){
            $("#imagem-colher-acucar").append($("#template-colher").find("img").clone());
       }
   }else {
            $("#imagem-colher-acucar").empty();
            $("#imagem-colher-acucar").append($("#template-sem-colher").find("p").clone());
       }
}

function mostraColherSal(){
   var colher = 0;
   var sodio =   $("#valor-sodio").attr("value");
   var sal = ((sodio * 100) / 39) *0.001 ;
   if (sal != 0){
        colher = sal / 2.06;
        colher = parseInt(colher);
       $("#imagem-colher-sal").empty();
       for(i=0; i <= colher; i++){
            $("#imagem-colher-sal").append($("#template-colher").find("img").clone());
       }
   }else {
            $("#imagem-colher-sal").empty();
            $("#imagem-colher-sal").append($("#template-sem-colher").find("p").clone());
       }
}


$(document).ready(function(){

    mostraColherGordura();
    mostraColherAcucar();
    mostraColherSal();

})


//]]>