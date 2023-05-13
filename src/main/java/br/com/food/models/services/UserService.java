package br.com.food.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.food.models.entities.UserEntity;
import br.com.food.models.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<UserEntity> findAll() {
		return repository.findAll();
	}
	
	public UserEntity findById(Integer id) {
		return repository.findById(id).get();
	}
	
	public UserEntity save(UserEntity obj) {
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public UserEntity update(Integer id, UserEntity obj) {
		UserEntity user = repository.findById(id).get();
		user.setName(obj.getName());
		user.setEmail(obj.getEmail());
		user.setPassword(obj.getPassword());
		user.setPhone(obj.getPhone());
		return repository.save(user);
	}
}
