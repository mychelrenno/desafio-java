<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Desafio Java</title>
	
	<link href="<c:url value="/static/node_modules/bootstrap/dist/css/bootstrap.min.css"/>" rel="stylesheet">
    <script src="<c:url value="/static/node_modules/bootstrap/dist/js/bootstrap.min.js"/>"></script>
	
</head>
<body>

	<h1>PROJETO.JSP</h1>
	
	<form:form action="/projeto/salvar" method="POST" modelAttribute="projeto">
	<form:input type="hidden" path="id"/>
	<ul class="list-group">
		<li>
			<label>Nome
				<form:input path="nome"/>
				<form:errors path="nome"/>
			</label>
		</li>
		<li>
			<label>Gerente
				<form:select path="gerente">
					<form:option value="">--SELECIONE--</form:option>
					<form:options items="${gerenteList}" itemValue="id" itemLabel="nome"></form:options>
				</form:select>
				<form:errors path="gerente"/>
			</label>
		</li>
		<li>
			<label>Data de início
				<form:input type="date" path="dataInicio" />
				<form:errors path="dataInicio"/>
			</label>
		</li>
		<li>
			<label>Data da previsão
				<form:input type="date" path="dataPrevisao" />
				<form:errors path="dataPrevisao"/>
			</label>
		</li>
		<li>
			<label>Data do término
				<form:input type="date" path="dataFim" />
				<form:errors path="dataFim"/>
			</label>
		</li>
		<li>
			<label>Orçamento
				<form:input pattern="" placeholder="12345678,90" path="orcamento"/>
				<form:errors path="orcamento"/>
			</label>
		</li>
		<li>
			<label>Descrição
				<form:textarea path="descricao"/>
				<form:errors path="descricao"/>
			</label>
		</li>
		<li>
			<label>Risco
				<form:select path="risco">
					<form:option value="">--SELECIONE--</form:option>
					<form:options itemLabel="descricao"></form:options>
				</form:select>
				<form:errors path="risco"/>
			</label>
		</li>
		<li>
			<label>Status
				<form:select path="status">
					<form:option value="">--SELECIONE--</form:option>
					<form:options itemLabel="descricao"></form:options>
				</form:select>
				<form:errors path="status"/>
			</label>
		</li>
		<li>
			<label>Membros
				<form:select multiple="true" path="membros">
					<form:options items="${membroList}" itemValue="id" itemLabel="nome"></form:options>
				</form:select>
				<form:errors path="membros"/>
			</label>
		</li>
		<li>
			<input class="btn btn-primary" type="submit" value="Salvar"/>
		</li>
	</ul>
</form:form>
	
</body>
</html>