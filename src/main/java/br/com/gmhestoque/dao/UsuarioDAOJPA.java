package br.com.gmhestoque.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.gmhestoque.entidade.Usuario;

@Repository
public class UsuarioDAOJPA implements UsuarioDAO {
	
	//Dependencia
	@PersistenceContext
	EntityManager em;
	
	public UsuarioDAOJPA(EntityManager em) {
		this.em =  em;
	}
	
	public UsuarioDAOJPA() {
		
	}
	
	//Insert ou Update Verifica se id = null ou 0 inseri um novo se nao update
	@Transactional
	public Usuario salvar(Usuario usuario) {
		Usuario u = em.merge(usuario);
		return u;
	}
	
	@Transactional
	public void excluir(Usuario usuario) throws DAOException {
		try {
			em.remove(usuario);
		} catch (IllegalArgumentException e) {
			throw new DAOException(e);
		}
	}
	
	public Usuario buscarPorId(int id) {
		return em.find(Usuario.class, id);
	}
	
	public List<Usuario> buscarTodos(){
		Query q = em.createQuery("select u from Usuario u");
		
		return q.getResultList();
	}
	
}	
