package ua.karatnyk.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TeachersViewRequest {
	
	private int id;
	
	private String firstName;
	private String lastName;
	private String middleName;
	private String subject;

}
