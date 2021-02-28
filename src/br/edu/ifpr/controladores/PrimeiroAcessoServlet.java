package br.edu.ifpr.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpr.modelos.Usuario;
import br.edu.ifpr.repositorio.UsuarioRepositorioJPA;

@WebServlet({"/app/primeiroacesso"})
public class PrimeiroAcessoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	UsuarioRepositorioJPA repositorio = new UsuarioRepositorioJPA();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String acao = req.getParameter("acao") != null ?  req.getParameter("acao") : "listar";
		
		switch (acao) {
			
			case "listar":
				this.listar(req, resp);
				break;
				
			case "cadastro":
				
				if(!resp.isCommitted()) {
					resp.sendRedirect("/app/admin/usuarios/cadastrar.jsp");
				}
				
				break;
				
			case "cadastrar":
				this.cadastro(req, resp);
				break;
						
			default:
				this.listar(req, resp);
			break;
		}

	}
		

	private void cadastro(HttpServletRequest req, HttpServletResponse resp) {
		
		String nome = req.getParameter("inputNome");
		String login = req.getParameter("inputLogin");
 		String senha = req.getParameter("inputSenha");
		
		
		Usuario usuario = new Usuario(nome, login, senha);
		
		try {
			repositorio.cadastrar(usuario);
			
			this.listar(req, resp);
			
		} catch (Exception e) {
			//acao caso algo der errado
		}
	}

	private void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("usuarios", repositorio.buscarTodos());
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/usuarios/listar.jsp");
		
		if(!resp.isCommitted()) {
			dispatcher.forward(req, resp);
		}
		
	}

}
