package ua.karatnyk.mapper;

import java.io.IOException;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import ua.karatnyk.domain.ProfileUserEditRequest;
import ua.karatnyk.domain.ProfileUserViewRequest;
import ua.karatnyk.entity.UserEntity;
import ua.karatnyk.service.utilities.FileManager;

public interface UserMapper {
	
	public static User toSecurityUser(UserEntity entity) {
		return new User(entity.getLogin(), entity.getPassword(), AuthorityUtils.createAuthorityList(String.valueOf(entity.getRole())));
	}
	

	
	public static ProfileUserViewRequest userEntityToProfileUserViewRequest(UserEntity entity) {
		
		ProfileUserViewRequest request = new ProfileUserViewRequest();
		request.setId(entity.getId());
		if(entity.getNameFoto().equals("noAvatar.png"))
			request.setEncodedToByteByNameFoto(FileManager.encodedFileToByteFromProject(FileManager.pathToDefaultImage("noAvatar.png")));
		else 
			request.setEncodedToByteByNameFoto(FileManager.encodedFileToByteFromProject(FileManager.fullPathToImage(entity.getId(), entity.getNameFoto())));
		if(entity.getBirthDate() != null)
			request.setBirthDate(entity.getBirthDate().toString());
		request.setEmail(entity.getEmail());
		if(entity.getClassTeacher() != null)
			request.setClassTeach(entity.getClassTeacher().toString());
		request.setFirstName(entity.getFirstName());
		request.setMiddleName(entity.getMiddleName());
		request.setLastName(entity.getLastName());
		if(entity.getSubject() != null)
			request.setSubject(entity.getSubject().getTitle());
		request.setNumberSchool(entity.getNumberSchool().getTitle());
		request.setLogin(entity.getLogin());
		if(entity.getClassStudent() != null)
			request.setClassInStudy(entity.getClassStudent().toString());
		//request.setClassTeacherFullName();
		return request;
	}
	
	public static ProfileUserEditRequest userEntityToProfileUserEditRequest(UserEntity entity) {
		ProfileUserEditRequest request = new ProfileUserEditRequest();
		request.setId(entity.getId());
		request.setNameFoto(entity.getNameFoto());
		request.setFirstName(entity.getFirstName());
		request.setLastName(entity.getLastName());
		request.setMiddleName(entity.getMiddleName());
		request.setEmail(entity.getEmail());
//		if(entity.getBirthDate() != null)
//			request.setBirthDate(entity.getBirthDate());
		request.setLogin(entity.getLogin());
		
		request.setSubject(entity.getSubject());
		request.setPassword(entity.getPassword());
		return request;
	}
	
	public static UserEntity profileUserEditRequestToUserEntity(ProfileUserEditRequest request, UserEntity currentUser) {
		UserEntity entity = new UserEntity();
		
		entity.setId(request.getId());
		if(!request.getFile().isEmpty()) {
			entity.setNameFoto(FileManager.nameFile(request.getFile()));
			try {
				FileManager.saveImageUserInProject(request.getFile(), request.getId());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			entity.setNameFoto(request.getNameFoto());
		}
//		if(request.getBirthDate() != null)
//			entity.setBirthDate(request.getBirthDate());
		entity.setFirstName(request.getFirstName());
		entity.setLastName(request.getLastName());
		entity.setMiddleName(request.getMiddleName());
		entity.setEmail(request.getEmail());
		entity.setLogin(request.getLogin());
		
		entity.setSubject(request.getSubject());
		entity.setPassword(request.getPassword());
		entity.setLastUpdateByUser(currentUser);
		return entity;
	}
	

}
