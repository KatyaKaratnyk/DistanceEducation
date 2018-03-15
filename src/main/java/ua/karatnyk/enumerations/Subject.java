package ua.karatnyk.enumerations;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Subject {
	
	INFORMATIC("Інформатика"), MATHEMATIC("Математик"), ENGLISH("Англійська мова");
	
	public String title;

}
