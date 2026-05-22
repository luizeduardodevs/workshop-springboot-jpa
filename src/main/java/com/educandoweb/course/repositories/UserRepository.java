package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.User;
//User e o tipo da entindade que vai ser usada, e o long é o tipo do ID
// so isso e capaz de instaciar um objeto repositories que tem vai operações para trablhar com o usuário
//não e necessario implementação na interface pq o spring data JPA ja tem implementação quando e preenchido os dois tipos.
// a anotação do repository nao e necessaria pq ela ja ta herdando do extends
public interface UserRepository extends JpaRepository<User, Long> {//repositorios são interfaces

}
