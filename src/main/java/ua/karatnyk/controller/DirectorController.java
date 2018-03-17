package ua.karatnyk.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.karatnyk.domain.TeacherAddRequest;
import ua.karatnyk.domain.TeachersViewRequest;
import ua.karatnyk.entity.UserEntity;
import ua.karatnyk.enumerations.Subject;
import ua.karatnyk.mapper.TeacherMapper;
import ua.karatnyk.service.TeacherService;
import ua.karatnyk.service.UserService;


@Controller
@RequestMapping("/director")
@SessionAttributes({"subjectModel"})
public class DirectorController {
	
	@Autowired
	TeacherService teacherService;
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public String showMainDirectorPage() {
		return "director/main";
	}
	
	//----------------------Класи-----------------------
	
	@GetMapping("/class_for_student")
	public String showClassesPage() {
		return "director/classes/view_classes";
	}
	
	
	//-------------------Вчителі--------------------------
	
	@GetMapping("/teachers/{pageNumber}")
	public String showNewsTablePage(Model model, @PathVariable("pageNumber") int pageNumber) {
		
		Page<UserEntity> page = teacherService.getPagesTeachers(pageNumber, 5, "DESC", "createdAt");
		System.out.println();
//		if(!this.titleFilter.isEmpty() && this.titleFilter != null) {
//			page = newsService.getPagebleNewsWithTitleFilter(pageNumber, 5, "DESC", "createdAt", this.titleFilter);
//		} 
		int currentPage = page.getNumber()+1;
		int begin = Math.max(1, currentPage-1);
		int end = Math.min(begin+10, page.getNumber());
		
		model.addAttribute("newsList", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", currentPage);
		model.addAttribute("teacherListModel", TeacherMapper.listTeacherEntitiesToListTeachersViewRequest(page.getContent()));
	
		return "director/teachers/view_teachers";
	}
	
	@GetMapping("/add_teacher")
	public String addTeacherShowPage(Model model) {
		model.addAttribute("teacherAddRequestModel", new TeacherAddRequest());
		model.addAttribute("subjectModel", Subject.values());
		
		return "director/teachers/add_teacher";
	}
	
	@PostMapping("/add_teacher")
	public String addTeacher(@ModelAttribute("teacherAddRequestModel") @Valid TeacherAddRequest request, 
			BindingResult result, Principal principal) {
		
		UserEntity entity = TeacherMapper.teacherAddRequestToUserEntity(request);
		
		entity.setNumberSchool(this.findCurrentUser(principal).getNumberSchool());
		entity.setCreatedByUser(this.findCurrentUser(principal));
		
		userService.saveUser(entity);
		return "redirect:/director/teachers/1";
	}
	@GetMapping("/profile-teacher{idTeacher}")
	public String showProfileTeacher(@PathVariable("idTeacher") int idTeacher, Model model) {
		
		TeachersViewRequest request = TeacherMapper.userEntityToTeachersViewRequest(userService.findById(idTeacher));
		model.addAttribute("teacherModel", request);
		
		return "director/teachers/view_profile_teacher";
	}
	
	//------------------Учні-------------------------------
	
	
	
	
	
	//-------------------------------------------------------
	private UserEntity findCurrentUser(Principal principal) {
		return userService.findByLogin(principal.getName());
	}

}
