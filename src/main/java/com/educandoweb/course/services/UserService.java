package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;


//@Component anotação pra registrar como componente, pra fazer a injenção, se tornar um componente do spring
@Service// registrando no mecanismo de injenção de dependencia, para o autowired funcionar e necessario registrar
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(long id) {//vai retorna um objeto optional
		Optional<User> obj = repository.findById(id);//na hora de reornar o get se nao tiver nenhum user vai da exceção
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));//vai retornar o objeto do tipo USER que estiver dentro do optional
	}
	
	//pra salvar no banco de dados um dado usuario, retorna o usuário salvo
	public User insert(User obj) {
		return repository.save(obj); //save ja retorna o objeto salvo
	}
	public void delete (Long id) {
		repository.deleteById(id);//deletando
	}
	
	public User update(Long id, User obj){// retorna o usuario, qual o usuario que vai retorna o id, e quais os dados sera atualizados do USer OBJ
	User entity = repository.getReferenceById(id);//  getreference ele vaio instacis o usuário, porem não vai no banco de dados , só deixa ele monitorado pelo JPA
	// atualizando o entity com os dados que vieram dentro do OBJ
	updateData(entity,obj);
	return repository.save(entity);
}

	private void updateData(User entity, User obj) {
		//atualizar o entity com base que cheou no meu obj
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
