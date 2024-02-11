<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CRUD</title>
<link rel="stylesheet" href="estilo/estilo.css">
<script src="https://kit.fontawesome.com/e553b0e27c.js"></script>

</head>

<body>
	<section class="principal" id="form">
		<form name="frmPessoa" class="formulario-de-cadastro" action="update">
			<h2>Editar</h2>

			<label for="username">Id</label>
			<div class="input">
				<i class="fa-solid fa-user"></i> <input type="text" name="idcon"
					value="<%out.print(request.getAttribute("idcon"));%>" readonly>
			</div>

			<label for="username">Nome</label>
			<div class="input">
				<i class="fa-solid fa-user"></i> <input type="text"
					name="nome" value="<%out.print(request.getAttribute("nome"));%>">
			</div>


			<label for="profissao">Profissão</label>
			<div class="input">
				<i class="fa-solid fa-briefcase"></i> <input type="text"
					name="profissao"
					value="<%out.print(request.getAttribute("profissao"));%>">
			</div>


			<label for="idade">Idade</label>
			<div class="input">
				<i class="fa-solid fa-cake-candles"></i> <input type="text"
					name="idade" value="<%out.print(request.getAttribute("idade"));%>">
			</div>

			<div id="btn">
				<button id="btn-enviar" value="salvar" onclick="validar()">Salvar</button>
			</div>

		</form>
	</section>
	<script src="scripts/validador.js"></script>
</body>
</html>