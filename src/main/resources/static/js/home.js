/*<![CDATA[*/

$(function() {
    $('a.page-scroll').bind('click', function(event) {
        var $anchor = $(this);
        $('html, body').stop().animate({
            scrollTop: $($anchor.attr('href')).offset()
        }, 1500, 'easeInOutExpo');
        event.preventDefault();
    });
});

$('.navbar-collapse ul li a').click(function() {
    $('.navbar-toggle:visible').click();
});

    function efeitoDaAncora(){
        $(function() {
            $('a').bind('click',function(event){
                var $anchor = $(this);
                $('html, body').stop().animate({scrollTop: $($anchor.attr('href')).offset().top}, 750,'swing');
            });
        });
    }

    function efeitoDaHome(){
        $(function() {
            $('a').bind('click',function(event){
                var $anchor = $(this);
                $('html, body').stop().animate({scrollTop: $($anchor.attr('href')).offset().top}, 750,'swing');
            });
        });
    }

$(document).ready(function(){
    efeitoDaAncora();
})

/*]]>*/