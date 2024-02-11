<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>



<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("pessoas");
%>


<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<title>Pessoas</title>
<link rel="stylesheet" href="estilo/pesquisa.css">
</head>

<body>
	<section>
		<div>
			<h1>Lista de pessoas</h1>
			<a href="index.html"><button>Novo</button></a>



			<table id="tabela">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nome</th>
						<th>Profissão</th>
						<th>Idade</th>
						<th>Opções</th>
					</tr>
				</thead>

				<tbody>
					<%
					for (int i = 0; i < lista.size(); i++) {
					%>
					<tr>
						<td><%=lista.get(i).getIdcon()%></td>
						<td><%=lista.get(i).getNome()%></td>
						<td><%=lista.get(i).getProfissao()%></td>
						<td><%=lista.get(i).getIdade()%></td>
						<td><a href="select?idcon=<%=lista.get(i).getIdcon()%>>">Edit</a>
							<a href="javascript: confirmar(<%=lista.get(i).getIdcon()%>)">Del</a>
						</td>

					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</section>



	<script src="scripts/confirmador.js"></script>
</body>

</html>