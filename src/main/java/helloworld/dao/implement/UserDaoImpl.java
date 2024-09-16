package helloworld.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import helloworld.configs.DBConnectMySQL;
import helloworld.dao.IUserDao;
import helloworld.models.UserModel;

public class UserDaoImpl implements IUserDao{

	@Override
	public UserModel findByUserName(String username) {
		String sql="select * from users where username=?";
		
		try {
			Connection conn = new DBConnectMySQL().getDatabaseConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username); //truyen tham so
			ResultSet rs = ps.executeQuery(); // thuc thi phat bieu prepare roi dua ket qua vao resulset
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setFullname(rs.getString("fullname"));
				user.setRoleid(rs.getInt("roleid"));
				user.setAvatar(rs.getString("avatar"));
				user.setPhone(rs.getString("phone"));
//				user.setCreatedate(rs.getDate("createdate"));
				
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {

		try {

			IUserDao userDao = new UserDaoImpl();

			System.out.println(userDao.findByUserName("khang"));

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
	

}
