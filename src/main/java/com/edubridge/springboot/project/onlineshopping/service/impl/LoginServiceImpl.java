package com.edubridge.springboot.project.onlineshopping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edubridge.springboot.project.onlineshopping.entities.Login;
import com.edubridge.springboot.project.onlineshopping.repository.LoginRepository;
import com.edubridge.springboot.project.onlineshopping.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginRepository loginRepo;
	
	@Override
	public Login saveLogin(Login login) {
		
		return loginRepo.save(login);
	}

	@Override
	public List<Login> getAllLogin() {
		return loginRepo.findAll();
	}

	/*@Override
	public Login getLoginByid(int id) {
		return loginRepo.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Department with "+id+" not found"));
	}
	
	@Override
	public Department updateDepartment(int deptId,Department department) {
		Department d1=getDepartmentByid(deptId);
		d1.setDeptName(department.getDeptName());
		return departmentRepo.save(d1);
	}

	@Override
	public void deleteDepartment(int deptId) {
		//Department department= getDepartmentByid(deptId);
		departmentRepo.deleteById(deptId);
	}*/

}
