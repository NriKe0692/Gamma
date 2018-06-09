var app = angular.module("app", []);
app.controller("verTransaccionController", function ($scope, $http) {

    $scope.listarTransaccion = function () {

        $scope.Arraytransaccion = [];
        $http({
            method: 'GET',
            url: 'listarTransacciones'
        }).success(function (data, status, headers, config) {

            for (i = 0; i < data.length; i++) {
                $scope.Arraytransaccion.push(data[i]);
            }
        }).error(function (data, status, headers, config) {
        });
    };

    $scope.filtrarPorTipo = function () {
        $scope.Arraytransaccion = [];
        var datocodigo = jQuery("#txtcodigoprueb").val();
        if (jQuery("#sltTipo").val() === "Entradas") {
            jQuery("#sltproveedor").prop('disabled', false);
            jQuery("#sltdestino").prop('disabled', 'disabled');
            $http({
                method: 'GET',
                url: 'listarporEntradas'
            }).success(function (data, status, headers, config) {

                for (i = 0; i < data.length; i++) {
                    $scope.Arraytransaccion.push(data[i]);
                }
            }).error(function (data, status, headers, config) {
            });
        } else if (jQuery("#sltTipo").val() === "Salidas") {
            jQuery("#sltdestino").prop('disabled', false);
            jQuery("#sltproveedor").prop('disabled', 'disabled');
            $http({
                method: 'GET',
                url: 'listarporSalida'
            }).success(function (data, status, headers, config) {

                for (i = 0; i < data.length; i++) {
                    $scope.Arraytransaccion.push(data[i]);
                }
            }).error(function (data, status, headers, config) {
            });
        } else if (jQuery("#sltTipo").val() === "Todos") {
            jQuery("#sltproveedor").prop('disabled', 'disabled');
            jQuery("#sltdestino").prop('disabled', 'disabled');
            $http({
                method: 'GET',
                url: 'listarTransacciones'
            }).success(function (data, status, headers, config) {

                for (i = 0; i < data.length; i++) {
                    $scope.Arraytransaccion.push(data[i]);
                }
            }).error(function (data, status, headers, config) {
            });
        }

    };


    $scope.filtrarporProveedor = function () {
        $scope.Arraytransaccion = [];
        if (jQuery("#sltproveedor").val() === "todos") {
            $http({
                method: 'GET',
                url: 'listarporEntradas'
            }).success(function (data, status, headers, config) {

                for (i = 0; i < data.length; i++) {
                    $scope.Arraytransaccion.push(data[i]);
                }
            }).error(function (data, status, headers, config) {
            });
        } else {
            $http({
                url: 'listarentradasproveedor',
                method: 'POST',
                data: JSON.stringify($scope.filtro),
                headers: {'content-type': 'application/json'}
            }).then(function (response) {
                // $scope.ArrayUsu.push(response.data);
            }, function (response) {
                //fail case
                // console.log(response);
                $scope.message = response;
            });
            $http({
                method: 'GET',
                url: 'listarentradasproveedor'
            }).success(function (data, status, headers, config) {

                for (i = 0; i < data.length; i++) {
                    $scope.Arraytransaccion.push(data[i]);
                }
            }).error(function (data, status, headers, config) {
            });

        }




    };
    $scope.filtrarporDestino = function () {
        $scope.Arraytransaccion = [];
        if (jQuery("#sltdestino").val() === "todos") {
            $http({
                method: 'GET',
                url: 'listarporSalida'
            }).success(function (data, status, headers, config) {

                for (i = 0; i < data.length; i++) {
                    $scope.Arraytransaccion.push(data[i]);
                }
            }).error(function (data, status, headers, config) {
            });

        }
        {

            $scope.filtro2;
            $http({
                url: 'listarsalidasdestino',
                method: 'POST',
                data: JSON.stringify($scope.filtro2),
                headers: {'content-type': 'application/json'}
            }).then(function (response) {
                // $scope.ArrayUsu.push(response.data);
            }, function (response) {
                //fail case
                // console.log(response);
                $scope.message = response;
            });
            $http({
                method: 'GET',
                url: 'listarsalidasdestino'
            }).success(function (data, status, headers, config) {

                for (i = 0; i < data.length; i++) {
                    $scope.Arraytransaccion.push(data[i]);
                }
            }).error(function (data, status, headers, config) {
            });


        }


    };
});

