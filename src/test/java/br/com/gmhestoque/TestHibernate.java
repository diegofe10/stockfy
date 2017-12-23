package br.com.gmhestoque;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.gmhestoque.dao.UsuarioDAOJPA;
import br.com.gmhestoque.entidade.Usuario;

public class TestHibernate {

	public static void main(String[] args) {
		
		//Fabrica de EntityManager
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("fabricaweb2");
		//Gerenciador de Entidades
		//EntityManager em = emf.createEntityManager();
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("file:src/main/resources/META-INF/springbeans.xml");
		EntityManagerFactory emf = (EntityManagerFactory) ctx.getBean("entityManagerFactory");
		
		EntityManager em  =  emf.createEntityManager();
		
		//Criando objeto a ser persistido
		Usuario usu = new Usuario();
		usu.setNome("Maria");
		usu.setLogin("mar");
		usu.setSenha("123456");
		
		UsuarioDAOJPA usuarioDAO = new UsuarioDAOJPA(em);
		usuarioDAO.salvar(usu);
		
		//Usuario usuModificar = usuarioDAO.buscarPorId(18);
		
		//usuModificar.setLogin("die");
		
		//usuarioDAO.salvar(usuModificar);
		
		//usuarioDAO.excluir(usuModificar);
		
		//System.out.println(usuModificar);
		
		ctx.close();
	}

}
