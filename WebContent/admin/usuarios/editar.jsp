<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../cabecalho.jsp" %>

<h1 class="h2 mt-4">Edicão de Usuarios</h1>
<hr />

<form method="post" action="/app/admin/usuarios?acao=editar">

	<div class="mb-3">
		<label for="inputId" class="form-label">#Id</label> 
		<input class="form-control" type="text" id="inputId" name="inputId" value="${usuario.id}" readonly="readonly">
	</div>

	<div class="mb-3">
		<label for="inputNome" class="form-label">Nome</label> 
		<input class="form-control" type="text" id="inputNome" name="inputNome" value="${usuario.nome}">
	</div>

	<div class="mb-3">
		<label for="inputLogin" class="form-label">Login</label> 
		<input class="form-control"  type="text" class="form-control" id="inputLogin"  name="inputLogin" value="${usuario.login}">
	</div>
	
	<div class="mb-3">
		<label for="inputPassword" class="form-label">Senha</label> 
		<input class="form-control"  type="text" class="form-control" id="inputSenha"  name="inputSenha" value="${usuario.senha}">
	</div>

	<button type="submit" class="btn btn-primary">editar</button>
</form>

<%@ include file="../rodape.jsp" %>