app.controller("transaccionentradaController", function ($scope, $http) {
    $scope.Arraydecodigos = [];
    $http({
        method: 'GET',
        url: 'listarProducto'
    }).success(function (data, status, headers, config) {

        for (i = 0; i < data.length; i++) {
            $scope.Arraydecodigos.push(data[i]);
        }
    }).error(function (data, status, headers, config) {
    });


    $scope.buscarProducto = function () {
        console.log($scope.nuevaTransaccionEntrada);

        $http({
            url: 'datosproducto',
            method: 'POST',
            data: JSON.stringify($scope.nuevaTransaccionEntrada),
            headers: {'content-type': 'application/json'}
        }).then(function (response) {
            $scope.nuevaTransaccionEntrada = response.data;

            //  $scope.datosproducto.push(response.data);
            /// console.log(response.data);
        }
        , function (response) {
            //fail case
            // console.log(response);
            //$scope.datosproducto=response;

        }
        );


    };

    $scope.registrarnuevaTransaccionEntrada = function () {

        $scope.Arraytransaccionentrada = [];
        console.log($scope.nuevaTransaccionEntrada);
        if (jQuery("#prove").val() === "" || jQuery("#producto1").val() === "" || jQuery("#stock1").val() === "" || jQuery("#txtinventariotran1").val() === "" || jQuery("#txtnroFacturatran1").val() === "" ||
                jQuery("#datefechaFactura1").val() === "" || jQuery("#txtObservaciones1").val() === "")
        {
            $scope.MessageFaild = "Ingresar todos los campos";

            jQuery("#pnlAlerttransaccion2").slideDown('slow');
            setTimeout(function () {
                jQuery("#pnlAlerttransaccion2").slideUp('slow');
            }, 3000);
        } else {
            $http({
                url: 'registrartransaccionentrada',
                method: 'POST',
                data: JSON.stringify($scope.nuevaTransaccionEntrada),
                headers: {'content-type': 'application/json'}
            }).then(function (response) {
                $scope.Arraytransaccionentrada.push(response.data);
                $scope.nuevaTransaccionEntrada = "";
            }, function (response) {
                //fail case
                // console.log(response);
                $scope.message = response;
            });
            $scope.MessageFaild = "Inventario actualizado";
            jQuery("#pnlAlerttransaccion1").slideDown('slow');
            setTimeout(function () {
                jQuery("#pnlAlerttransaccion1").slideUp('slow');
            }, 3000);
        }



    };


});


app.controller("registrarTransaccionSalidaController", function ($scope, $http) {
    $scope.Arraydecodigos = [];


    $http({
        method: 'GET',
        url: 'listarProducto'
    }).success(function (data, status, headers, config) {

        for (i = 0; i < data.length; i++) {
            $scope.Arraydecodigos.push(data[i]);
        }
    }).error(function (data, status, headers, config) {
    });


    $scope.buscarProducto = function () {
        console.log($scope.nuevatransaccionSalida);

        $http({
            url: 'datosproducto',
            method: 'POST',
            data: JSON.stringify($scope.nuevatransaccionSalida),
            headers: {'content-type': 'application/json'}
        }).then(function (response) {
            $scope.nuevatransaccionSalida = response.data;

            //  $scope.datosproducto.push(response.data);
            /// console.log(response.data);
        }
        , function (response) {
            //fail case
            // console.log(response);
            //$scope.datosproducto=response;

        }
        );


    };


    $scope.registrarnuevaTransaccionSalida = function () {
        $scope.Arraytransaccionsalida = [];
        console.log($scope.nuevatransaccionSalida);
        if (jQuery("#sltdestinosalida").val() === "" || jQuery("#txtserieproductosalida").val() === "" || jQuery("#txtstockproductosalida").val() === "" || jQuery("#txtinventariosalida").val() === "" || jQuery("#txtnrofacturasalida").val() === "" ||
                jQuery("#txtfechafacturasalida").val() === "" || jQuery("#txtobservacionessalida").val() === "")
        {
            $scope.MessageFaild = "Ingresar todos los campos";
            jQuery("#pnlAlerttransaccion3").slideDown('slow');
            setTimeout(function () {
                jQuery("#pnlAlerttransaccion3").slideUp('slow');
            }, 3000);

        } else {
            if (parseInt(jQuery("#txtstockproductosalida").val()) < parseInt(jQuery("#txtinventariosalida").val()))
            {
                $scope.MessageFaild = "Monto de salida supera stock.";
                jQuery("#pnlAlerttransaccion3").slideDown('slow');
                setTimeout(function () {
                    jQuery("#pnlAlerttransaccion3").slideUp('slow');
                }, 3000);
            }else{
            $http({
                url: 'registrarTransaccionSalida',
                method: 'POST',
                data: JSON.stringify($scope.nuevatransaccionSalida),
                headers: {'content-type': 'application/json'}
            }).then(function (response) {
                $scope.Arraytransaccionsalida.push(response.data);
                $scope.nuevatransaccionSalida = "";
            }, function (response) {
                //fail case
                // console.log(response);
                $scope.message = response;
            });
            $scope.MessageFaild = "Inventario actualizado";
            jQuery("#pnlAlerttransaccion4").slideDown('slow');
            setTimeout(function () {
                jQuery("#pnlAlerttransaccion4").slideUp('slow');
            }, 3000);
        }

        }

    };


}

);

 