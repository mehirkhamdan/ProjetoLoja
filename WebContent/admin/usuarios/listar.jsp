<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../cabecalho.jsp" %>
		
<h1 class="h2 mt-4">Dashboard</h1>
<hr />

<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">nome</th>
      <th scope="col">login</th>
      <th scope="col">senha</th>
      <th scope="col">data cadastro</th>
      <th scope="col">operacões</th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach var="usuario" items="${usuarios}">
    <tr>
      <th scope="row">${usuario.id}</th>
      	<td>${usuario.nome}</td>
      	<td>
      	
      	<td>${usuaro.login}</td>
      	<td>
      	
      	<td>${usuario.senha}</td>
      
      	<td>
      		<fmt:setLocale value = "pt-br"/>
     		<fmt:formatDate pattern="dd-MM-yyyy" value="${usuario.dataCadastro}" />
      	</td>
      	
      	<td>
      		<a href="/app/admin/usuarios?acao=excluir&id=${usuario.id}">excluir</a> | 
      		<a href="/app/admin/usuarios?acao=edicao&id=${usuario.id}">editar</a>
      	</td>
      	
    </tr>
    </c:forEach>
  </tbody>
</table>

<%@ include file="../rodape.jsp" %>
			
			
			