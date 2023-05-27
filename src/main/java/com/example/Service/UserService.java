package com.example.Service;


import model.user;


import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.web.dto.UserRegistrationdto;

public interface UserService extends UserDetailsService{
	user save(UserRegistrationdto registrationDto);
	
}
