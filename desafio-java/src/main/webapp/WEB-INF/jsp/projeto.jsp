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
    
    <style>
    	body {
    		display: flex;
    		justify-content: center;
    	}
    	form {
    		width:980px;
    		margin-top: 10px;
     	}
     	div.buttons {
   		    display: flex;
		    flex-direction: row-reverse;
		    margin-top: 10px;
     	}
     	.buttons > input {
     		margin-left: 10px;
     	}
     	label {
     		font-weight: bold;
     	}
     	.form-error {
     		color:red;
     	}
    </style>
    
</head>
<body>

	<form:form action="/projeto/salvar" method="POST" modelAttribute="projeto" style="width:980px">
	
		<form:input type="hidden" path="id"/>
		
		<div class="form-group">
			<label for="nome">Nome</label>
			<form:input id="nome" class="form-control" path="nome"/>
			<form:errors path="nome" cssClass="form-error"/>
		</div>
		
		<div class="form-group">
			<label for="gerente">Gerente</label>
			<form:select id="gerente" class="form-control" path="gerente">
				<form:option value="">--SELECIONE--</form:option>
				<form:options items="${gerenteList}" itemValue="id" itemLabel="nome"></form:options>
			</form:select>
			<form:errors path="gerente" cssClass="form-error"/>
		</div>
		
		<div class="form-group">
			<label for="dataInicio">Data de início</label>
			<form:input id="dataInicio" class="form-control" type="date" path="dataInicio" />
			<form:errors path="dataInicio" cssClass="form-error"/>
		</div>
		
		<div class="form-group">
			<label for="dataPrevisao">Data da previsão</label>
			<form:input id="dataPrevisao" class="form-control" type="date" path="dataPrevisao"/>
			<form:errors path="dataPrevisao" cssClass="form-error"/>
		</div>
		
		<div class="form-group">
			<label for="dataFim">Data do término</label>
			<form:input if="dataFim" class="form-control" type="date" path="dataFim" />
			<form:errors path="dataFim" cssClass="form-error"/>
		</div>
		
		<div class="form-group">
			<label for="orcamento">Orçamento</label>
			<form:input id="orcamento" class="form-control" placeholder="12345678,90" path="orcamento"/>
			<form:errors path="orcamento" cssClass="form-error"/>
		</div>
		
		<div class="form-group">
			<label for="descricao">Descrição</label>
			<form:textarea id="descricao" class="form-control"  path="descricao"/>
			<form:errors path="descricao" cssClass="form-error"/>
		</div>
		
		<div class="form-group">
			<label for="risco">Risco</label>
			<form:select id="risco" class="form-control" path="risco">
				<form:option value="">--SELECIONE--</form:option>
				<form:options itemLabel="descricao"></form:options>
			</form:select>
			<form:errors path="risco" cssClass="form-error"/>
		</div>
		
		<div class="form-group">
			<label id="status">Status</label>
			<form:select id="status" class="form-control" path="status">
				<form:option value="">--SELECIONE--</form:option>
				<form:options itemLabel="descricao"></form:options>
			</form:select>
			<form:errors path="status" cssClass="form-error"/>
		</div>
		
		<div class="form-group">
			<label for="membros">Membros</label>
			<form:select id="membros" class="form-control" multiple="true" path="membros">
				<form:options items="${membroList}" itemValue="id" itemLabel="nome"></form:options>
			</form:select>
			<form:errors path="membros" cssClass="form-error"/>
		</div>
		
		<div class="buttons">
			<input class="btn btn-primary" type="submit" value="Salvar"/>
			<input type="button" class="btn btn-secondary" onclick="document.location='/'" value="Voltar"/>
		</div>
		
</form:form>
	
</body>
</html>