package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

@RestController//e para falar que é uma camada de recurso web, e uma anotação 
@RequestMapping(value = "/users")//e o nome/caminho do recurso
//endpoints
public class UserResource {
	@Autowired
	private UserService service;
//metódo que vai ser um endpoint para acessar usuários
	//response entity ele retorna respostas de requisições web	
	@GetMapping
	//list<user> e o tipo de retorno do método
	public ResponseEntity<List<User>> findAll(){//user e o tipo da resposta da função 
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	//dessa vez vai passar um valor na pra url, que será o id
	// a requisição vai aceitar um id dentro da url
	@GetMapping(value = "/{id}")//apenas o user pq so vai receber um id
	//essa anotação faz com que o spring aceite o value do getmapping, o parametro do método recebe a url"{/id}
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	// pra inserir voce utiliza o POSTMAPPING, pra recuperar usa o get
	@PostMapping
	public ResponseEntity<User> insert (@RequestBody User obj){//recebe um objeto do tipo user
		//pra falar que esse objeto vai chegar la no json e ser deserializado pra um objeto user no java e necessario a anotação
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
	}
}
