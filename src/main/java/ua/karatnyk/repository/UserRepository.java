package ua.karatnyk.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.karatnyk.entity.UserEntity;
import ua.karatnyk.enumerations.Role;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	
	@Query("SELECT u FROM UserEntity u WHERE u.login = :login and u.isDeleted = false")
	UserEntity findUserByLoginAndActice(@Param("login") String login);
	
	@Query("SELECT u FROM UserEntity u WHERE u.role = :role and u.isDeleted = false")
	List<UserEntity> findUsersByRoleAndActice(@Param("role") Role role);
	
	@Query("SELECT u FROM UserEntity u WHERE u.role = :role and u.isDeleted = false")
	Page<UserEntity> findUsersByRoleAndActice(@Param("role") Role role, Pageable pageable);

}
