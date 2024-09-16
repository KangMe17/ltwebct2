package helloworld.services.implement;

import helloworld.dao.IUserDao;
import helloworld.dao.implement.UserDaoImpl;
import helloworld.models.UserModel;
import helloworld.services.IUserService;

public class UserServiceImpl implements IUserService{
	
	IUserDao userDao = new UserDaoImpl();
	
	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findByUserName(username);
		if (user != null && password.equals(user.getPassword())){
			return user;
		}
		
		return null;
		
	}
	
	@Override
	public UserModel findByUserName(String username) {
		return userDao.findByUserName(username);
	}
	
	public static void main(String[] args) {

		try {

			IUserService userService = new UserServiceImpl();

			System.out.println(userService.login("khang", "1234"));

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
