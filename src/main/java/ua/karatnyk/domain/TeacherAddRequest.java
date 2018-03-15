package ua.karatnyk.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.karatnyk.enumerations.Subject;

@Getter
@Setter
@NoArgsConstructor
public class TeacherAddRequest {
	
	private String firstName;
	private String lastName;
	private String middleName;
	
	private String login;
	private String password;
	private Subject subject;

}
