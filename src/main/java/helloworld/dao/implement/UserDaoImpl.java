package helloworld.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import helloworld.configs.DBConnectMySQL;
import helloworld.dao.IUserDao;
import helloworld.models.UserModel;

public class UserDaoImpl implements IUserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public UserModel findByUserName(String username) {
	    String sql = "select * from users where username=?";
	    try (Connection conn = new DBConnectMySQL().getDatabaseConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        
	        ps.setString(1, username); // Truyền tham số
	        try (ResultSet rs = ps.executeQuery()) { // Thực thi và xử lý kết quả
	            if (rs.next()) {
	                UserModel user = new UserModel();
	                user.setId(rs.getInt("id"));
	                user.setUsername(rs.getString("username"));
	                user.setEmail(rs.getString("email"));
	                user.setPassword(rs.getString("password"));
	                user.setFullname(rs.getString("fullname"));
	                user.setRoleid(rs.getInt("roleid"));
	                user.setAvatar(rs.getString("avatar"));
	                user.setPhone(rs.getString("phone"));
	                user.setCreatedate(rs.getDate("createdate"));
	                return user;
	            }
	        }
	    } catch (SQLException | ClassNotFoundException e) {
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

	@Override
	public void insert(UserModel user) {
	    String sql = "INSERT INTO users (email, username, fullname, password, avatar, roleid, phone, createdate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	    try (Connection conn = new DBConnectMySQL().getDatabaseConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setString(1, user.getEmail());
	        ps.setString(2, user.getUsername());
	        ps.setString(3, user.getFullname());
	        ps.setString(4, user.getPassword()); // Nên mã hóa mật khẩu ở đây
	        ps.setString(5, user.getAvatar());
	        ps.setInt(6, user.getRoleid());
	        ps.setString(7, user.getPhone());
	        ps.setDate(8, user.getCreatedate());

	        int rowsInserted = ps.executeUpdate(); // Thực thi truy vấn
	        if (rowsInserted > 0) {
	            System.out.println("Người dùng được thêm thành công!");
	        } else {
	            System.out.println("Không thêm được người dùng.");
	        }
	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String query = "select * from users where email = ?";
		try {
			conn = new DBConnectMySQL().getDatabaseConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;

	}

	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String query = "select * from users where username = ?";
		try {
			conn = new DBConnectMySQL().getDatabaseConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean updatePasswordByEmail(String email, String newPassword) {
	    String sql = "UPDATE users SET password = ? WHERE email = ?";
	    try (Connection conn = new DBConnectMySQL().getDatabaseConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	         
	        ps.setString(1, newPassword);
	        ps.setString(2, email);
	        int rowsUpdated = ps.executeUpdate();
	        return rowsUpdated > 0; // Return true if password updated successfully
	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

}
