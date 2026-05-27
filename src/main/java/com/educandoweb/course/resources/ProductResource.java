package com.educandoweb.course.resources;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.services.ProductService;

@RestController//e para falar que é uma camada de recurso web, e uma anotação 
@RequestMapping(value = "/products")//e o nome/caminho do recurso
public class ProductResource {
			@Autowired
			private ProductService service;
		//metódo que vai ser um endpoint para acessar usuários
			//response entity ele retorna respostas de requisições web	
			@GetMapping
			//list<Product> e o tipo de retorno do método
			public ResponseEntity<List<Product>> findAll(){//Product e o tipo da resposta da função 
				List<Product> list = service.findAll();
				return ResponseEntity.ok().body(list);
			}
			//dessa vez vai passar um valor na pra url, que será o id
			// a requisição vai aceitar um id dentro da url
			@GetMapping(value = "/{id}")//apenas o Product pq so vai receber um id
			//essa anotação faz com que o spring aceite o value do getmapping, o parametro do método recebe a url"{/id}
			public ResponseEntity<Product> findById(@PathVariable Long id){
				Product obj = service.findById(id);
				return ResponseEntity.ok().body(obj);
	}
}
