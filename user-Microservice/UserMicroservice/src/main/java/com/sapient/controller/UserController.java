package com.sapient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.entity.User;
import com.sapient.entity.Userlog;
import com.sapient.entity.Userprofile;
import com.sapient.entity.Userskills;
import com.sapient.interfaces.IUserInterface;
import com.sapient.interfaces.IUserLogInterface;
import com.sapient.interfaces.IUserProfileInterface;
import com.sapient.interfaces.IUserSkillsInterface;



@RestController
public class UserController {
	
	@Autowired
	IUserInterface userInterface;

	@Autowired
	IUserSkillsInterface userSkillsInterface;
	
	@Autowired
	IUserLogInterface userLogInterface;
	

	@Autowired
	IUserProfileInterface userProfileInterface;
 
	
	@GetMapping(value="userskills")
	public List<Userskills> getUserSkills()
	{
		return userSkillsInterface.findAll();
	}

	
	@GetMapping(value="")
	public String gettingStarted()
	{
		return "Welcome to User Microservice";
	}
	
	@GetMapping(value="/users")
	public List<User> gettingUsers()
	{
		return userInterface.findAll();
		
	}
	@GetMapping(value="/userlogs")
	public List<Userlog> gettingUserLogs()
	{
		return userLogInterface.findAll();
		
	}
	@GetMapping(value="/userprofiles")
	public List<Userprofile> getUserProfiles()
	{
		return  userProfileInterface.findAll();
	}
	
	
	@PostMapping(value="/users/adduser")
	public User saveUser(@RequestBody User user)
	{
		return userInterface.save(user);
    }
	
	@PostMapping(value="/users/adduserskill")
	public Userskills saveUserSkill(@RequestBody Userskills userskill)
	{
		return userSkillsInterface.save(userskill);
	}
	
	
//	@PostMapping(value="/users/adduserprofile")
	//public Userprofile saveUserProfile(@RequestBody Userprofile userprofile)
	//{
		//return userProfileInterface.save(userprofile);
     //}
	
}
