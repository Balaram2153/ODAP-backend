package com.ODAP.DRService;

import java.util.List;

import com.ODAP.DREntity.Contact;

public interface ContactService {
	
	public Contact register(Contact contact);
	
	public List<Contact> allContacts();
	

}
