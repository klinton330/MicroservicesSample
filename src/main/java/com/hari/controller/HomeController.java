package com.hari.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hari.model.UserModel;

@RestController
public class HomeController {
	List<UserModel> list = new ArrayList<UserModel>();
	UserModel user = new UserModel();

	public HomeController() {
		user.setRollNo(111);
		user.setName("Hari");
		user.setAmount(2500.00f);
		user.setCity("chennai");

		UserModel user1 = new UserModel();
		user1.setRollNo(222);
		user1.setName("Rahul");
		user1.setAmount(350.00f);
		user1.setCity("Bangalore");

		list.add(user);
		list.add(user1);
	}

	@RequestMapping("/")
	public String getHome() {
		return "Home controller";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public UserModel getUser() {
		UserModel user = new UserModel();
		user.setRollNo(111);
		user.setName("Hari");
		user.setAmount(2500.00f);
		user.setCity("chennai");
		return user;
	}

	@RequestMapping(value = "/allUsers", method = RequestMethod.GET)
	public List<UserModel> allgetUser() {
		return list;

	}

	@GetMapping(value = "/user/{id}")
	public UserModel getParticularUser(@PathVariable int id) {
		UserModel UserModel = new UserModel();
		for (UserModel user : list) {
			if (user.getRollNo() == id)
				return user;

		}
		return UserModel;
	}

	@GetMapping(value = "/user1/{id}")
	public String getId(@PathVariable int id) {
		return "The id value is" + id;
	}

	@GetMapping(value = "/user/{id}/{id1}")
	public String getIds(@PathVariable int id, @PathVariable int id1) {
		return "The id value is" + id + " and id 1 is" + id1;
	}

	@GetMapping(value = "users/{id}/{id1}")
	public String getIdwithAlies(@PathVariable int id, @PathVariable("id1") int number) {
		return "The id value is" + id + " and id 1 is" + number;
	}

	// URI="http://localhost:8080/requestparam?name=ravi&city=chennai"
	@GetMapping("/requestparam")
	public String requestParams(@RequestParam String name, @RequestParam String city) {
		return "The name is" + name + "and city is" + city;
	}

	// URI="http://localhost:8080/requestparams?name=ravi&cityName=chennai"
	@GetMapping("/requestparams")
	public String requestParams1(@RequestParam String name,
			@RequestParam(name = "cityName", required = false, defaultValue = "") String city) {
		return "The name is" + name + "and city is" + city;
	}
}
