package com.emc.services.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.emc.services.UserService;
import com.emc.userregistrations.getuserservices.GetUserRequest;
import com.emc.userregistrations.getuserservices.GetUserResponse;
import com.emc.userregistrations.saveuserservices.SaveUserRequest;
import com.emc.userregistrations.saveuserservices.SaveUserResponse;
@Endpoint
public class UserServiceEndpoint {
	
	private static final String GET_TARGET_NAMESPACE = "http://com/emc/userRegistrations/getUserServices";
	private static final String SAVE_TARGET_NAMESPACE = "http://com/emc/userRegistrations/saveUserServices";
	private static final String ALL_TARGET_NAMESPACE = "http://com/emc/userRegistrations/AllUserServices";
	
	
	@Autowired
	private UserService userService;
	
	  @PayloadRoot(localPart = "GetUserRequest", namespace = GET_TARGET_NAMESPACE)  
      public @ResponsePayload GetUserResponse getUserDetails(@RequestPayload GetUserRequest request)  
      {  
		  System.out.println("Get User !");
		  GetUserResponse response = new GetUserResponse();  
		  response.setUserDetails(userService.getUserDetails(request.getUserId()));
          return response;  
      } 
	  
	  @PayloadRoot(localPart = "SaveUserRequest", namespace = SAVE_TARGET_NAMESPACE)  
      public @ResponsePayload SaveUserResponse saveUserDetails(@RequestPayload SaveUserRequest request)  
      {  
		  System.out.println("Save User !");
		  SaveUserResponse response = new SaveUserResponse();  
		  response.setUserId(userService.saveUserDetails(request.getUserDetails()));
          return response;  
      }
	  
	  /*@PayloadRoot(localPart = "AllUserRequest", namespace = ALL_TARGET_NAMESPACE)  
      public @ResponsePayload GetAllUserResponse allUserDetails()  
      {  
		  System.out.println("Save User !");
		  GetAllUserResponse response = new GetAllUserResponse();  
		 // response.getUserDetails(userService.allUserDetails());
		  
          return response;  
      }*/

	public void setUserService(UserService userService_i) {
		this.userService = userService_i;
	} 
}
