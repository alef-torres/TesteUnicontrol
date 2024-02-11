


function confirmar(idcon){
	let resposta = confirm("Comfirma a exclusão desta pessoa?")
	if (resposta === true){
		//alert(idcon)
		window.location.href = 'delete?idcon=' + idcon
	}
}