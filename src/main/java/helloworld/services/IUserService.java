package helloworld.services;

import helloworld.models.UserModel;

public interface IUserService {
	
	UserModel findByUserName(String username);
	UserModel login(String username, String password);

}
