package ua.karatnyk.mapper;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import ua.karatnyk.entity.UserEntity;

public interface UserMapper {
	
	public static User toSecurityUser(UserEntity entity) {
		return new User(entity.getLogin(), entity.getPassword(), AuthorityUtils.createAuthorityList(String.valueOf(entity.getRole())));
	}
	
	

}
