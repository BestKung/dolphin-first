function growl(message, type) {
    var alretType = 'alert-' + type;
    var $growlCustom = $('#growl-custom');
    $growlCustom.removeAttr('class');
    $growlCustom.html(message);
    var windowWidth = ($(window).outerWidth()/2) - ($growlCustom.outerWidth()/2);
    var windowHeight = ($(window).outerHeight() + $('body').scrollTop()) - 100;
     
    $growlCustom.css('top', windowHeight);
    $growlCustom.css('left', windowWidth);
    $growlCustom.addClass(alretType).fadeIn(1000).fadeOut(2000);
}