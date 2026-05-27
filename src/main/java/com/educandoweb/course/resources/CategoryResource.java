package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.services.CategoryService;
@RestController//e para falar que é uma camada de recurso web, e uma anotação 
@RequestMapping(value = "categories")//e o nome/caminho do recurso
public class CategoryResource {
	@Autowired
	private CategoryService service;
//metódo que vai ser um endpoint para acessar usuários
	//response entity ele retorna respostas de requisições web	
	@GetMapping
	//list<Category> e o tipo de retorno do método
	public ResponseEntity<List<Category>> findAll(){//Category e o tipo da resposta da função 
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	//dessa vez vai passar um valor na pra url, que será o id
	// a requisição vai aceitar um id dentro da url
	@GetMapping(value = "/{id}")//apenas o Category pq so vai receber um id
	//essa anotação faz com que o spring aceite o value do getmapping, o parametro do método recebe a url"{/id}
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
}
}
