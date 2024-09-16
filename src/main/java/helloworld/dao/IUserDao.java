package helloworld.dao;

import helloworld.models.UserModel;

public interface IUserDao {
	
	//khai bao cac ham va thu tuc
	UserModel findByUserName(String username);

}
