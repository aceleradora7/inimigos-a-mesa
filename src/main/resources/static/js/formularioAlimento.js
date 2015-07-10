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
});

//]]>

