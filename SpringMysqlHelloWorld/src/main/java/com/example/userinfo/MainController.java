package com.example.userinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/userinfo")
public class MainController {
	
	@Autowired
	private UserRepository userRepository;

		@PostMapping(path="/add")
		public @ResponseBody String addNewUser (@RequestParam String name, 
				@RequestParam String email) {
			
			UserInfo user = new UserInfo();
			user.setName(name);
			user.setEmail(email);
			userRepository.save(user);
			
			return "Saved Succesfully";
		}
		
		@GetMapping(path="/all")
		public @ResponseBody Iterable<UserInfo> getAll(){
			
			return userRepository.findAll();
		}
		
}
