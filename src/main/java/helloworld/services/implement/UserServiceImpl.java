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
	public boolean register(String username, String password, String email, String fullname, String phone) {
	    // Kiểm tra xem tài khoản hoặc email đã tồn tại chưa
	    if (userDao.checkExistUsername(username) || userDao.checkExistEmail(email)) {
	        return false;
	    }

	    // Lấy thời gian hiện tại để lưu vào cột created_at
	    long millis = System.currentTimeMillis();
	    java.sql.Date date = new java.sql.Date(millis);

	    // Thêm người dùng mới vào cơ sở dữ liệu
	    UserModel newUser = new UserModel(username, email, password, fullname, null, 5, phone, date);
	    userDao.insert(newUser);
	    
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
	
	@Override
	public void insert(UserModel user) {
		userDao.insert(user);

	}

	@Override
	public boolean updatePasswordByEmail(String email, String newPassword) {
		return userDao.updatePasswordByEmail(email, newPassword);
	}

}
