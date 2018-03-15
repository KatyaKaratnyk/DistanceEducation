package ua.karatnyk.service;

import java.util.List;

import org.springframework.data.domain.Page;

import ua.karatnyk.entity.UserEntity;

public interface TeacherService {
	
	
	List<UserEntity> findAllActiveTeachers();
	
	Page<UserEntity> getPagesTeachers(int pageNumber, int pageSize, String sort, String sortByField);

}
