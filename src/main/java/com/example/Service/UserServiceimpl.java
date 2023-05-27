package com.example.Service;

import java.util.Arrays;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.repository.UserRepository;
import com.example.web.dto.UserRegistrationdto;
import model.Role;
import model.user;

@Service
public class UserServiceimpl implements UserService{

   private UserRepository userRepository;
   
	public UserServiceimpl(UserRepository userRepository) {
	super();
	this.userRepository = userRepository;
}

	@Override
	public user save(UserRegistrationdto registrationDto) {
		user user =new user(registrationDto.getFirstname(), 
				registrationDto.getLasttname(), registrationDto.getEmail(),
				registrationDto.getPassword(), Arrays.asList(new Role("Role_User")));
		
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		com.example.model.user user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.user(user.get, user.getPassword(), mapRolesToAuthorities(user.getRoles()));		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
	
}