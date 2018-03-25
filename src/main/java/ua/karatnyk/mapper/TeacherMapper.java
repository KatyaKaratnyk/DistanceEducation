package ua.karatnyk.mapper;

import java.util.ArrayList;
import java.util.List;
import ua.karatnyk.domain.TeacherAddRequest;
import ua.karatnyk.domain.TeachersViewRequest;
import ua.karatnyk.entity.UserEntity;
import ua.karatnyk.enumerations.Role;
import ua.karatnyk.service.utilities.FileManager;

public interface TeacherMapper {
	
	public static List<TeachersViewRequest> listTeacherEntitiesToListTeachersViewRequest(List<UserEntity> entities) {
		List<TeachersViewRequest> teachersViewRequests = new ArrayList<>();
		for(UserEntity e: entities) {
			TeachersViewRequest t = TeacherMapper.userEntityToTeachersViewRequest(e);
			teachersViewRequests.add(t);
		}
		
		return teachersViewRequests;
		
	}
	
	public static UserEntity teacherAddRequestToUserEntity(TeacherAddRequest request, UserEntity currentEntity) {
		UserEntity entity = new UserEntity();
		entity.setFirstName(request.getFirstName());
		entity.setLastName(request.getLastName());
		entity.setMiddleName(request.getMiddleName());
		entity.setLogin(request.getLogin());
		entity.setPassword(request.getPassword());
		entity.setSubject(request.getSubject());
		entity.setNameFoto("noAvatar.png");
		entity.setRole(Role.ROLE_TEACHER);
		entity.setPasswordText(request.getPassword());
		entity.setNumberSchool(currentEntity.getNumberSchool());
		entity.setCreatedByUser(currentEntity);
		
		return entity;
	}
	
	public static TeachersViewRequest userEntityToTeachersViewRequest(UserEntity user) {
		TeachersViewRequest request = new TeachersViewRequest();
		request.setEmail(user.getEmail());
		request.setFirstName(user.getFirstName());
		if(user.getNameFoto().equals("noAvatar.png"))
			request.setFotoInBydeCode(FileManager.encodedFileToByteFromProject(FileManager.pathToDefaultImage("noAvatar.png")));
		else
			request.setFotoInBydeCode(FileManager.encodedFileToByteFromProject(FileManager.fullPathToImage(user.getId(), user.getNameFoto())));
		request.setId(user.getId());
		request.setLastName(user.getLastName());
		request.setLogin(user.getLogin());
		request.setMiddleName(user.getMiddleName());
		if(user.isDeleted())
			request.setStatus("не активний");
		else
			request.setStatus("активний");
		if(user.getSubject() != null)
			request.setSubject(user.getSubject().getTitle());
		return request;
	}
	
}
