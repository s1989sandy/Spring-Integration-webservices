package com.emc.services;

import java.util.List;

import com.emc.userregistrations.User;


public interface UserService {

	public User getUserDetails(String userId);
	public String saveUserDetails(User user);
	public List<User> allUserDetails();
}
