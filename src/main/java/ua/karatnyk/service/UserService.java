package ua.karatnyk.service;

import ua.karatnyk.entity.UserEntity;

public interface UserService {
	
	UserEntity findById(int id);
	UserEntity findByLogin(String login);
	
	
	void saveUser(UserEntity entity);

}
