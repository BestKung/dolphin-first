function growl(message, type) {
        var alretType = 'alert-' + type;
         $('#growl-custom').removeAttr('class');
        $('#growl-custom').html(message).addClass(alretType).fadeIn(1000).fadeOut(2000);
    }