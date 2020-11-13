$().ready(function() {
	$("#login_usuario").validate({
		errorClass: "my-error-class",
		rules: {
			nickname: { required: true},
			password: { required: true}
		},
		messages: {
			nickname: {required: "Introduce el nombre de usuario"},	
			password: {required: "Introduce la contraseña"}
		}
	});
});

