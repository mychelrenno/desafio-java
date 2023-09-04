<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="pt_br">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Desafio Java</title>

    <link href="<c:url value="/static/node_modules/bootstrap/dist/css/bootstrap.min.css"/>" rel="stylesheet">
    <script src="<c:url value="/static/node_modules/bootstrap/dist/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/static/node_modules/jquery/dist/jquery.min.js"/>"></script>

	<style>
		body {
			display: flex;
			justify-content: center;
		}
		div.conteudo {
			width:980px;
			margin-top: 10px;
		}
		div.buttons {
			display: flex;
			flex-direction: row-reverse;
		}
		td {
			max-width: 100px;
			word-wrap: break-word;
		}
	</style>

	<script>
		function editar(id) {
			document.location = "/projeto/editar?id=" + id;
		}
		function excluir(id) {
		   jQuery.ajax({
		        method: 'delete',
		        url: "/projeto/excluir",
		        data : {id: id},
		        success: function (response, status, xhr) {
		        	alert(response);
		        	$("tr#"+id).remove();
		        },
		        error: function (response) {
		            alert(response.responseText);
		        }
		    });
		}
	</script>
	
</head>
<body>
<div class="conteudo">

<table class="table table-striped">
	<thead>
	<tr>
		<th>#</th>
		<th>Nome</th>
		<th>Descrição</th>
		<th>Gerente</th>
		<th>Data de início</th>
		<th>Data da previsão</th>
		<th>Data do término</th>
		<th>Orçamento</th>
		<th>Risco</th>
		<th>Status</th>
		<th></th>
		<th></th>
	</tr>
	</thead>
	<tbody>
    <c:forEach var="p" items="${projetoList}">
   		<tr id="${p.id}">
			<td>${p.id}</td>
			<td>${p.nome}</td>
			<td>${p.descricao}</td>
			<td>${p.gerente.nome}</td>
			<td><fmt:formatDate pattern="dd/MM/yyyy" value="${p.dataInicio}" /></td>
			<td><fmt:formatDate pattern="dd/MM/yyyy" value="${p.dataPrevisao}" /></td>
			<td><fmt:formatDate pattern="dd/MM/yyyy" value="${p.dataFim}" /></td>
			<td><fmt:formatNumber pattern="###,##0.00" value="${p.orcamento}"/></td>
			<td>${p.risco.descricao}</td>
			<td>${p.status.descricao}</td>
			<td><a href="javascript:editar('${p.id}')" class="link-primary">Editar</a></td>
			<td><a href="javascript:excluir('${p.id}')" class="link-danger">Excluir</a></td>
		</tr>
    </c:forEach>
    <tbody>
</table>

<div class="buttons">
	<button class="btn btn-primary" onclick="document.location='/projeto'">Novo Projeto</button>
</div>

</div>
</body>
</html>