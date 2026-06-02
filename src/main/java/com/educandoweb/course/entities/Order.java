package com.educandoweb.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.educandoweb.course.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
	
	@OneToMany(mappedBy="id.order")// e a associação do orderitempk dentro da classe orderitem
	private Set<OrderItem> items = new HashSet<>();
	//nome do atributo da outra classe de associação
	//no caso do 1para1 esta mapeando para os id sairem igual, e no caso de 1para1
	//mapeando para os dois terem o mesmo id e é obrigatório colocar cascade = CascadeType.ALL
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment;
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
	
	public Set<OrderItem> getItems(){
		return items;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
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
