$().ready(function() {
	$("#formulario-registro").validate({
		errorClass: "my-error-class",
		rules: {
			nombre: { required: true, minlength: 2},
			email: { required:true, email: true},
			telefono: { minlength: 2, maxlength: 15}
		},
		messages: {
			nombre: "El campo es obligatorio.",
			email : "El campo es obligatorio y debe tener formato de email correcto.",
			telefono : "El campo Teléfono no contiene un formato correcto.",
		}
	});
});

