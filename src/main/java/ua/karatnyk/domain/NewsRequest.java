package ua.karatnyk.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.karatnyk.entity.UserEntity;
import ua.karatnyk.validation.annotation.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class NewsRequest {
	
	@NotEmpty(message = "Це поле не може бути порожнім")
	@NotNull(message = "Це поле не може бути порожнім")
	@Size(max = 50,  message = "Перевищує довжину у 50 символів")
	private String title;
	
	@NotEmpty(message = "Це поле не може бути порожнім")
	@NotNull(message = "Це поле не може бути порожнім")
	@Size(max = 5000, message = "Перевищує довжину у 5000 символів")
	private String description;
	
	private MultipartFile file;
	
	private String encodedFileToByte;
	
	private Integer id;
	
	private UserEntity userEntity;
	
	private String pathToImage;

}
