package br.com.food.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.food.models.entities.UserEntity;
import br.com.food.models.services.UserService;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserService service;
	
	@Override
	public void run(String... args) throws Exception {
		UserEntity o1 = new UserEntity("ramon", "ramon@gmail.com", "41432243", "da342");
		UserEntity o2 = new UserEntity("pedro", "pedro@gmail.com", "41432243", "da342");
		UserEntity o3 = new UserEntity("maria", "maria@gmail.com", "41432243", "da342");

		service.save(o1);
		service.save(o2);
		service.save(o3);
		
	}
	
}
