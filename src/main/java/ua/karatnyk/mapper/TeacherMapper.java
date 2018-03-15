package ua.karatnyk.mapper;

import java.util.ArrayList;
import java.util.List;

import ua.karatnyk.domain.TeacherAddRequest;
import ua.karatnyk.domain.TeachersViewRequest;
import ua.karatnyk.entity.UserEntity;
import ua.karatnyk.enumerations.Role;

public class TeacherMapper {
	
	
	public static List<TeachersViewRequest> listTeacherEntitiesToListTeachersViewRequest(List<UserEntity> entities) {
		List<TeachersViewRequest> teachersViewRequests = new ArrayList<>();
		for(UserEntity e: entities) {
			TeachersViewRequest t = new TeachersViewRequest();
			t.setId(e.getId());
			t.setFirstName(e.getFirstName());
			t.setLastName(e.getLastName());
			t.setMiddleName(e.getMiddleName());
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
		
		
		entity.setRole(Role.ROLE_TEACHER);
		//entity.setNumberSchool(new CurrentEntity().getCurrentEntity(principal).getNumberSchool());
		
		return entity;
	}

}
