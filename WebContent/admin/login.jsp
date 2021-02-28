<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>IFPR TechStore</title>

	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
	
	<style>
		
		.logo-wrapper {
			margin-top: 25px;
			text-align: center;
		}
		
		.form-signin {
		    margin-top: 150px;
		}
	
	</style>
	
</head>

<body>


	<div class="container">

		<div class="row justify-content-center">

			<div class="col-md-4 mb-4">
				<main class="form-signin">
				
					<c:if test="${not empty mensagemErro}">
					<div class="alert alert-danger" role="alert">
					
						${mensagemErro}
					
					</div>
					
					</c:if>
					
					<form method="post" action="/app/login?acao=login">
						
						<div class="logo-wrapper">
							<img class="mb-4" src="/app/assets/imgs/logo.png" alt="" width="120" >
						</div>
						
						<label for="inputLogin" class="visually-hidden">Login</label> 
						<input type="text" id="inputLogin" class="form-control" placeholder="login" name="inputLogin" required autofocus> 
						
						
						<label for="inputPassword" class="visually-hidden">Password</label> 
						<input type="password" id="inputPassword" class="form-control" placeholder="senha" name="inputSenha" required>


						<button class="w-100 btn btn-lg btn-primary" type="submit">acessar</button> 
						
						</form>  
						<form name="cadastraracesso" method="post"  action="/app/primeiroacesso.jsp" >  
						    <input name="cadastrar" type="submit" value="Primeiro Acesso"/>  
						</form>  
										
						
						<p class="mt-5 mb-3 text-muted">&copy; 2020-2021</p>
						
						
						
					</form>
				</main>
			</div>

		</div>

	</div>

</body>
</html>