//  <![CDATA[



+ function ($) {
    'use strict';

    // UPLOAD CLASS DEFINITION
    // ======================

    var dropZone = $('#drop-zone');
    var uploadForm = $('#js-upload-form');

    var startUpload = function(files) {
        console.log(files)
    }

    uploadForm.on('submit', function(e) {
        var uploadFiles = $('#js-upload-files').files;
        e.preventDefault();

        startUpload(uploadFiles);
    })

    dropZone.ondrop = function(e) {
        e.preventDefault();
        this.className = 'upload-drop-zone';

        startUpload(e.dataTransfer.files);
    }

    dropZone.ondragover = function() {
        this.className = 'upload-drop-zone drop';
        return false;
    }

    dropZone.ondragleave = function() {
        this.className = 'upload-drop-zone';
        return false;
    }

}(jQuery);


$(document).ready(function(){

    var parametros = getParametros();

    if(parametros["codigo"] != undefined){
        $("codigo").val(parametros["codigo"]);
    }

    $('#upload_widget_opener').cloudinary_upload_widget(
                                            { cloud_name: 'dq5mndrjt', upload_preset: 'yga4od15'},
                                            function(error, result) {
                                                console.log(error, result);
                                                var meuResult = JSON.stringify(result, null, 2);
                                                var urlm = meuResult.replace('"url": "', "Site");

                                                var urlInicio = urlm.indexOf("Site");
                                                var urlFim = urlm.indexOf("secure_url");

                                                var urla = urlm.slice(urlInicio+4, urlFim-8);

                                                var tamanhoPequeno = "/c_fit,w_108/";
                                                var tamanhoGrande = "/c_fit,w_390/";

                                                var urlParte1 = urla.slice(0,48);
                                                var posicaoFinal = urla.lastIndexOf(".png")+4;
                                                var urlParte2 = urla.slice(49,posicaoFinal);

                                                var urlImagemPequena = urlParte1.concat(tamanhoPequeno);
                                                var urlImagemPequenaFinal = urlImagemPequena.concat(urlParte2);

                                                var urlImagemGrande = urlParte1.concat(tamanhoGrande);
                                                var urlImagemGrandeFinal = urlImagemGrande.concat(urlParte2);

                                                $("#urlImagemPequena").val(urlImagemPequenaFinal);
                                                $("#urlImagemGrande").val(urlImagemGrandeFinal);
                                            }
                                       );
});


//]]>

