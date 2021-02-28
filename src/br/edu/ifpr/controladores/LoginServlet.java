package br.edu.ifpr.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpr.servicos.LoginService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	LoginService service = new LoginService();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String acao = req.getParameter("acao") != null ? req.getParameter("acao") : "default";
		
		switch (acao) {
			case "login":
				service.login(req, resp);
				break;
			
			case "logout":
				service.logout(req, resp);
				break;
	
			default:
				resp.sendRedirect("/app/admin/login.jsp");
				break;
		}
		
		
	}

}
