package com.educandoweb.course.entities;

import java.io.Serializable;
import java.util.Objects;

//sempre importa com a espicificação
import jakarta.persistence.Entity;//e a especificação do jpa e o org.hibernate e a implementação
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="tb_user")//especificando o nome da tabela de dados, User é uma palavra reservada do banco de dados h2
public class User implements Serializable {//transformar em cadeia de bites pra trafegar na rede
	private static final long serialVersionUID = 1L;
	
	@Id//mostra qual e a chave primaria do banco de dados
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto-incremento
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;
	
	public User() {}

	public User(Long id, String name, String email, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
