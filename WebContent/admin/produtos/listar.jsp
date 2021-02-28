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
      <th scope="col">preco</th>
      <th scope="col">data cadastro</th>
      <th scope="col">operacões</th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach var="produto" items="${produtos}">
    <tr>
      <th scope="row">${produto.id}</th>
      	<td>${produto.nome}</td>
      
      	<td>
      		<fmt:setLocale value = "pt-br"/>
     		<fmt:formatNumber value="${produto.preco}" type="currency"/>
      	</td>
      
      	<td>
      		<fmt:formatDate pattern="dd-MM-yyyy" value="${produto.dataCadastro}" />
      	</td>
      	
      	<td>
      		<a href="/app/admin/produtos?acao=excluir&id=${produto.id}">excluir</a> | 
      		<a href="/app/admin/produtos?acao=edicao&id=${produto.id}">editar</a>
      	</td>
      	
    </tr>
    </c:forEach>
  </tbody>
</table>

<%@ include file="../rodape.jsp" %>
			
			
			