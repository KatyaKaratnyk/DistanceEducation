package ua.karatnyk.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.karatnyk.enumerations.Role;
import ua.karatnyk.enumerations.School;
import ua.karatnyk.enumerations.Subject;


@Entity
@Table(name = "users", indexes = @Index(columnList = "first_name, last_name"))
@Getter
@Setter
@NoArgsConstructor
public class UserEntity extends BaseEntity{
	
	private String login;
	
	private String password;
	
	@Column (name = "first_name")
	private String firstName;
	
	@Column (name = "last_name")
	private String lastName;
	
	@Column (name = "middle_name")
	private String middleName;
	
	@Enumerated(EnumType.ORDINAL)
	private Role role;
	
	private String email;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "number_school")
	private School numberSchool;
	
	@Column(name = "birth_date")
	private Date birthDate;
	
	@Column(name = "path_to_foto")
	private String pathToFoto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "class_id")
	private ClassToStudent classStudent;
	
	@OneToOne(mappedBy = "userEntity2")
	private ClassToStudent classTeacher;

	@Enumerated(EnumType.STRING)
	private Subject subject;
	
	@ManyToMany()
	@JoinTable(name = "user_group", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
	private List<Group> groups = new ArrayList<>();
	
	@OneToMany(mappedBy = "userEntity")
	private List<Group> groups2 = new ArrayList<>();
	
	@OneToMany(mappedBy = "userEntity")
	private List<Course> courses = new ArrayList<>();
	
	@OneToMany(mappedBy = "userEntity")
	private List<Theme> themes = new ArrayList<>();
	
	@OneToMany(mappedBy = "userEntity")
	private List<UserEntity> userEntities = new ArrayList<>();
	
	@OneToMany(mappedBy = "userEntity")
	private List<ClassToStudent> classToStudents = new ArrayList<>();
	
	@OneToMany(mappedBy = "userEntity")
	private List<News> newsList = new ArrayList<>();
	
	
	

}
