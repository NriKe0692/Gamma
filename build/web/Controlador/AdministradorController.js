var app = angular.module("Myapp", []);
app.controller("adminUsuController", function ($scope, $http) {

    $scope.Listar = function () {
        $scope.ArrayUsu = [];
        $http({
            method: 'GET',
            url: 'listarUsuarioController'
        }).success(function (data, status, headers, config) {

            for (i = 0; i < data.length; i++) {
                $scope.ArrayUsu.push(data[i]);
            }
        }).error(function (data, status, headers, config) {
        });

    };

    $scope.registrarUsuario = function () {
        var datos = $scope.nuevoUsuario;
        $scope.MessageFaild = "";
        var expr = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

        if (jQuery("#txtcodigousu").val() === "" || jQuery("#txtnombreusu").val() === "" || jQuery("#txtapellidopusu").val() === "" || jQuery("#txtapellidomusu").val() === "" || jQuery("#txtdireccionusu").val() === "" ||
                jQuery("#txtcorreousu").val() === "" || jQuery("#txttelefonousu").val() === "" || jQuery("#sltgenerousu").val() === "" || jQuery("#txtclaveusu").val() === "" || jQuery("#txtpuestousu").val() === "")
        {

            $scope.MessageFaild = "Ingresar todos los campos";
            jQuery("#pnlAlert2").slideDown('slow');
            setTimeout(function () {
                jQuery("#pnlAlert2").slideUp('slow');
            }, 3000);

        } else {

            if (!expr.test(jQuery("#txtcorreousu").val())) {
                $scope.MessageFaild = "El correo ingresado es incorrecto";
                jQuery("#pnlAlert2").slideDown('slow');
                setTimeout(function () {
                    jQuery("#pnlAlert2").slideUp('slow');
                }, 3000);
            } else {
                console.log(datos);
                $http({
                    url: 'registrarUsuario',
                    method: 'POST',
                    data: JSON.stringify(datos),
                    headers: {'content-type': 'application/json'}
                }).then(function (response) {
                    $scope.ArrayUsu.push(response.data);
                }, function (response) {
                    //fail case
                    console.log(response);
                    $scope.message = response;
                });
                $scope.MessageFaild = "Se Registro Correctamente";
                jQuery("#pnlAlert1").slideDown('slow');
                setTimeout(function () {
                    jQuery("#pnlAlert1").slideUp('slow');
                }, 3000);
            }
        }

    };

});


app.controller("adminproveeController", function ($scope, $http) {

     $scope.ArrayDestri = [];
    $http({
        method: 'GET',
        url: 'listarlosDistritos'
    }).success(function (data, status, headers, config) {
         
        for (i = 0; i < data.length; i++) {
            $scope.ArrayDestri.push(data[i]);
        }
        console.log($scope.ArrayDestri);
    }).error(function (data, status, headers, config) {
    });



    $scope.listarProveedor = function () {

        $scope.ArrayProveedor = [];

        $http({
            method: 'GET',
            url: 'listarProveedor'
        }).success(function (data, status, headers, config) {

            for (i = 0; i < data.length; i++) {
                $scope.ArrayProveedor.push(data[i]);
            }
        }).error(function (data, status, headers, config) {
        });

    };
    $scope.registrarNuevoProveedor = function () {
        var datos = $scope.nuevoProveedor;
        var expr = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

        if (jQuery("#txtrucprov").val() === "" || jQuery("#txtempresaprov").val() === "" || jQuery("#txtcorreoprov").val() === "" || jQuery("#txtcelularprov").val() === "" || jQuery("#txtdireccionprov").val() === "" ||
                jQuery("#sltdistritoprov").val() === "")
        {
            $scope.MessageFaild = "Ingresar todos los campos";
            jQuery("#pnlproveedorAlert2").slideDown('slow');
            setTimeout(function () {
                jQuery("#pnlproveedorAlert2").slideUp('slow');
            }, 3000);

        } else {

            if (!expr.test(jQuery("#txtcorreoprov").val())) {
                $scope.MessageFaild = "El correo ingresado es incorrecto";
                jQuery("#pnlproveedorAlert2").slideDown('slow');
                setTimeout(function () {
                    jQuery("#pnlproveedorAlert2").slideUp('slow');
                }, 3000);
            } else {
                $http({
                    url: 'registrarProveedor',
                    method: 'POST',
                    data: JSON.stringify(datos),
                    headers: {'content-type': 'application/json'}
                }).then(function (response) {
                    $scope.ArrayProveedor.push(response.data);
                }, function (response) {
                    //fail case
                    console.log(response);
                    $scope.message = response;
                });

                $scope.MessageFaild = "Se ha registrado correctamente";
                jQuery("#pnlAlertproveedor1").slideDown('slow');
                setTimeout(function () {
                    jQuery("#pnlAlertproveedor1").slideUp('slow');
                }, 3000);
            }

        }
    };



});

app.controller("adminProductoController", function ($scope, $http) {
    $scope.ArraydeProveedores = [];
    $http({
        method: 'GET',
        url: 'listarProveedor'
    }).success(function (data, status, headers, config) {

        for (i = 0; i < data.length; i++) {
            $scope.ArraydeProveedores.push(data[i]);
        }
    }).error(function (data, status, headers, config) {
    });


    $scope.listarProductos = function () {

        $scope.ArrayProducto = [];
        $http({
            method: 'GET',
            url: 'listarProducto'
        }).success(function (data, status, headers, config) {

            for (i = 0; i < data.length; i++) {
                $scope.ArrayProducto.push(data[i]);
            }
        }).error(function (data, status, headers, config) {
        });

    };
    $scope.registrarNuevoProducto = function () {

        var datos = $scope.nuevoProducto;

        if (jQuery("#txtserie").val() === "" || jQuery("#txtmotor").val() === "" || jQuery("#txtalternador").val() === "" || jQuery("#txtprecio").val() === "" || jQuery("#txtprecioventa").val() === "" ||
                jQuery("#txtstock").val() === "" || jQuery("#txtdescripcion").val() === "" || jQuery("#sltproveedor").val() === "" || jQuery("#sltcategoria").val() === "")
        {

            $scope.MessageFaild = "Ingresar todos los campos";
            jQuery("#pnlAlertproducto2").slideDown('slow');
            setTimeout(function () {
                jQuery("#pnlAlertproducto2").slideUp('slow');
            }, 3000);

        } else {

            $http({
                url: 'registrarProducto',
                method: 'POST',
                data: JSON.stringify(datos),
                headers: {'content-type': 'application/json'}
            }).then(function (response) {
                $scope.ArrayProducto.push(response.data);
            }, function (response) {
                //fail case
                console.log(response);
                $scope.message = response;
            });

            $scope.MessageFaild = "Se registro Correctamente";
            jQuery("#pnlAlertproducto1").slideDown('slow');
            setTimeout(function () {
                jQuery("#pnlAlertproducto1").slideUp('slow')
            }, 3000);

        }



    };


});