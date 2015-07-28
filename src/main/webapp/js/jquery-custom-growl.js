function growl(message, type) {
    var alretType = 'alert-' + type;
    $('#growl-custom').removeAttr('class');
    var windowWidth = ($(window).outerWidth()/2) - ($('#growl-custom').outerWidth()/2);
    var windowHeight = ($(window).outerHeight() + $('body').scrollTop()) - 80;
   
    $('#growl-custom').css('top', windowHeight);
    $('#growl-custom').css('left', windowWidth);
    $('#growl-custom').html(message).addClass(alretType).fadeIn(1000).fadeOut(2000);
}