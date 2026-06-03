package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;


//@Component anotação pra registrar como componente, pra fazer a injenção, se tornar um componente do spring
@Service// registrando no mecanismo de injenção de dependencia, para o autowired funcionar e necessario registrar
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(long id) {//vai retorna um objeto optional
		Optional<User> obj = repository.findById(id);
		return obj.get();//vai retornar o objeto do tipo USER que estiver dentro do optional
	}
	
	//pra salvar no banco de dados um dado usuario, retorna o usuário salvo
	public User insert(User obj) {
		return repository.save(obj); //save ja retorna o objeto salvo
	}
}
