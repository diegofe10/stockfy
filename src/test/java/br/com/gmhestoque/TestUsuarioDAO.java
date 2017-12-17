package br.com.gmhestoque;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.gmhestoque.dao.UsuarioDAO;
import br.com.gmhestoque.entidade.Usuario;

public class TestUsuarioDAO {
	
	EntityManager em;
	
	@Before
	public void init() {
		
		//Contexto do Spring
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("file:src/main/resources/META-INF/springbeans.xml");
		EntityManagerFactory emf = (EntityManagerFactory) ctx.getBean("entityManagerFactory");
				
		EntityManager em  =  emf.createEntityManager();
		
		ctx.close();
	}
	
	@Test
	public void testSalvar() {

		//Criando novo Usuario
		
		Usuario usu = new Usuario();
		usu.setNome("Jão da Silva");
		usu.setLogin("jj");
		usu.setSenha("12345678910");
		
		//Criando um usuarioDAO
		UsuarioDAO usuarioDAO = new UsuarioDAO(em);
		usuarioDAO.salvar(usu);
		
	}
	
	public void testBuscarPorId() {
		//Criando um novo usuario
		
	}
}