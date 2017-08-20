package com.emc.dao;

import com.emc.userregistrations.User;

public interface UserDao {
	public User getUserDetails(String userId);
	public String saveUserDetails(User user);
}
