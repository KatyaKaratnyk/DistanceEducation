package ua.karatnyk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.karatnyk.validation.annotation.NotEmpty;

@Entity
@Table(name = "news", indexes = @Index(columnList = "title"))
@Getter
@Setter
@NoArgsConstructor
public class News extends BaseEntity{
	
	@NotEmpty(message = "Це поле не може бути порожнім")
	@NotNull(message = "Це поле не може бути порожнім")
	@Size(max = 50,  message = "Перевищує довжину у 50 символів")
	private String title;
	
	@NotEmpty(message = "Це поле не може бути порожнім")
	@NotNull(message = "Це поле не може бути порожнім")
	@Size(max = 5000, message = "Перевищує довжину у 5000 символів")
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@Column(name = "path_to_foto")
	private String pathToFoto;
	

}
