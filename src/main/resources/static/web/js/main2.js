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

        $("#guardar-categoria").click(function(event){
            event.preventDefault();
            var nuevaCategoriaInformacion = $('form#alta-categoria').serializeArray();
            var nuevaCategoria = {};

             for(var i = 0; i < nuevaCategoriaInformacion.length; i++){
                  nuevaCategoria[nuevaCategoriaInformacion[i].name] = nuevaCategoriaInformacion[i].value;
             }

                $.post({
                url: "/api/alta-categoria",
                data: JSON.stringify(nuevaCategoria),
            	dataType: "text",
                contentType: "application/json"})
             .done(function(){console.log("DONE")})
             .fail(function(){console.log("FAIL")})
        })


        $("#guardar-carrera").click(function(event){
            event.preventDefault();
            var nuevaCarreraInformacion = $('form#alta-carrera').serializeArray();
            var nuevaCarrera = {};

             for(var i = 0; i < nuevaCarreraInformacion.length; i++){
                  nuevaCarrera[nuevaCarreraInformacion[i].name] = nuevaCarreraInformacion[i].value;
             }

                $.post({
                url: "/api/alta-carrera",
                data: JSON.stringify(nuevaCarrera),
            	dataType: "text",
                contentType: "application/json"})
             .done(function(){console.log("DONE")})
             .fail(function(){console.log("FAIL")})
        })

         $("#guardar-familiar").click(function(event){
                    event.preventDefault();
                    var nuevoFamiliarInformacion = $('form#alta-familiar').serializeArray();
                    var nuevoFamiliar = {};

                     for(var i = 0; i < nuevoFamiliarInformacion.length; i++){
                          nuevoFamiliar[nuevoFamiliarInformacion[i].name] = nuevoFamiliarInformacion[i].value;
                     }

                        $.post({
                        url: "/api/alta-familiar",
                        data: JSON.stringify(nuevoFamiliar),
                        dataType: "text",
                        contentType: "application/json"})
                     .done(function(){console.log("DONE")})
                     .fail(function(){console.log("FAIL")})
                })

                 $("#guardar-Estudios").click(function(event){
                            event.preventDefault();
                            var nuevoEstudioInformacion = $('form#alta-Estudios').serializeArray();
                            var nuevoEstudio = {};

                             for(var i = 0; i <nuevoEstudioInformacion.length; i++){
                                  nuevoEstudio[nuevoEstudioInformacion[i].name] = nuevoEstudioInformacion[i].value;
                             }

                                $.post({
                                url: "/api/alta-Estudios",
                                data: JSON.stringify(nuevoEstudio),
                                dataType: "text",
                                contentType: "application/json"})
                             .done(function(){console.log("DONE")})
                             .fail(function(){console.log("FAIL")})
                        })


}