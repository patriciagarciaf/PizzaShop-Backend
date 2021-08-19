package com.example.demo.Controller;

import java.util.UUID;

import com.example.demo.Domain.UserDomain.Roles;
import com.example.demo.Domain.UserDomain.User;
import com.example.demo.Infraestructure.UserJPARepository;

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
	private UserJPARepository userJPARepository;

	// @PostMapping(path="/add") 
	// public @ResponseBody String addNewUser (@RequestParam UUID id,@RequestParam String name
	// 		, @RequestParam String surname, @RequestParam String password, @RequestParam String email,
	// 		@RequestParam Roles role) {


	// 	User n = new User();


	// 	n.
	// 	n.email(email);
	// 	n.password=password;
	// 	n.role=role;
	// 	n.surname=surname;
	// 	n.id=id;
	// 	userJPARepository.save(n);
	// 	return "Saved";
	// }

	// @GetMapping(path="/all")
	// public @ResponseBody Iterable<User> getAllUsers() {
	// 	return userJPARepository.findAll();
	// }
}
