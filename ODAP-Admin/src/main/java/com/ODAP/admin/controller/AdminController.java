package com.ODAP.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ODAP.admin.entity.AdminEntity;
import com.ODAP.admin.entity.Query;
import com.ODAP.admin.service.AdminService;

@RestController
@CrossOrigin("*")
public class AdminController {

	@Autowired
	AdminService adminservice;
	
	@PostMapping("/adminregister")
	public AdminEntity registerAdmin(@RequestBody AdminEntity admin)
	{
		return adminservice.registerAdmin(admin);
	}
	
	@PostMapping("/query")
	public Query sendquery(@RequestBody Query query) {
		return adminservice.sendquery(query);
	}
	
	@GetMapping("/getQueries")
	public List<Query>getqueries(){
		return adminservice.getqueries();
	}
	
	@GetMapping("/getadmins")
	public List<AdminEntity>getalladmins()
	{
		return adminservice.getalladmins();
	}
}
