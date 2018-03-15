package ua.karatnyk.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.karatnyk.enumerations.Subject;

@Entity
@Table(name = "courses", indexes = @Index(columnList = "course_title"))
@Getter
@Setter
@NoArgsConstructor
public class Course extends BaseEntity{
	
	@Column(name = "course_title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "course")
	private List<Theme> themes = new ArrayList<Theme>();
	
	@Enumerated(EnumType.STRING)
	private Subject subject;
	
	@OneToMany(mappedBy = "course")
	private List<Group> groups = new ArrayList<Group>();

	
	
	

}
