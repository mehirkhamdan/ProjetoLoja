<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../cabecalho.jsp" %>

<h1 class="h2 mt-4">Edicão de Produtos</h1>
<hr />

<form method="post" action="/app/admin/produtos?acao=editar">

	<div class="mb-3">
		<label for="inputId" class="form-label">#Id</label> 
		<input class="form-control" type="text" id="inputId" name="inputId" value="${produto.id}" readonly="readonly">
	</div>

	<div class="mb-3">
		<label for="inputNome" class="form-label">Nome</label> 
		<input class="form-control" type="text" id="inputNome" name="inputNome" value="${produto.nome}">
	</div>

	<div class="mb-3">
		<label for="inputPrice" class="form-label">Preço</label> 
		<input type="number" class="form-control" id="inputPreco" pattern="[0-9]+([\.,][0-9]+)?" step="0.01" name="inputPreco" value="${produto.preco}">
	</div>

	<button type="submit" class="btn btn-primary">editar</button>
</form>

<%@ include file="../rodape.jsp" %>
