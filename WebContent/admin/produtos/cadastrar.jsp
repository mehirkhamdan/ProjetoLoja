<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../cabecalho.jsp" %>

<h1 class="h2 mt-4">Cadastro de Produtos</h1>
<hr />

<form method="post" action="/app/admin/produtos?acao=cadastrar">

	<div class="mb-3">
		<label for="inputNome" class="form-label">Nome</label> 
		<input class="form-control" type="text" id="inputNome" name="inputNome">
	</div>

	<div class="mb-3">
		<label for="inputPrice" class="form-label">Preço</label> 
		<input type="number" class="form-control" id="inputPreco" min="0" value="0" step="0.01" name="inputPreco">
	</div>

	<button type="submit" class="btn btn-primary">cadastrar</button>
</form>

<%@ include file="../rodape.jsp" %>
