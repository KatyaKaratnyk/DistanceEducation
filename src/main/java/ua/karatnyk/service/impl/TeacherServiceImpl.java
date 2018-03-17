package ua.karatnyk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ua.karatnyk.entity.UserEntity;
import ua.karatnyk.enumerations.Role;
import ua.karatnyk.repository.UserRepository;
import ua.karatnyk.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
	private UserRepository userRepository;

	
	@Override
	public Page<UserEntity> getPagesTeachers(int pageNumber, int pageSize, String sort, String sortByField) {
		PageRequest request = new PageRequest(pageNumber-1, pageSize, sort.toUpperCase().equals("ASC")?Sort.Direction.ASC:Sort.Direction.DESC, sortByField);
		return userRepository.findUsersByRoleAndActice(Role.ROLE_TEACHER, request);
	}


	@Override
	public List<UserEntity> findAllActiveTeachers() {
		return userRepository.findUsersByRoleAndActice(Role.ROLE_TEACHER);
	}

}
