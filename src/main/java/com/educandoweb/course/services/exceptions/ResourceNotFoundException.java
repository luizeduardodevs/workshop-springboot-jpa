package com.educandoweb.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {//exceção que o compilador nao obriga a tratar

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {// é o id do objeto que voce tentou procurar mas nao achou
		super("Resource not found. id " + id);
	}
	
}
