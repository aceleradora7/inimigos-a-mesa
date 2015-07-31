//  <![CDATA[

$(document).ready(function(){

    var parametros = getParametros();

    if(parametros["codigo"] != undefined){
        $("codigo").val(parametros["codigo"]);
    }



    cloudinary.applyUploadWidget(document.getElementById('upload_widget_opener'),
   //$('#upload_widget_opener').cloudinary_upload_widget(
                { cloud_name: 'dq5mndrjt',
                  upload_preset: 'yga4od15',
                  multiple: false,
                  sources: ['local'],
                  client_allowed_formats: ['png','jpg','jpeg'],
                  button_class: 'btn btn-success',
                  button_caption: 'Escolha uma Imagem',
                  theme: 'white',
                },

               function(error, result) {
                    console.log(error, result);
                    var meuResult = JSON.stringify(result, null, 2);
                    var json = JSON.stringify(result);
                    var jsonObject = JSON.parse(json);
                    var url = jsonObject[0].url;
                    var publicId = jsonObject[0].public_id;

                    var tamanhoPequeno = "/c_fit,w_108/";
                    var tamanhoGrande = "/c_fit,w_390/";

                    var urlParte1 = url.slice(0,48);
                    var urlParte2 = url.slice(49,url.length);

                    var urlImagemPequena = urlParte1.concat(tamanhoPequeno);
                    var urlImagemPequenaFinal = urlImagemPequena.concat(urlParte2);

                    var urlImagemGrande = urlParte1.concat(tamanhoGrande);
                    var urlImagemGrandeFinal = urlImagemGrande.concat(urlParte2);

//                    $( ".cloudinary-thumbnails" ).remove();

                    $( "#imagemAlimento" ).replaceWith( " <img src='"+urlImagemGrandeFinal+"' id='imagemAlimento' alt='Imagem do Alimento'/>" );


                    $("#urlImagemPequena").val(urlImagemPequenaFinal);
                    $("#urlImagemGrande").val(urlImagemGrandeFinal);
                }
           );
});


//]]>

