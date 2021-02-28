package br.edu.ifpr.repositorio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpr.conexao.Conexao;
import br.edu.ifpr.modelos.Produto;

public class ProdutoRepositorio {
	
	private Connection conn;
	
	public ProdutoRepositorio() {
		conn = Conexao.obterConexao();
	}

	public List<Produto> buscarTodos() {
		
		List<Produto> produtos = new ArrayList<Produto>();
		
		String sql = "SELECT * FROM produtos";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
		
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				Produto p = new Produto(
						result.getInt("id"), 
						result.getString("nome"), 
						result.getDouble("preco"), 
						result.getDate("dataCadastro")
				);
				
				produtos.add(p);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return produtos;
	}
	
	public Produto buscarPorId(Integer id) {
		
		Produto produto = null;
		String sql = "SELECT * FROM produtos WHERE id = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
		
			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				produto = new Produto(
						result.getInt("id"), 
						result.getString("nome"), 
						result.getDouble("preco"), 
						result.getDate("dataCadastro")
				); 
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return produto;
		
	}
	
	public Produto cadastrar(Produto produto) {
		
		String sql = "INSERT INTO produtos(nome, preco, dataCadastro) "
				+ "values (?, ?, ?)";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)){
			
			stmt.setString(1, produto.getNome());
			stmt.setDouble(2, produto.getPreco());
			stmt.setDate(3, new Date(produto.getDataCadastro().getTime()));
			
			stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return produto;
		
	}
}
