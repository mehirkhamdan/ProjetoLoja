package br.edu.ifpr.repositorio;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.ifpr.conexao.MyEntityManagerFactory;
import br.edu.ifpr.modelos.Usuario;

public class UsuarioRepositorioJPA {
	
	public Usuario cadastrar(Usuario usuario) {
		EntityManager em = MyEntityManagerFactory.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		
		em.close();
		
		return usuario;
	}
	
	
	public Usuario atualizar(Usuario usuario) {
		
		EntityManager em = MyEntityManagerFactory.getEntityManager();
		
		Usuario u = em.find(Usuario.class, usuario.getId());
				
		em.getTransaction().begin();
		
		u.setNome(usuario.getNome());
		u.setLogin(usuario.getLogin());
		u.setSenha(usuario.getSenha());
		u.setDataCadastro(usuario.getDataCadastro());
		
		em.getTransaction().commit();
		
		em.close();
		
		return u;
	}
	
	public Usuario buscarPorId(Integer id) {
		
		EntityManager em = MyEntityManagerFactory.getEntityManager();
		
		Usuario u = em.find(Usuario.class, id);
		
		em.close();
		
		return u;
		
	}
	
	public List<Usuario> buscarTodos() {
		EntityManager em = MyEntityManagerFactory.getEntityManager();
		List<Usuario>usuarios = em.createQuery("SELECT u FROM Usuario u").getResultList();
		
		em.close();
		
		return usuarios;
	}
	
	public List<Usuario> buscarTodosNativo() {
		EntityManager em = MyEntityManagerFactory.getEntityManager();
		List<Usuario> usuarios = em.createNativeQuery("SELECT * FROM usuarios", Usuario.class).getResultList();
		
		em.close();
		
		return usuarios;
	}
	
	public Usuario excluir(Integer id) {
		
		EntityManager em = MyEntityManagerFactory.getEntityManager();
		
		em.getTransaction().begin();
		
		Usuario u = em.find(Usuario.class, id);
		
		em.remove(u);
		
		em.getTransaction().commit();
		
		em.close();
		
		return u;
		
	}

}
