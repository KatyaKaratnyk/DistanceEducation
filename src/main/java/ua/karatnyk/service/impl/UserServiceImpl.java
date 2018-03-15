package ua.karatnyk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ua.karatnyk.entity.UserEntity;
import ua.karatnyk.repository.UserRepository;
import ua.karatnyk.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserEntity findById(int id) {
		return userRepository.findOne(id);
	}

	@Override
	public UserEntity findByLogin(String login) {
		return userRepository.findUserByLoginAndActice(login);
	}

	@Override
	public void saveUser(UserEntity entity) {
		String password = entity.getPassword();
		entity.setPassword(passwordEncoder.encode(password));
		userRepository.save(entity);
		
	}

}
