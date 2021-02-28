package br.edu.ifpr.repositorio;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.ifpr.conexao.MyEntityManagerFactory;
import br.edu.ifpr.modelos.Produto;

public class ProdutoRepositorioJPA {
	
	
	public Produto cadastrar(Produto produto) {
		EntityManager em = MyEntityManagerFactory.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
		
		em.close();
		
		return produto;
	}
	
	
	public Produto atualizar(Produto produto) {
		
		EntityManager em = MyEntityManagerFactory.getEntityManager();
		
		Produto p = em.find(Produto.class, produto.getId());
				
		em.getTransaction().begin();
		
		p.setNome(produto.getNome());
		p.setPreco(produto.getPreco());
		
		em.getTransaction().commit();
		
		em.close();
		
		return p;
	}
	
	public Produto buscarPorId(Integer id) {
		
		EntityManager em = MyEntityManagerFactory.getEntityManager();
		
		Produto p = em.find(Produto.class, id);
		
		em.close();
		
		return p;
		
	}
	
	public List<Produto> buscarTodos() {
		EntityManager em = MyEntityManagerFactory.getEntityManager();
		List<Produto> produtos = em.createQuery("SELECT p FROM Produto p").getResultList();
		
		em.close();
		
		return produtos;
	}
	
	public List<Produto> buscarTodosNativo() {
		EntityManager em = MyEntityManagerFactory.getEntityManager();
		List<Produto> produtos = em.createNativeQuery("SELECT * FROM produtos", Produto.class).getResultList();
		
		em.close();
		
		return produtos;
	}
	
	public Produto excluir(Integer id) {
		
		EntityManager em = MyEntityManagerFactory.getEntityManager();
		
		em.getTransaction().begin();
		
		Produto p = em.find(Produto.class, id);
		
		em.remove(p);
		
		em.getTransaction().commit();
		
		em.close();
		
		return p;
		
	}
}
