function NotasController(opcion) {
	$("#msg").hide();
	$("#msg").removeClass("alert-success").addClass("alert-danger");
	switch (opcion) {
	case "list":
		$.ajax({
			type 	: "get",
			url	 	: "/notas/list",
			success	: function(res) {
				$("#notasTable").bootstrapTable('load', res);
				$("#notasTable tbody").on('click', 'tr', function() {
					$("#numero_modulo").val($(this).find("td:eq(0)").text());
					$("#numero_evaluacion").val($(this).find("td:eq(1)").text());
					$("#nota").val($(this).find("td:eq(2)").text());
					$("#cod_curso").val($(this).find("td:eq(3)").text());
					$("#rut").val($(this).find("td:eq(4)").text());
					$("#myModal .close").click();
				})
				$("#myModal").modal({show:true})
			},
			error	: function() {
				$("#msg").show();
				$("#msg").html("Error en busqueda de notas");
			}
				
		});
		break;

	case "get":
		$.ajax({
			type 	: "get",
			url	 	: "/notas/get",
			data	: "rut=" + $("#rut").val(),

			success	: function(res) {
				if(res == null || res == "") {
					$("#msg").show();
					$("#msg").html("No se encontro el registro");
				} else {
					$("#numero_modulo").val(res.numero_modulo);
					$("#numero_evaluacion").val(res.numero_evaluacion);
					$("#nota").val(res.nota);
					$("#cod_curso").val(res.cod_curso);
				}
			},
			error	: function() {
				$("#msg").show();
				$("#msg").html("Error en busqueda de empleados");
			}
				
		});
		break;
		
	case "insert":
		
		var json = 
			{
				'rut'			: $("#rut").val(),
				'numero_modulo'	: $("#numero_modulo").val(),
				'numero_evaluacion'	: $("#numero_evaluacion").val(),
				'nota'			: $("#nota").val(),
				'cod_curso'		: $("#cod_curso").val(),
			}
		
		var postData = JSON.stringify(json);
		
		$.ajax({
			type 	: "post",
			url	 	: "/notas/insert",
			data	: postData,
			contentType : "application/json; charset=utf-8",
			success	: function(res) {
				if(res == 1) {
					$("#msg").removeClass("alert-danger").addClass("alert-success");
					$("#msg").show();
					$("#msg").html("Nota agregada correctamente");
				} else {
					$("#msg").show();
					$("#msg").html("No se pudo ingresar nota");
				}
			},
			error	: function() {
				$("#msg").show();
				$("#msg").html("Error ingrese nota nuevamente");
			}
				
		});
		break;
		
	case "update":
		var json = 
			{
				'employee_id'	: $("#employee_id").val(),
				'first_name'	: $("#first_name").val(),
				'last_name'		: $("#last_name").val(),
				'email'			: $("#email").val(),
				'phone_number'	: $("#phone_number").val(),
				'hire_date'		: $("#hire_date").val(),
				'job_id'		: $("#job_id").val(),
				'salary'		: $("#salary").val(),
				'commission_id'	: ( $("#commission_id").val() ? $("#commission_id").val() : 0 ),
				'manager_id'	: $("#manager_id").val(),
				'department_id'	: $("#department_id").val(),
			}
		
		var postData = JSON.stringify(json);
		
		$.ajax({
			type 	: "post",
			headers: {"X-CSRF-TOKEN": token},
			url	 	: "/employees/update",
			data	: postData,
			contentType : "application/json; charset=utf-8",
			success	: function(res) {
				if(res == 1) {
					$("#msg").removeClass("alert-danger").addClass("alert-success");
					$("#msg").show();
					$("#msg").html("Registro actualizado correctamente");
				} else {
					$("#msg").show();
					$("#msg").html("No se pudo actualizar registro");
				}
			},
			error	: function() {
				$("#msg").show();
				$("#msg").html("Error actualizar empleado nuevamente");
			}
				
		});
		break;
		
	case "delete":
		$.ajax({
			type 	: "post",
			headers: {"X-CSRF-TOKEN": token},
			url	 	: "/employees/delete",
			data	: "employee_id=" + $("#employee_id").val(),

			success	: function(res) {
				if(res == 1) {
					$("#msg").removeClass("alert-danger").addClass("alert-success");
					$("#msg").show();
					$("#msg").html("Registro eliminado correctamente");
				} else {
					$("#msg").show();
					$("#msg").html("No se pudo eliminar registro");
				}
			},
			error	: function() {
				$("#msg").show();
				$("#msg").html("Error en elimininacion de empleados");
			}
				
		});
		break;
		
	default:
		$("#msg").show();
		$("#msg").html("Opcion incorrecta");
		break;
	}
}