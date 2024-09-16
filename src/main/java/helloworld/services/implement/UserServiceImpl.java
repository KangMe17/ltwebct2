package helloworld.services.implement;

import helloworld.dao.IUserDao;
import helloworld.dao.implement.UserDaoImpl;
import helloworld.models.UserModel;
import helloworld.services.IUserService;

public class UserServiceImpl implements IUserService {

	IUserDao userDao = new UserDaoImpl();

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findByUserName(username);
		if (user != null && password.equals(user.getPassword())) {
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

	@Override
	public void insert(UserModel user) {
		userDao.insert(user);

	}

	@Override
	public boolean register(String email, String password, String username, String
			fullname, String phone) {
		if (userDao.checkExistUsername(username)) {
			return false;
		}
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		userDao.insert(new UserModel(username, email, password, fullname, null, 5, phone, date));
		return true;

	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);

	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);

	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);

	}

}
