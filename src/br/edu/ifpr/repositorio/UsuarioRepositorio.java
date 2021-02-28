package br.edu.ifpr.repositorio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpr.conexao.Conexao;
import br.edu.ifpr.modelos.Usuario;

public class UsuarioRepositorio {
	
	private Connection conn;
	
	public UsuarioRepositorio() {
		conn = Conexao.obterConexao();
	}
	
public List<Usuario> buscarTodos() {
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		String sql = "SELECT * FROM usuarios";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
		
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				Usuario u = new Usuario(
						result.getInt("id"), 
						result.getString("nome"), 
						result.getString("login"), 
                        result.getString("senha"), 
						result.getDate("dataCadastro")
				);
				
				usuarios.add(u);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuarios;
	}
	
	public Usuario buscarPorId(Integer id) {
		
		Usuario usuario = null;
		String sql = "SELECT * FROM usuarios WHERE id = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
		
			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				usuario = new Usuario(
						result.getInt("id"), 
						result.getString("nome"), 
						result.getString("login "), 
                        result.getString("senha"),
						result.getDate("dataCadastro")
				); 
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuario;
		
	}
	
	public Usuario cadastrar(Usuario usuario) {
		
		String sql = "INSERT INTO usuarioss(nome, login, senha,  dataCadastro) "
				+ "values (?, ?, ?, ?)";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)){
			
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());
			stmt.setDate(4, new Date(usuario.getDataCadastro().getTime()));
			
			stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuario;
		
	}
}
