package com.ODAP.DRController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ODAP.DREntity.Contact;
import com.ODAP.DRService.ContactService;

@RestController
@CrossOrigin("*")
public class ContactController {

	@Autowired
	ContactService contactservice;
	
	

	@PostMapping("/contactadmin")
	public Contact register(@RequestBody Contact contact)
	{
		return contactservice.register(contact);
		
	}
	
	@GetMapping("/getallcontacts")
	public List<Contact> allContacts()
	{
		
		return contactservice.allContacts();
		
	}
}
