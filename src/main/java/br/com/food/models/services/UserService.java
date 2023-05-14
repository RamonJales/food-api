package br.com.food.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.food.controllers.exceptions.ResourceNotFoundException;
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
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Object Not Found!"));
	}
	
	public UserEntity save(UserEntity obj) {
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		UserEntity obj = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Object Not Found!"));
		
		repository.delete(obj);
	}
	
	public UserEntity update(Integer id, UserEntity obj) {
		UserEntity user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Object Not Found!"));
		user.setName(obj.getName());
		user.setEmail(obj.getEmail());
		user.setPassword(obj.getPassword());
		user.setPhone(obj.getPhone());
		return repository.save(user);
	}
}
