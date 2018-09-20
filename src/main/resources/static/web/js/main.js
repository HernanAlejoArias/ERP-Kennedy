$(document).ready(function(){

    setListeners();



});


function setListeners(){
    $("#guardar-cliente").click(function(event){
        event.preventDefault();
        var nuevoClienteInformacion = $('form#alta-cliente').serializeArray();
        var nuevoCliente = {};

        for(var i = 0; i < nuevoClienteInformacion.length; i++){
            nuevoCliente[nuevoClienteInformacion[i].name] = nuevoClienteInformacion[i].value;
        }

        $.post({
			url: "/api/alta-cliente",
			data: JSON.stringify(nuevoCliente),
			dataType: "text",
            contentType: "application/json"})
        .done(function(){console.log("DONE")})
        .fail(function(){console.log("FAIL")})
    })
}