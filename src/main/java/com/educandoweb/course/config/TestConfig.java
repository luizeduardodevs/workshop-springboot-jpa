package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

//classe especifica de configuração e necessario a anotação
//é uma classe auxiliar que faz algumas configurações na aplicações
@Configuration
@Profile("test")// especifica para o perfil de test, tem que ser igual ao colocar no .properties
public class TestConfig implements CommandLineRunner {
//injeção de dependecia com o repositorio user
	@Autowired//faz a associação com a classe, isso e dentro do framework spring boot
	private UserRepository userRepository;

	
	//pra executar e necessario a implementação do commandLineRunner
	@Override
	public void run(String... args) throws Exception {
		// tudo que estiver aqui dentro vai ser executado quando iniciado 
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		// salvando dentro do banco de dados
		userRepository.saveAll(Arrays.asList(u1,u2));
		
	}
	
}
