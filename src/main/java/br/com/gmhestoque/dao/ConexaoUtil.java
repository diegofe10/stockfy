package br.com.gmhestoque.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ConexaoUtil {
	
	static EntityManager em = null;
	
	public static EntityManager criarEntityManager() {
		if(em == null) {
			em =  Persistence.createEntityManagerFactory("gmhestoque").createEntityManager();
		}
		
		return em; 
	}
	
}
