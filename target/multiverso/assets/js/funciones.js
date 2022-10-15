alert("bnas")

//$.validator.setDefaults( {
  //  submitHandler: function () {
    //   alert( "submitted!" );
    //}
 //});
 
 
 $(document).ready(function(){
    $('#signupForm').validate({
       rules: {
         noDocumento: {
            required: true,
            minlength: 9,
            maxlength: 10
         },
         Nombre: {
             required: true,
             minlength: 3
          },
          comments: {
             required: true
          },
          Contrasena: {
             required: true,
             minlength: 8
          },
          ConfirmarContrasena: {
             required: true,
             equalTo: "#Contrasena"
          },
          Correo: {
             required: true,
             email: true
          },
          Apellido: {
            required: true,
            minlength: 3
         },
          agree: "required"
       },
       messages: {  
         noDocumento: {
            required: "Por favor ingresa tu numero de documento",
            minlength: "Tu numero de documento debe ser de 9 caracteres ",
            maxlength:"Tu numero de documento no debe pasar los 10 caracteres"
         },         
         Nombre: {
             required: "Por favor ingresa tu nombre",
             minlength: "Tu nombre debe ser de no menos de 3 caracteres"
          },
          comments: "Por favor ingresa un comentario",
          Contrasena: {
             required: "Por favor ingresa una contraseña",
             minlength: "Tu contraseña debe ser de no menos de 8 caracteres de longitud"
          },
          ConfirmarContrasena: {
             required: "Ingresa un password",
             equalTo: "Las contraseñas no coinciden"
          },
          Correo: "Por favor ingresa un correo válido",
          agree: "Por favor acepta nuestra política",
          luckynumber: {
             required: "Por favor"
          },
          Apellido: {
            required: "Por favor ingresa tu apellido",
            minlength: "Tu apellido debe ser de no menos de 3 caracteres"
         }
       },
       errorElement: "em",
       errorPlacement: function (error, element) {
          // Add the `help-block` class to the error element
          error.addClass("help-block");
 
          if (element.prop( "type" ) === "checkbox") {
             error.insertAfter(element.parent("label") );
          } else {
             error.insertAfter(element);
          }
       },
       highlight: function ( element, errorClass, validClass ) {
          $( element ).parents( ".col-sm-10" ).addClass( "has-error" ).removeClass( "has-success" );
       },
       unhighlight: function (element, errorClass, validClass) {
          $( element ).parents( ".col-sm-10" ).addClass( "has-success" ).removeClass( "has-error" );  
       } 
    });
 });