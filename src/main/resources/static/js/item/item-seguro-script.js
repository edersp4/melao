function mostrarPorTipo(){
	var tipo =  $("#tipo option:selected").val();

	if(tipo == 'Imóvel'){
		$("#endereco").show(1000);	
		$("#automovel").hide(1000);
	}

	if(tipo == 'Automóvel'){
		$("#automovel").show(1000);
		$("#endereco").hide(1000);	
	}

	if(tipo == ''){
		$("#automovel").hide(1000);
		$("#endereco").hide(1000);	
	}
}

function validarItemConsorcio(){
	var tipo =  $("#tipo option:selected").val();
	if(tipo == ''){
		$('alert').alert();
		return;
	}
}