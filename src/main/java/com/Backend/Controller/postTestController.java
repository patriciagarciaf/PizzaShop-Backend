package com.Backend.Controller;

import java.util.UUID;

import com.Backend.Domain.User;
import com.Backend.Infraestructure.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/demo")
public class postTestController {
	@Autowired 
	private UserRepository userRepository;

	@PostMapping(path="/add") 
	public @ResponseBody String addNewUser (@RequestParam UUID id,@RequestParam String name
			, @RequestParam String email) {


		User n = new User();
		n.setName(name);
		n.setEmail(email);
		n.id=id;
		userRepository.save(n);
		return "Saved";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
}
