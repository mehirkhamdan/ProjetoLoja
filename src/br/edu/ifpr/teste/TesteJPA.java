package br.edu.ifpr.teste;

import java.util.List;

import br.edu.ifpr.modelos.Produto;
import br.edu.ifpr.repositorio.ProdutoRepositorioJPA;

public class TesteJPA {
	
	
	public static void main(String[] args) {
		
		ProdutoRepositorioJPA repositorio = new ProdutoRepositorioJPA();
		
		
		//repositorio.cadastrar(new Produto("TESTE CADASTRO", 999.0));
		
		repositorio.excluir(15);
		
		repositorio.atualizar(new Produto(14, "TESTE CADASTRO", 000.0));
		
		
		List<Produto> produtos = repositorio.buscarTodos();
		
		for (Produto atual : produtos) {
			System.out.println(atual);
		}
		
	}
}
