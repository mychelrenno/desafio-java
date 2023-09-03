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

	<script type="text/javascript">
		function editar(id) {
			alert("mychel edita " + id);
			document.location = "/projeto/editar?id=" + id;
		}
		function excluir(id) {
		   jQuery.ajax({
		        method: 'delete',
		        url: "/projeto/excluir",
		        data : {id: id},
// 		        contentType: "application/json",
		        success: function (response, status, xhr) {
		        	alert("Projeto excluido com sucesso");
		        	$("tr#"+id).remove();
		        },
		        error: function (response) {
		            alert(response.responseText);
		        }
		    });
		}
		function novoProjeto() {
// 			alert("Novo Projeto");
			document.location = "/projeto";
		}
	</script>
	
	<style type="text/css">
		.div-flex-centraliza {
			display: flex;
			align-items: center;
			flex-direction: column;
		}
	</style>

</head>
<body class="div-flex-centraliza">

<div style="width:980px; margin-top: 20px">

<div>
<table class="table table-striped">
	<thead>
	<tr>
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
			<td>${p.nome}</td>
			<td style="width:50px"><p>${p.descricao}</p></td>
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
</div>

<div style="display: flex; justify-content: flex-end;">
	<button type="button" class="btn btn-primary" onclick="novoProjeto();">Novo Projeto</button>
</div>
</div>



</body>
</html>