<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>IFPR TechStore</title>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="/app/assets/css/dashboard.css" />
</head>
<body>

	<header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">

		<a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="#">TechStore</a>

		<button class="navbar-toggler position-absolute d-md-none collapsed"
			type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu"
			aria-controls="sidebarMenu" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		
		<form method="get" action="">
			<input class="form-control form-control-dark w-100" type="text"
			placeholder="buscar produtos" aria-label="buscar">
			
		</form>

		<div class="navbar-nav px-3">
			<a class="nav-link" href="/app/login?acao=logout">sair</a>
		</div>
	</header>

	</div class="container-fluid">
		</div class="row">
			<nav id="sidebarMenu"
				class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
				<div class="position-sticky pt-3">

					<h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">						
						 <span>Produtos</span>
					</h6>
					
					<ul class="nav flex-column mb-2">
						<li class="nav-item"><a class="nav-link" 
							href="/app/admin/produtos?acao=listar">listar</a></li>
						
						<li class="nav-item"><a class="nav-link" 
							href="/app/admin/produtos?acao=cadastro">cadastrar</a></li>
					</ul>
					
					<h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
						 <span>Usuários</span>
					</h6>
					
					<ul class="nav flex-column mb-2">
						<li class="nav-item"><a class="nav-link" 
							href="/app/admin/usuarios?acao=listar">listar</a></li>
						
						<li class="nav-item"><a class="nav-link" 
							href="/app/admin/usuarios?acao=cadastro">cadastrar</a></li>
					</ul>
															
				</div>
			</nav>

			<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4 ">