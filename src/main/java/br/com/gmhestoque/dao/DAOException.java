package br.com.gmhestoque.dao;

public class DAOException extends Exception {
	
	//Construtor recebendo a causa
	public DAOException(Exception e) {
		super(e);
	}
	
	
}
