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
			TeachersViewRequest t = new TeachersViewRequest();
			t.setId(e.getId());
			t.setFirstName(e.getFirstName());
			t.setLastName(e.getLastName());
			t.setMiddleName(e.getMiddleName());
			if(e.getSubject() != null)
				t.setSubject(e.getSubject().getTitle());
			teachersViewRequests.add(t);
		}
		
		return teachersViewRequests;
		
	}
	
	public static UserEntity teacherAddRequestToUserEntity(TeacherAddRequest request) {
		UserEntity entity = new UserEntity();
		entity.setFirstName(request.getFirstName());
		entity.setLastName(request.getLastName());
		entity.setMiddleName(request.getMiddleName());
		entity.setLogin(request.getLogin());
		entity.setPassword(request.getPassword());
		entity.setSubject(request.getSubject());
		entity.setNameFoto("noAvatar.png");
		entity.setRole(Role.ROLE_TEACHER);
		//entity.setNumberSchool(new CurrentEntity().getCurrentEntity(principal).getNumberSchool());
		
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
		request.setLogin(user.getLastName());
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
