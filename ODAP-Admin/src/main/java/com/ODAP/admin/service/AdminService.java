package com.ODAP.admin.service;

import java.util.List;

import com.ODAP.admin.entity.AdminEntity;
import com.ODAP.admin.entity.Query;

public interface AdminService {
	
	public AdminEntity registerAdmin(AdminEntity admin);

	public List<AdminEntity>getalladmins();
	
	public List<Query>getqueries();
	
	public Query sendquery(Query query);
}
