package com.ODAP.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ODAP.admin.entity.AdminEntity;
import com.ODAP.admin.entity.Query;
import com.ODAP.admin.repository.AdminRepository;
import com.ODAP.admin.repository.QueryRepository;

@Service
public class AdminServiceImpl implements AdminService {

	
	@Autowired
	AdminRepository adminrepo;
	
	@Autowired
	QueryRepository qrepo;
	
	@Override
	public AdminEntity registerAdmin(AdminEntity admin) {
		// TODO Auto-generated method stub
		return adminrepo.save(admin);
	}
	
	@Override
	public Query sendquery(Query query) {
		return qrepo.save(query);
	}

	@Override
	public List<AdminEntity> getalladmins() {
		// TODO Auto-generated method stub
		return adminrepo.findAll();
	}
	
	@Override
	public List<Query> getqueries(){
		return qrepo.findAll();
		}

}
