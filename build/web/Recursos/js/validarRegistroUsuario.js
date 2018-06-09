function validarFormularioRegistro() {

    var nombre, apellidop, apellidom, correo, ciudad, distrito,sexo;

    nombre = document.getElementById('txtnombre').value;
    apellidop = document.getElementById('txtApellidoP').value;
    apellidom = document.getElementById('txtApellidoM').value;
    correo = document.getElementById('txtCorreo').value;
    ciudad = document.getElementById('txtCiudad').value;
    distrito = document.getElementById('txtDistrito').value;
    sexo=document.getElementsByName('sexo').value;
    if(nombre!==''&&apellidop!==''&&apellidom!==''&&correo!==''&&ciudad!==''&&distrito!==''){
     
        alert('todos los campos estan llenos');
    }
    else{
    if (nombre === "") {
        nomb = document.getElementById('txtnombre');
        nomb.style.borderColor = '#FBBDBD';
        
        return false;
    } else if (apellidop === "") {
        document.getElementById('txtApellidoP').style.borderColor = '#FBBDBD';
        nomb.style.borderColor = '#ccc';
        
        return false;
    } else if (apellidom === "") {
        document.getElementById('txtApellidoM').style.borderColor = '#FBBDBD';
        document.getElementById('txtApellidoP').style.borderColor = '#ccc';
        
        return false;
    } else if (correo === "") {
        document.getElementById('txtCorreo').style.borderColor = '#FBBDBD';
         document.getElementById('txtApellidoM').style.borderColor = '#ccc';
         
        return false;
    } else if (ciudad === "") {
        document.getElementById('txtCiudad').style.borderColor = '#FBBDBD';
        document.getElementById('txtCorreo').style.borderColor = '#ccc';
        
        return false;
    } else if (distrito === "") {
        document.getElementById('txtDistrito').style.borderColor = '#FBBDBD';
        document.getElementById('txtCiudad').style.borderColor = '#ccc';
        
        return false;
    }
    }
}
