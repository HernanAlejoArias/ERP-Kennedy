$(document).ready(function(){

    var facturarPedido;
    var ingresoPedido;

    setListeners();

});


function setListeners(){
    $("#guardar-cliente").click(function(event){
        event.preventDefault();
        var nuevoClienteInformacion = $('form#datos-cliente').serializeArray();
        var nuevoCliente = {};

        for(var i = 0; i < nuevoClienteInformacion.length; i++){
            nuevoCliente[nuevoClienteInformacion[i].name] = nuevoClienteInformacion[i].value;
        }

        $.post({
			url: "/api/guardar-cliente",
			data: JSON.stringify(nuevoCliente),
			dataType: "text",
            contentType: "application/json"})
        .done(function(){console.log("DONE")})
        .fail(function(){console.log("FAIL")})
    })

    $("#btn-client-id-search").click(function(event){
        event.preventDefault();

        let idCliente = $('#InputIdCliente').val();
        let apiCallURL = "/api/buscar-cliente/" + idCliente;

        $.get(apiCallURL, function (responseData){
            console.log("GET")
        })
        .done(function(responseData){
            console.log("DONE");
            $.each(responseData,function(data){
                if(data === "idTipoCliente" ){
                    $("select[name='" + data + "']" ).val(responseData[data]);
                } else {
                    $("input[name='" + data + "']" ).val(responseData[data]);      
                }
            })
        })
        .fail(function(responseData){
            console.log("FAIL")
        })
    })

    $("#btn-guardar-pedido").click(function(event){
        var nuevoPedido = {
            idCliente: $("#InputIdCliente").val(),
            idVendedor: $("#InputIdCliente").val(),
            idModoPago: $("#InputModoPago").val(),
            items: []
        };


        $("#pedido-items .item").each(function(index, tableLine){
            event.preventDefault();

            var item = {
                producto: $(tableLine).find(".item-id-producto").val(),
                cantidad: $(tableLine).find(".item-cantidad-producto").val()
            }

            if (item.producto != ""){
                nuevoPedido.items.push({producto: $(tableLine).find(".item-id-producto").val(),
                cantidad: $(tableLine).find(".item-cantidad-producto").val()})
            }
        });

        if(nuevoPedido.items.length > 0){
        
            $.post({
                url: "/api/alta-pedido",
                data: JSON.stringify(nuevoPedido),
                dataType: "text",
                contentType: "application/json"})
            .done(function(responseData){
                console.log("DONE")
                getPedido(JSON.parse(responseData).NuevoPedido);
            })
            .fail(function(){
                console.log("FAIL")})
        }

    });

    $("#btn-pedido-nro-search").click(function(event){
        event.preventDefault();

        let idPedido = $('#InputNroPedido').val();
        getPedido(idPedido);

    })

    $("#btn-pedido-material-nro-search").click(function(event){
        event.preventDefault();

        let idPedido = $('#InputNroPedido').val();
        getPedidoMaterial(idPedido);

    })

    $("#btn-facturar-pedido").click(function(event){
        event.preventDefault();

        console.log(facturarPedido);
        generarFactura(facturarPedido);

    })

    $("btn-cancelar-pedido").click(function(event){
        event.preventDefault();
        location.reload();
    })


    $("#btn-guardar-pedido-mat").click(function(event){
        var nuevoPedido = {
            idProveedor: $("#InputIdProveedor").val(),
            items: []
        };


        $("#pedido-items .item").each(function(index, tableLine){
            event.preventDefault();

            var item = {
                material: $(tableLine).find(".item-id-material").val(),
                cantidad: $(tableLine).find(".item-cantidad-material").val()
            }

            if (item.material != ""){
                nuevoPedido.items.push({material: $(tableLine).find(".item-id-material").val(),
                cantidad: $(tableLine).find(".item-cantidad-material").val()})
            }
        });

        if(nuevoPedido.items.length > 0){
        
            $.post({
                url: "/api/alta-pedido-material",
                data: JSON.stringify(nuevoPedido),
                dataType: "text",
                contentType: "application/json"})
            .done(function(responseData){
                console.log("DONE")
                getPedidoMaterial(JSON.parse(responseData).NuevoPedidoMaterial);
            })
            .fail(function(){
                console.log("FAIL")})
        }
    });

    $("#btn-entrada-mercaderia").click(function(event){
        event.preventDefault();

        let apiCallURL = "/api/entrada-material/" + ingresoPedido;

        $.post(apiCallURL, function(responseData){
            console.log("Generando Entrada de Material")
        })
        .done(function(responseData){
            alert("Entrada de Material completa");
        })
        .fail(function(responseData){
            console.log(responseData.responseText)
        })

    });


}

