package br.edu.ifpr.filtros;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpr.servicos.LoginService;

@WebFilter({"/", "/admin/*"})/*solucao provisoria*/
public class LoginFiltro implements Filter {

	private LoginService loginService = new LoginService();
	private List<String> urlsLiberadas;
	
	public void init(FilterConfig filterConfig) throws ServletException {
		
		urlsLiberadas = Arrays.asList("/admin/login.jsp");
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String urlAtual = req.getServletPath();
		
		System.out.println(urlAtual);
		
		if(loginService.estaLogado(req) || urlsLiberadas.contains(urlAtual)) {
		
			chain.doFilter(req, resp);
		
		} else {
			
			resp.sendRedirect("/app/admin/login.jsp");
			
		}
	}
}
