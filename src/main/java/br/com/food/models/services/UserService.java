package br.com.food.models.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.food.controllers.exceptions.ResourceNotFoundException;
import br.com.food.data.vo.v1.UserVO;
import br.com.food.models.entities.UserEntity;
import br.com.food.models.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	/*Method Reference: special type of lambda expressions. Used to create a simple lambda expressions
	 by referencing existing methods. EX.: <Class name>::<method name>*/
	public List<UserVO> findAll() {
		List<UserEntity> list = repository.findAll();
		return list.stream().map(UserVO::new).toList();
	}
	
	public UserVO findById(Integer id) {
		UserEntity entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Object Not Found!"));
		return new UserVO(entity);
	}
	
	public UserVO save(UserVO obj) {
		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(obj, entity);
		entity = repository.save(entity);
		return new UserVO(entity);
	}
	
	public void delete(Integer id) {
		UserEntity obj = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Object Not Found!"));
		
		repository.delete(obj);
	}
	
	public UserVO update(Integer id, UserVO obj) {
		UserEntity user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Object Not Found!"));
		updateAttributes(obj, user);
		UserEntity entity = repository.save(user);
		return new UserVO(entity);
	}
	
	private void updateAttributes(UserVO obj, UserEntity user) {
		user.setName(obj.getName());
		user.setEmail(obj.getEmail());
		user.setPassword(obj.getPassword());
		user.setPhone(obj.getPhone());
	}
}
