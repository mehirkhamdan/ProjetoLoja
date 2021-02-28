package br.edu.ifpr.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.edu.ifpr.modelos.Produto;
import br.edu.ifpr.repositorio.ProdutoRepositorioJPA;

@WebServlet({"","/admin", "/admin/produtos"})
public class ProdutoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	ProdutoRepositorioJPA repositorio = new ProdutoRepositorioJPA();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String acao = req.getParameter("acao") != null ?  req.getParameter("acao") : "listar";
		
		switch (acao) {
			
			case "listar":
				this.listar(req, resp);
				break;
				
			case "cadastro":
				
				if(!resp.isCommitted()) {
					resp.sendRedirect("/app/admin/produtos/cadastrar.jsp");
				}
				
				break;
				
			case "cadastrar":
				this.cadastro(req, resp);
				break;
				
			case "excluir":
				this.excluir(req, resp);
				break;
				
			case "edicao":
				
				this.edicao(req, resp);
				
				break;
			
			case "editar":
				this.editar(req, resp);
				break;

			default:
				this.listar(req, resp);
			break;
		}

	}
	
	private void editar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer id = Integer.valueOf(req.getParameter("inputId"));
		String nome = req.getParameter("inputNome");
		Double preco = Double.valueOf(req.getParameter("inputPreco"));
		
		Produto p = new Produto(id, nome, preco);
		
		repositorio.atualizar(p);
		
		this.listar(req, resp);
		
	}

	private void edicao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//validacao necessária
		Integer id = Integer.valueOf(req.getParameter("id")) ;
		
		Produto p = repositorio.buscarPorId(id);
		
		req.setAttribute("produto", p);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/produtos/editar.jsp");
		
		if(!resp.isCommitted()) {
			dispatcher.forward(req, resp);
		}
	}

	private void excluir(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//validacao necessária
		Integer id = Integer.valueOf(req.getParameter("id")) ;
		
		repositorio.excluir(id);
		this.listar(req, resp);
	}

	private void cadastro(HttpServletRequest req, HttpServletResponse resp) {
		
		String nome = req.getParameter("inputNome");
		Double preco = Double.valueOf(req.getParameter("inputPreco"));
		
		Produto produto = new Produto(nome, preco);
		
		try {
			repositorio.cadastrar(produto);
			
			this.listar(req, resp);
			
		} catch (Exception e) {
			//acao caso algo dê errado
		}
	}

	private void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("produtos", repositorio.buscarTodos());
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/produtos/listar.jsp");
		
		if(!resp.isCommitted()) {
			dispatcher.forward(req, resp);
		}
		
	}

}