function getPedido(nroPedido){
    let apiCallURL = "http://localhost:8080/api/buscar-pedido/" + nroPedido;

    $.get(apiCallURL, function (responseData){
        console.log("GET")
    })
    .done(function(responseData){
        console.log("DONE");
        $.each(responseData,function(data){
            if(data === "items" ){
                for(var i = 0; i < responseData[data].length; i++){
                    $("#tr-" + i + " .item-id-producto").val(responseData[data][i].producto.descripcion);
                    $("#tr-" + i + " .item-cantidad-producto").val(responseData[data][i].cantidad);
                    $("#tr-" + i + " .item-precio-producto").val(responseData[data][i].producto.precio);
                    $("#tr-" + i + " .item-sub-total").val(responseData[data][i].producto.precio * responseData[data][i].cantidad);
                }
            } else {
                $("input[name='" + data + "']" ).val(responseData[data]);      
            }
        })
        facturarPedido = nroPedido;
    })
    .fail(function(responseData){
        console.log("FAIL")
    })    
}

function getPedidoMaterial(nroPedido){
    let apiCallURL = "http://localhost:8080/api/buscar-pedido-material/" + nroPedido;

    $.get(apiCallURL, function (responseData){
        console.log("GET")
    })
    .done(function(responseData){
        console.log("DONE");
        $.each(responseData,function(data){
            if(data === "items" ){
                for(var i = 0; i < responseData[data].length; i++){
                    $("#tr-" + i + " .item-id-material").val(responseData[data][i].material.descripcion);
                    $("#tr-" + i + " .item-cantidad-material").val(responseData[data][i].cantidad);
                }
            } else {
                $("input[name='" + data + "']" ).val(responseData[data]);      
            }
        })
        ingresoPedido = nroPedido;
    })
    .fail(function(responseData){
        console.log("FAIL")
    })    
}

function generarFactura(idPedido){
    let apiCallURL = "http://localhost:8080/api/validar-stock/" + idPedido;

    $.get(apiCallURL, function (responseData){
        console.log("GET")
    })
    .done(function(responseData){
            crearFactura(idPedido);
    })
    .fail(function(responseData){
        alert(responseData.responseText);
        crearOrdenTrabajo(idPedido);
    })
}

function crearOrdenTrabajo(idPedido){
    console.log("Crear Orden de Trabajo " + idPedido);

    let apiCallURL = "http://localhost:8080/api/crear-orden-trabajo/" + idPedido;

    $.post(apiCallURL, function(responseData){
        console.log("Generando OTs")
    })
    .done(function(responseData){
        alert("IDs Orden de Trabajo Creadas: " + responseData.OrdenesCreadas);
    })
    .fail(function(responseData){
        console.log(responseData.responseText)
    })

}

function crearFactura(idPedido){
    console.log("Crear Factura " + idPedido);

    let apiCallURL = "http://localhost:8080/api/facturar/" + idPedido;

    $.post(apiCallURL, function(responseData){
        console.log("Generando Factura")
    })
    .done(function(responseData){
        alert("Factura Generada: " + responseData.NuevaFactura);
    })
    .fail(function(responseData){
        console.log(responseData.responseText)
    })
}