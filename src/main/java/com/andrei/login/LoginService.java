package com.andrei.login;

public class LoginService {
	public boolean isUserValid(String user, String password) {
		if(user.equals("Andrei") && password.equals("111") ) {
			return true;
		}
		return false;
	}

}
