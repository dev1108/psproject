package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Service.UserService;
import com.example.web.dto.UserRegistrationdto;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	private UserService userService;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	@ModelAttribute("user")
    public UserRegistrationdto userRegistrationDto() {
        return new UserRegistrationdto();
    }
	
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	
	
	public UserRegistrationController() {
		
	}
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationdto registrationDto) {
		userService.save(registrationDto);
		return "redirect:/registration?success";}
}
