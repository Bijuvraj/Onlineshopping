package com.edubridge.springboot.project.onlineshopping.service;

import java.util.List;

import com.edubridge.springboot.project.onlineshopping.entities.Login;

public interface LoginService {

	public Login saveLogin(Login login);
	public List<Login> getAllLogin();
	/*public Login getLoginByid(int id);
	public Login updateLigin(int id, Login login);
	public void deleteLogin(int id);*/
}
