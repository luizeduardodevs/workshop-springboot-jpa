package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

@RestController//e para falar que é uma camada de recurso web, e uma anotação 
@RequestMapping(value = "/users")//e o nome/caminho do recurso
public class UserResource {
//metódo que vai ser um endpoint para acessar usuários
	//response entity ele retorna respostas de requisições web
	@GetMapping
	public ResponseEntity<User> findAll(){//user e o tipo da resposta da função 
		User u = new User(1L, "Maria", "maria@gmail.com", "7777777","12345");
		return ResponseEntity.ok().body(u);
	}
}
