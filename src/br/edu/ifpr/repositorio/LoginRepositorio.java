package br.edu.ifpr.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifpr.conexao.Conexao;
import br.edu.ifpr.modelos.Usuario;

public class LoginRepositorio {
	
	Connection conn;
	
	public LoginRepositorio() {
		conn = Conexao.obterConexao();
	}

	public Usuario verificarLoginUsuario(String login, String senha) throws Exception {
		
		Usuario usuario = null;
		
		String sql = "SELECT * FROM usuarios WHERE login = ? AND senha = ?";
		
		try {
		
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, login);
			stm.setString(2, senha);
			
			ResultSet result = stm.executeQuery();
			
			if(result.next()) {
				usuario = new Usuario();
				usuario.setNome( result.getString("nome") );
				usuario.setLogin( result.getString("login") );
				usuario.setSenha( result.getString("senha") );
			} else {
				throw new Exception("usuário ou senha incorretos");
			}
			
		
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return usuario;
		
	}
	
}
