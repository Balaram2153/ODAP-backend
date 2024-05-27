package com.ODAP.DRService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ODAP.DREntity.Contact;
import com.ODAP.DRRepository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	public ContactRepository contactrepo;
	
	@Override
	public Contact register(Contact contact) {

		return contactrepo.save(contact);
	}

	@Override
	public List<Contact> allContacts() {

		return contactrepo.findAll();
	}

}
