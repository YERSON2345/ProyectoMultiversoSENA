
$.validator.setDefaults( {
    submitHandler: function () {
       alert( "¡Se ha registrado un nuevo proveedor!" );
    }
 });
 
 
 $(document).ready(function(){
    $('#signupForm').validate({
       rules: {
          fullname: {
             required: true,
             minlength: 3
          },
          fullname2:{
              required: true,
              minlength: 2
          },
           luckynumber:{
               required: true
           },
          agree: "required"
       },
       messages: {           
          fullname: {
             required: "Por favor ingrese el nombre del proveedor",
             minlength: "El nombre debe ser de no menos de 3 caracteres"
          },
           fullname2: {
             required: "Por favor ingrese el nombre de la empresa del proveedor",
             minlength: "El nombre debe ser de no menos de 3 caracteres"
          },
          agree: "Por favor acepta nuestra política",
          luckynumber: {
             required: "Por favor seleccione el estado del proveedor"
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