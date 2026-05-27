package com.educandoweb.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.educandoweb.course.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_order")
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	//garante que o instant seja mostrando no JSON no fromato de string no padrão ISO 8601 
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant date;
	
	private Integer orderStatus;
	
	@ManyToOne //para transformar em uma chave estrangeira e necessário, necessário por conta do relacionamento de associação
	@JoinColumn(name="client_id")//nome da chave estrangeira para o nome no banco de dados
	private User client;

	public Order() {}
	
	public Order(Long id, Instant date,OrderStatus orderStatus, User client) {
		super();
		this.id = id;
		this.date = date;
		setOrderStatus(orderStatus);//dentro dele occore a conversão de integer para enum
		this.client = client;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}
	
	public OrderStatus getOrderStatus() {//integer para enum
		return OrderStatus.valueOf(orderStatus);//convertendo o numero inteiro pra orderstatus chamado o método valueOf
	}//valueof procura enum pelo codigo 

	public void setOrderStatus(OrderStatus orderStatus) {//enum para inteiro
		if(orderStatus != null) {
		this.orderStatus = orderStatus.getCode();//getcode e quem pega o numero do enum
		}
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
