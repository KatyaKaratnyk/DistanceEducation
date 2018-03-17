package ua.karatnyk.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.karatnyk.domain.ProfileUserEditRequest;
import ua.karatnyk.domain.ProfileUserViewRequest;
import ua.karatnyk.entity.UserEntity;
import ua.karatnyk.mapper.UserMapper;
import ua.karatnyk.service.UserService;



@Controller
@SessionAttributes({"userEditModel"})
public class BaseController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping({"/", "/login"})
	public String showHomePage() {
		return "home";
	}
	
	
	@GetMapping("/profile")
	public String showUserProfile(Principal principal, Model model) {
		try {
			UserEntity currentEntity = userService.findByLogin(principal.getName());
			ProfileUserViewRequest request = UserMapper.userEntityToProfileUserViewRequest(currentEntity);
			model.addAttribute("profileViewModel", request);
		} catch (NullPointerException e) {
			return "home";
		}
		
		return "profile";
	}
	
	@GetMapping("/profile/edit")
	public String showUserEditProfile(Principal principal, Model model) {
		
		try {
			UserEntity currentEntity = userService.findByLogin(principal.getName());
			ProfileUserEditRequest request = UserMapper.userEntityToProfileUserEditRequest(currentEntity);
			model.addAttribute("userEditModel", request);
		} catch (NullPointerException e) {
			return "home";
		}
				
		return "profile_edit";
	}
	
	@PostMapping("/profile/edit")
	public String editUserProfile(Principal principal, @ModelAttribute("userEditModel") @Valid ProfileUserEditRequest request, BindingResult result) {
		
		if(result.hasErrors()) {
			return "profile_edit";
		}
		try {
			UserEntity currentEntity = userService.findByLogin(principal.getName());
			if(currentEntity.getId() != request.getId()) throw new NullPointerException();
			UserEntity entity = UserMapper.profileUserEditRequestToUserEntity(request, currentEntity);
			userService.updateUser(entity);
			
		} catch (NullPointerException e) {
			return "home";
		}
		
		return "redirect:/profile";
	}

}
