function cycleImages(){

      var $active = $('#background_cycler .active');
      var $next = ($('#background_cycler .active').next().length > 0) ? $('#background_cycler .active').next() : $('#background_cycler img:first');
      $next.css('z-index',2);
	  $active.fadeOut(1500,function(){
	  $active.css('z-index',1).show().removeClass('active');
      $next.css('z-index',3).addClass('active');
      });
    }

$(window).load(function(){
    $("#2").hide();
    $("#3").hide();
    $("#4").hide();
    $("#5").hide();
    $("#5").show();
    $("#4").show();
    $("#3").show();
    $("#2").show();
    $("#1").show();
    $('#background_cycler').fadeIn(1500);
    setInterval('cycleImages()', 5000);
})