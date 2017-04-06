
jQuery(document).ready(function() {
	$('.date').mask('00/00/0000');
	$('.cep').mask('00000-000');
	$('.cpf').mask('000.000.000-00', {reverse: true});
	$('.telefone').mask('(00) 0000-00000');
	$('.placa').mask('AAA-0000');
});


function sucesso(retorno){
	alert("sucesso");
	mostrarSegurado();
}

function visualizar(id){
	$.get("/segurado/detalhe-segurado?id=" + id,sucesso);
}

function mostrarSegurado(){
	$('#modal').modal('show');
}


function esconderCampos() {
	$("#consulta-segurado, #consulta-cpf , #consulta-telefone , #consulta-cep")
			.hide();
}


function teste(){
	$(".visualizar").click(function(){
		mostrarSegurado();		
	});
}

