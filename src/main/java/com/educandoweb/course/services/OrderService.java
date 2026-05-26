package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository2;
@Service
public class OrderService {
	@Autowired
	private OrderRepository2 repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(long id) {//vai retorna um objeto optional
		Optional<Order> obj = repository.findById(id);
		return obj.get();//vai retornar o objeto do tipo USER que estiver dentro do optional
	}
}
