<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../cabecalho.jsp" %>

<h1 class="h2 mt-4">Cadastro de Usuarios</h1>
<hr />

<form method="post" action="/app/admin/usuarios?acao=cadastrar">

	<div class="mb-3">
		<label for="inputNome" class="form-label">Nome</label> 
		<input class="form-control" type="text" id="inputNome" name="inputNome">
	</div>

	<div class="mb-3">
		<label for="inputLogin" class="form-label">Login</label> 
		<input class="form-control" type="text" id="inputLogin" name="inputLogin">
	</div>
	
	<div class="mb-3">
		<label for="inputPassword" class="form-label">Senha</label> 
		<input class="form-control" type="text" id="inputSenha" name="inputSenha">
	</div>

	<button type="submit" class="btn btn-primary">cadastrar</button>
</form>

<%@ include file="../rodape.jsp" %>
