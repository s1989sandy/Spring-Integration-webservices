package com.emc.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.emc.userregistrations.User;
@Service
public class UserServiceImpl implements UserService{

	Map<String, User> map = new HashMap<String, User>();
	
	public User getUserDetails(String userId) {
		// TODO Auto-generated method stub
		if(!map.isEmpty()){
			return map.get(userId);
		}
		return null;
	}

	public String saveUserDetails(User user) {
		
		map.put(user.getUserId(), user);
		return user.getUserId();
	}

	public List<User> allUserDetails() {
		// TODO Auto-generated method stub
		return null;
	}

}
