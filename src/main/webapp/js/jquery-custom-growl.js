function growl(message, type, position) {
    var alretType = 'alert-' + type;
    var $growlCustom = $('#growl-custom');
    $growlCustom.removeAttr('class');
    $growlCustom.html(message);
    var positionHeight = 0;
    var positionWidth = 0;
    switch (position) {

        case 'buttom':
            positionWidth = ($(window).outerWidth() / 2) - ($growlCustom.outerWidth() / 2);
            positionHeight = ($(window).outerHeight() + $('body').scrollTop()) - 100;
            break;
        case 'top':
            positionWidth = ($(window).outerWidth() / 2) - ($growlCustom.outerWidth() / 2);
            positionHeight = (($('body').height() + 30) - (($(window).innerHeight())));
            break;
        default :
            positionWidth = ($(window).outerWidth() / 2) - ($growlCustom.outerWidth() / 2);
            positionHeight = ($(window).outerHeight() - $('body').scrollTop());
    }
    $growlCustom.css('top', positionHeight);
    $growlCustom.css('left', positionWidth);
    $growlCustom.addClass(alretType).fadeIn(1000).fadeOut(2000);
}