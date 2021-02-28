package br.edu.ifpr.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static Connection obterConexao() {
				
		String bancoDeDados = "db_loja_lab?serverTimezone=UTC";
		String usuario = "root";
		String senha = "x231740a";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/" + bancoDeDados, usuario, senha);
		
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}
}
