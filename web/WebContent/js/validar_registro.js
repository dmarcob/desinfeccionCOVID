$().ready(function() {
	$("#formulario-registro").validate({
		errorClass: "my-error-class",
		rules: {
			nickname: { required: true, minlength: 2},
			nombre: { required: true, minlength: 2},
			apellidos: { required: true, minlength: 2},
			direccion: { required: true, minlength: 5},
			email: { required:true, email: true},
			telefono: { required:true, minlength: 9, maxlength: 15, digits: true},
			password: { required: true, minlength: 5},
			confirmPassword: { equalTo: "#register-password"}
		},
		messages: {
			nickname: {required: "El campo es obligatorio.", minlength: "El campo debe tener más de {0} caracteres"},
			nombre: {required: "El campo es obligatorio.", minlength: "El campo debe tener más de {0} caracteres"},
			apellidos: {required: "El campo es obligatorio.", minlength: "El campo debe tener más de {0} caracteres"},
			direccion: {required: "El campo es obligatorio.", minlength: "La dirección no es valida"},
			email : {required: "El campo es obligatorio.", email: "El email no es valido" },
			telefono : {required: "El campo es obligatorio.", minlength: "El campo debe tener más de {0} caracteres", maxlength: "El campo debe tener menos de {0} caracteres", digits: "El formato no es valido"},		
			password: {required: "El campo es obligatorio.", minlength: "El campo debe tener más de {0} caracteres"},
			confirmPassword: "Las contraseñas no coinciden"
		}
	});
});

